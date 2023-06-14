# KukuKu Back-End
Back-End part of KukuKu Mobile App for Bangkit Capstone Project 2023

### Prerequisite
- Python
- Flask
- Google Cloud Platform


### Installation
1. Clone this repository
```
git clone -b cc https://github.com/jejevj/KukuKu
```
2. Navigate to project's directory
```
cd KukuKu
```
3. Install all dependencies
```
pip install -r requirements.txt
```
4. Run the application
```
python3 app.py
```
5. Lastly, open http://localhost:8080 <br><br>
Addition: To run the app succesfully, you need to download model first from storage we provided in Dockerfile. Store them into ml_model directory. Some configuration to access the database is needed.

### Deploy to Cloud Run
1. Make sure that you are in KukuKu repository and the same directory as the Dockerfile
2. Build the image to Container Registry
```
gcloud run build gcr.io/$GOOGLE_CLOUD_PROJECT/backend-api
```
3. Deploy the app
```
gcloud run deploy --image gcr.io/$GOOGLE_CLOUD_PROJECT/backend-api --region asia-southeast2 --allow-unauthenticated --platform managed
```
### Endpoint
**/predict** <br>
Method: `POST`
Parameters: 
- file (image)
