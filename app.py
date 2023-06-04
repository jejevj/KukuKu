# from flask import Flask, jsonify, request
# from google.cloud import storage
# from db_connect import db_connection
# from google.oauth2 import service_account
# import os
# from flask import Flask, jsonify
# import tensorflow as tf
# import numpy as np
# from tensorflow.keras.preprocessing import image

# model1 = tf.keras.models.load_model('ml_model/keras_model.h5')
# model2 = tf.keras.models.load_model('ml_model/my_model.h5')

# credentials = service_account.Credentials.from_service_account_file('key.json')

# client = storage.Client(credentials=credentials)
# bucket_name = 'kukuku-capstone-project-upload'
# bucket = client.bucket(bucket_name)

# def download_image_from_storage(bucket_name, file_name):
#     blob = bucket.blob(file_name)
#     temp_image_path = '/tmp/' + file_name
#     blob.download_to_filename(temp_image_path)
#     return temp_image_path

# def transform_image(file_image):
#     img = image.load_img(file_image, target_size=(224, 224))
#     img_array = image.img_to_array(img)
#     img_array = np.expand_dims(img_array, axis=0)
#     img_array /= 255.
#     return img_array
    
# def predict_image(image, model):
#     prediction = model.predict(image)
#     return prediction


# app = Flask(__name__)


# @app.route('/')
# def home_base():
#     return jsonify({'message:' 'server is running'})
 
    
# @app.route('/predict', methods=['POST'])
# def predict():
#     file = request.files.get('file')
#     if file is None:
#         return jsonify({'message': 'no file uploaded'}), 400
    
#     blob = bucket.blob(file.filename)
#     blob.upload_from_file(file)
                                                                                                                                                                                                                                                                                                                                                                                                
#     nail_conditions = ['Acral Lentiginous Melanoma', 'Beaus Line', 'Blue Finger', 'Clubbing', 'Healthy Nail', 'Koilonychia', 'Muehrckes Lines', 'Onychogryphosis', 'Pitting', 'Terry-s Nail']
    
#     try:
#         image_path = download_image_from_storage(bucket_name, file.filename)

#         prediction = predict_image(transform_image(image_path), model1)
#         predicted_class = np.argmax(prediction)
        
#         if predicted_class == 0:
#             prediction = predict_image(transform_image(image_path), model2)
#             predicted_class = np.argmax(prediction)
#             prediction_label = nail_conditions[predicted_class]
#             accuracy = prediction[0][predicted_class] * 100.0
            
#             connection = db_connection()
            
#             try:
#                 with connection.cursor() as cursor:
#                     sql = f"SELECT deskripsi, tips FROM penyakit WHERE nama_penyakit = '{prediction_label}';"
#                     cursor.execute(sql)
#                     result = cursor.fetchall()
#                     description = result[0]['deskripsi']
#                     tips = result[0]['tips'].split('\n\n')

#                     response = {
#                         'result': 'nail',
#                         'prediction': prediction_label,
#                         'accuracy': accuracy,
#                         'description': description,
#                         'tips': tips
#                     }
#             finally:
#                 connection.close()
#         else:
#             response = {
#                 'result': 'unrecognized'
#             }
#         os.remove(image_path) 
#         return jsonify(response)
#     except Exception as e:
#         return jsonify({'error': str(e)}), 500
    
        
# @app.route('/data', methods=['GET'])
# def get_data():
    
#     connection = db_connection()
    
#     try:
#         with connection.cursor() as cursor:
#             sql = f"SELECT * FROM penyakit_kuku;"
#             cursor.execute(sql)
#             result = cursor.fetchall()
            
#             response = {
#                 'data': result
#             }
#     finally:
#         connection.close()
        
#     return jsonify(response)

from flask import Flask
from routes import home, predict
import os


app = Flask(__name__)


app.route('/', methods=['GET'])(home)
app.route('/predict', methods=['POST'])(predict)


if __name__ == '__main__':
    server_port = os.environ.get('PORT', '8080')
    app.run(debug=True, port=server_port, host='0.0.0.0')