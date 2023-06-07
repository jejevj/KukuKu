import os
os.environ['TF_CPP_MIN_LOG_LEVEL'] = '2'

import io
import tensorflow as tf
from tensorflow import keras
import numpy as np
from PIL import Image

from flask import Flask, request, jsonify
from keras.utils import img_to_array
model = keras.models.load_model('./my_model.h5')

nail_class = ['Acral Lentiginous Melanoma', 'Beaus Line', 'Blue Finger', 'Clubbing', 'Healthy Nail', 'Koilonychia', 'Muehrckes Lines', 'Onychogryphosis', 'Pitting', 'Terry-s Nail']
description = []

image_dim = 224

def transform_image(pillow_image):
    data = img_to_array(pillow_image)
    data = np.expand_dims(data, axis = 0)
    data = data / 255.
    data = tf.image.resize(data, [image_dim, image_dim])
    
    return data


def predict(x):
    predictions = model(x)
    predictions = tf.nn.softmax(predictions)
    pred0 = predictions[0]
    label0 = np.argmax(pred0)
    return label0

def process_file(file):
    image_bytes = file.read()
    pillow_img = Image.open(io.BytesIO(image_bytes))
    tensor = transform_image(pillow_img)
    prediction = predict(tensor)
    return prediction

app = Flask(__name__)

@app.route("/", methods=["GET", "POST"])
def index():
    if request.method == "POST":
        file = request.files.get('file')
        if file is None or file.filename == "":
            return jsonify({"error": "no file"})

        try:
            prediction = process_file(file)
            print(nail_class[prediction])
            data = {"prediction": nail_class[prediction]}
            return jsonify(data)
        except Exception as e:
            return jsonify({"error": str(e)})

    return "OK"


if __name__ == "__main__":
    app.run(port=8080)
