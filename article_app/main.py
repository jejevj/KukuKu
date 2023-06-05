from flask import Flask, jsonify, request, json
from google.cloud import storage
from db_connect import db_connection
from google.oauth2 import service_account
import os
from flask import Flask, render_template, jsonify
from datetime import datetime

credentials = service_account.Credentials.from_service_account_file('key.json')

client = storage.Client(credentials=credentials)
bucket_name = 'kukuku-capstone-project-upload'
bucket = client.bucket(bucket_name)


def download_image_from_storage(bucket_name, file_name):
    blob = bucket.blob(file_name)
    temp_image_path = '/tmp/' + file_name
    blob.download_to_filename(temp_image_path)
    return temp_image_path


app = Flask(__name__)


@app.route('/')
def home_base():
    return jsonify({'message': 'server is running'})
 
    
@app.route('/postarticle', methods=['POST'])
def post_article():
    title = request.form.get('judul')
    content = request.form.get('isi')
    file = request.files.get('file')

    if title is None:
        return jsonify({'message': 'judul tidak boleh kosong'}), 400
    if content is None:
        return jsonify({'message': 'isi artikel tidak boleh kosong'}), 400
    if file is None:
        return jsonify({'message': 'no file uploaded'}), 400
    
    now = datetime.now()
    date_time = now.strftime("%Y-%m-%d %H:%M:%S")

    folder_path = 'artikel'
    file_name = folder_path + '/' + date_time + '-' + file.filename
    blob = bucket.blob(file_name)
    
    
    blob.upload_from_file(file)
    print("File successfully uploaded to bucket.")

    image_path = 'https://storage.googleapis.com/' + bucket_name + '/' + file_name
    
    
    try:
        connection = db_connection()
        
        try:
            with connection.cursor() as cursor:
                print(image_path)
                sql = f"INSERT INTO artikel (judul, isi, tanggal, storage_url) VALUES ('{title}','{content}', '{date_time}', '{image_path}');"
                print(sql)
                ret = cursor.execute(sql)
                cursor.fetchall()
                print('pass here ?')
        finally:
            connection.close()
        
         
        return jsonify({'data': ret}), 200
    except Exception as e:
        return jsonify({'error': str(e)}), 500
    
        
@app.route('/getarticle', methods=['GET'])
def get_article():
    
    connection = db_connection()
    
    try:
        with connection.cursor() as cursor:
            sql = f"SELECT * FROM artikel;"
            cursor.execute(sql)
            result = cursor.fetchall()
            
            response = {
                'data': result
            }
    finally:
        connection.close()
        
    return jsonify(response)


if __name__ == '__main__':
    server_port = os.environ.get('PORT', '8080')
    app.run(debug=True, port=server_port, host='0.0.0.0')
