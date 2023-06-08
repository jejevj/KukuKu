# Import Library
import tensorflow as tf
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
plt.style.use('ggplot')
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Flatten
from tensorflow.keras.callbacks import LearningRateScheduler


def train_val_generators(TRAINING_DIR, VALIDATION_DIR):
  
  tf.random.set_seed(42)
  
  train_datagen = ImageDataGenerator(
    rescale=1./255,
    shear_range=0.2,
    zoom_range=0.2,
    horizontal_flip=True,
    vertical_flip=True,
    rotation_range=0.2,
    fill_mode='nearest' 
)

  train_generator = train_datagen.flow_from_directory(directory=TRAINING_DIR,
                                                      batch_size=64,
                                                      class_mode='categorical',
                                                      target_size=(224, 224),
                                                      seed = 42)

  validation_datagen = ImageDataGenerator(rescale = 1./255.)

  validation_generator = validation_datagen.flow_from_directory(directory=VALIDATION_DIR,
                                                                batch_size= 64,
                                                                class_mode='categorical',
                                                                target_size=(224, 224),
                                                                seed = 42)
  return train_generator, validation_generator


def lr_scheduler(epoch, learning_rate):
    if epoch < 10:
        return learning_rate
    else:
        return learning_rate * tf.math.exp(-0.1)


def create_model():
    base_model = tf.keras.applications.MobileNetV2(input_shape=(224, 224, 3),
                                               include_top=False,
                                               weights='imagenet')
    
    for layer in base_model.layers:
        layer.trainable = False
    
    model = Sequential()
    model.add(base_model)
    model.add(Flatten())
    model.add(Dense(512, activation='relu'))
    model.add(Dense(10, activation='softmax'))
    model.compile(optimizer= tf.keras.optimizers.Adam(),
                loss= 'categorical_crossentropy',
                metrics=['accuracy']) 
    return model


def main():
    
    # Define a training and testind dir and do image augmentation
    TRAINING_DIR = "./dataset/train/"
    VALIDATION_DIR = "./dataset/valid/"
    train_generator, validation_generator = train_val_generators(TRAINING_DIR, VALIDATION_DIR)
    
    # Define a model architecture
    model = create_model()
    callback = tf.keras.callbacks.EarlyStopping(monitor='loss', patience=5)
    lr_callback = LearningRateScheduler(lr_scheduler)
    model.summary()
    
    #Training model
    history = model.fit(train_generator,
                    validation_data=validation_generator,
                    epochs=20,
                    callbacks=[lr_callback, callback])
    
    # Plot the chart for accuracy and loss on both training and validation
    acc = history.history['accuracy']
    val_acc = history.history['val_accuracy']
    loss = history.history['loss']
    val_loss = history.history['val_loss']
    epochs = range(len(acc))
    plt.plot(epochs, acc, 'r', label='Training accuracy')
    plt.plot(epochs, val_acc, 'b', label='Validation accuracy')
    plt.title('Training and validation accuracy')
    plt.legend()
    plt.figure()
    plt.plot(epochs, loss, 'r', label='Training Loss')
    plt.plot(epochs, val_loss, 'b', label='Validation Loss')
    plt.title('Training and validation loss')
    plt.legend()
    plt.show()
    
    # Save the model
    export_dir = 'saved_model/my_model.h5'
    model.save(export_dir)
    

if __name__ == "__main__":
    main()
