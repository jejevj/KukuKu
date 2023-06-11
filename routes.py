from flask import jsonify, request
from tensorflow.keras.preprocessing import image
import os
import numpy as np

# Modul lokal
from model import model1, model2
from db_connect import db_connection
from client import bucket

def download_image_from_storage(file_name, folder_name):
    blob = bucket.blob(os.path.join(folder_name, file_name))
    temp_image_path = '/tmp/' + file_name
    blob.download_to_filename(temp_image_path)
    return temp_image_path

def transform_image(file_image):
    img = image.load_img(file_image, target_size=(224, 224))
    img_array = image.img_to_array(img)
    img_array = np.expand_dims(img_array, axis=0)
    img_array /= 255.
    return img_array

def predict_image(image, model):
    prediction = model.predict(image)
    return prediction

def home():
    response = jsonify({'message': 'Server is running'})
    return response, 200

def predict():
    file = request.files.get('file')
    
    if file is None:
        response = jsonify({'message': 'No file uploaded'})
        return response, 400
    
    # Menguload gambar ke Cloud Storage
    folder_name = 'nail_images'
    blob = bucket.blob(os.path.join(folder_name ,file.filename))
    blob.upload_from_file(file)
    
    nail_classes = ['Acral Lentiginous Melanoma', "Beau's Line", 'Blue Finger', 'Clubbing', 'Healthy Nail', 'Koilonychia', "Muehrcke's Lines", 'Onychogryphosis', 'Pitting', 'Terry Nails']
    
    try:
        image_path = download_image_from_storage(file.filename, folder_name)
        prediction = predict_image(transform_image(image_path), model1)
        predicted_class = np.argmax(prediction)
        
        if predicted_class == 0:
            prediction = predict_image(transform_image(image_path), model2)
            predicted_class = np.argmax(prediction)
            prediction_label = nail_classes[predicted_class]
            accuracy = prediction[0][predicted_class] * 100.0
            
            connection = db_connection()
            
            try:
                with connection.cursor() as cursor:
                    sql = f"SELECT nama_penyakit, deskripsi, gejala, resiko, tips FROM jenis_penyakit_kuku WHERE nama_penyakit = '{prediction_label}';"
                    cursor.execute(sql)
                    result = cursor.fetchall()
                    
                    nama_penyakit = result[0]['nama_penyakit']
                    deskripsi = result[0]['deskripsi']
                    gejala = result[0]['gejala']
                    resiko = result[0]['resiko']
                    tips = result[0]['tips']
                    
                    data = {
                        'nama_penyakit': nama_penyakit,
                        'deskripsi': deskripsi,
                        'gejala': gejala,
                        'resiko': resiko,
                        'tips': tips
                    }
                    
                    response = {
                        'result': 'nail',
                        'prediction': prediction_label,
                        'accuracy': accuracy,
                        'data': data
                    }
            finally:
                connection.close()
        else:
            response = {
                'result': 'unrecognized'
            } 
        os.remove(image_path)
        return jsonify(response), 200
    
    
    
    except Exception as e:
        return jsonify({'error': str(e)}), 500