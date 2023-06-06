from google.cloud import storage
import os


client = storage.Client()
bucket_name = os.environ.get('BUCKET_NAME')
bucket = client.bucket(bucket_name)