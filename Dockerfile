FROM python:3.9-slim-bullseye

WORKDIR /app

RUN pip install --upgrade pip

RUN apt-get update && apt-get install -y curl

RUN mkdir -p /app/ml_model

RUN curl -o /app/ml_model/keras_model.h5 https://storage.googleapis.com/capstone-project-c23-ps120-ml-model/keras_model.h5 || True

RUN curl -o /app/ml_model/my_model.h5 https://storage.googleapis.com/capstone-project-c23-ps120-ml-model/my_model.h5 || True

COPY requirements.txt .

RUN pip install -r requirements.txt

COPY . .

CMD ["python", "app.py"]