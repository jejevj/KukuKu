GOOGLE_CLOUD_PROJECT="capstone-project-app-387808"

API_NAME="model-api-run"

gcloud builds submit \
  --tag gcr.io/$GOOGLE_CLOUD_PROJECT/$API_NAME

gcloud run deploy pdf-converter \
  --image gcr.io/$GOOGLE_CLOUD_PROJECT/$API_NAME \
  --platform managed \
  --region us-central1 \
  --cpu=8 \
  --memory=16Gi \
  --allow-unauthenticated \
  --min-instances=1
