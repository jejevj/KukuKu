GOOGLE_CLOUD_PROJECT="capstone-project-app-387808"
REGION="us-central1"
API_NAME="model-api-run"

gcloud builds submit \
  --tag gcr.io/$GOOGLE_CLOUD_PROJECT/$API_NAME

gcloud run deploy $API_NAME \
  --image gcr.io/$GOOGLE_CLOUD_PROJECT/$API_NAME \
  --platform managed \
  --region $REGION \
  --cpu=1 \
  --memory=2Gi \
  --allow-unauthenticated \
  --min-instances=1
