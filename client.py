from google.cloud import storage
import os


client = storage.Client()
bucket_name = 'kukuku-capstone-project-upload'
bucket = client.bucket(bucket_name)