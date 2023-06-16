# CC Implementations

### Google Cloud Platform
1. Service Account

We have created service account with least privileges.

![image](https://github.com/jejevj/KukuKu/assets/72397657/de1c52b0-259e-4a96-bcc9-efdd0f5973df)

2. Secret Manager

Using Secret Manager to manage service account keys to access Cloud Storage Bucket

![image](https://github.com/jejevj/KukuKu/assets/72397657/f0da62e5-53a3-4743-9f81-fc9a8ee4cf24)

3. Cloud Build

We used Cloud Build to build our image and upload it to Container Registry.

4. Cloud Run

We deployed our API on Cloud Run.

![image](https://github.com/jejevj/KukuKu/assets/72397657/7547e3b7-e552-4ad4-b86b-f8a7070632af)

5. SQL Connectivity Tests

We have configured SQL Connectivity Test to make sure the Cloud Run service is connected to the SQL instance.

![image](https://github.com/jejevj/KukuKu/assets/72397657/38fca8c4-b4f3-431b-a056-0bce8801c9bf)

6. Serverless VPC Connector

In order to facilitate connection between Cloud Run service and SQL instance, we used Serverless VPC Connector.

![image](https://github.com/jejevj/KukuKu/assets/72397657/a85f01a9-86d9-48e5-a0d3-e260d32c14e7)

7. Cloud Storage

We used Cloud Storage buckets to store our images and models.

![image](https://github.com/jejevj/KukuKu/assets/72397657/68e6609d-f25f-49dd-89f6-5b64310ee53b)

8. Cloud Build Triggers

We implemented Continous Deployment using Cloud Build Triggers.

![image](https://github.com/jejevj/KukuKu/assets/72397657/28a4623b-467e-4c52-b9cb-8e8e50f84538)

