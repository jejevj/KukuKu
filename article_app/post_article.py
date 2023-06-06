#import library
from datetime import datetime
import pytz
from google.oauth2 import service_account
from google.cloud import storage

credentials = service_account.Credentials.from_service_account_file('key.json')

client = storage.Client(credentials=credentials)
bucket_name = 'kukuku-capstone-project-upload'
bucket = client.bucket(bucket_name)

def get_time():
    tz = pytz.timezone("Asia/Jakarta")
    now = datetime.now()
    local_now = tz.localize(now)
    date_time = local_now.strftime("%Y-%m-%d %H:%M:%S")
    file_date_time = local_now.strftime("%Y-%m-%d-%H:%M:%S")
    return date_time, file_date_time

def upload_to_bucket(file_date_time, file):
    folder_path = 'artikel'
    file_name = folder_path + '/' + file_date_time + '-' + file.filename

    blob = bucket.blob(file_name)
    blob.upload_from_file(file)
    print("File successfully uploaded to bucket.")

    image_path = 'https://storage.googleapis.com/' + bucket_name + '/' + file_name
    return image_path

