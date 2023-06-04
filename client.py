from google.cloud import storage
from google.oauth2 import service_account
import os


client = storage.Client()
bucket_name = os.environ.get('BUCKET_NAME')
bucket = client.bucket(bucket_name)