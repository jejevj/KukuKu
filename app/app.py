from google.cloud import storage
from google.oauth2 import service_account
from flask import Flask, request, jsonify

app = Flask(__name__)


credentials = service_account.Credentials.from_service_account_file(
   './keys.json')
print(credentials)

client = storage.Client(credentials=credentials)

bucket_name = 'keen-emblem-381213-bucket'
bucket = client.bucket(bucket_name)

@app.route('/', methods=['GET'])
def home():
    return 'Success'


@app.route('/upload', methods=['POST'])
def upload_file():
    print(request)
    file = request.files['image']
    blob = bucket.blob(file.filename)
    blob.upload_from_file(file)
    return {'message': 'File uploaded successfully.'}, 201


@app.route('/files', methods=['GET'])
def list_files():
    # files = []
    urls = []

    for blob in bucket.list_blobs():
        # files.append(blob.name)
        url = blob.public_url
        urls.append(url)
    return jsonify({
        # 'files': files,
        'public_url' : urls  
    })

if __name__ == '__main__':
    app.run(debug=True)