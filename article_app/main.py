#import module
from db_connect import db_connection
from post_article import get_time, upload_to_bucket

#import library
from flask import Flask, request, jsonify
import os


app = Flask(__name__)


@app.route('/')
def homebase():
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
    
    date_time, file_date_time = get_time()

    image_path = upload_to_bucket(file_date_time, file)
    
    
    try:
        connection = db_connection()
        
        try:
            with connection.cursor() as cursor:
                sql = f"INSERT INTO kukuku_db.artikel (judul, isi, tanggal, storage_url) VALUES ('{title}','{content}', '{date_time}', '{image_path}');"
                cursor.execute(sql)
                connection.commit()

                sql = f"SELECT * FROM artikel ORDER BY artikel_id DESC LIMIT 1;"
                cursor.execute(sql)
                result = cursor.fetchall()
                
                response = {
                    'data': result
                }
        finally:
            connection.close()
        
        return jsonify(response)
    except Exception as e:
        return jsonify({'error': str(e)}), 500
        
@app.route('/getarticle', methods=['GET'])
def get_article():
    connection = db_connection()
    
    try:
        with connection.cursor() as cursor:
            sql = f"SELECT * FROM artikel ORDER BY artikel_id DESC LIMIT 10;"
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
