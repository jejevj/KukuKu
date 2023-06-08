# Import Library
import tensorflow as tf
import pathlib
import tensorflow_model_optimization as tfmot

def main():
    model1 = tf.keras.models.load_model('./saved_models/my_model.h5')
    model2 = tf.keras.models.load_model('./saved_models/keras_model.h5')
    
    # Convert model 1
    converter = tf.lite.TFLiteConverter.from_keras_model(model1)  # Use `model` instead of `q_aware_model` if you skipped optimization
    tflite_model = converter.convert()
    tflite_model_file = pathlib.Path('./saved_models/my_model.tflite')
    tflite_model_file.write_bytes(tflite_model)
    
    # Convert model 2
    converter = tf.lite.TFLiteConverter.from_keras_model(model2)  # Use `model` instead of `q_aware_model` if you skipped optimization
    tflite_model = converter.convert()
    tflite_model_file = pathlib.Path('./saved_models/keras_model.tflite')
    tflite_model_file.write_bytes(tflite_model)

if __name__ == "__main__":
    main()