from google.cloud import storage
from google.oauth2 import service_account

credential = service_account.Credentials.from_service_account_file('key.json')
client = storage.Client(credentials=credential)
bucket_name = 'kukuku-capstone-project-upload'
bucket = client.bucket(bucket_name)