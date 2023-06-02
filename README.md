# Nail Disease Classification Using Convolutional Neural Network

Create a machine learning model that can detect both healthy and unhealthy nails. The machine learning team will create the detection model using the convolutional neural network (CNN) algorithm and then we will deploy it using Tensorflow lite.

## Machine Learning Engineer Team

- [Pingkan Stephanie Sepang](https://github.com/pingkanss)
- [Putri Aulia Savitri](https://github.com/putriaulias)
- [Muhammad Reesa Rosyid](https://github.com/reesarosyid)

## Roadmap

- Collecting dataset image from (https://universe.roboflow.com/knm/nail-disease-detection-mxoqy/dataset/1)

- Extract the dataset and carry out the exploratory data analysis process.

- Creating the CNN algorithm architecture for model training.

- Training dataset based on the architecture that has been made.

- Checking model evaluation has been made based on accuracy and loss.

- Hypertuning model architecture to get the best model.

- Save the model.

## Directory Structure

- **eda.ipynb** is a jupyter notebook has contains script for unziping dataset and exploratory data analysis process.
- **modeling.py** is a python script has contains function  can declarating architecture cnn algorithm,training process and evaluate model.
- **convert_model.py** is a python script has contains a function which can convert model h5 format to tflite format.
- **inference_model.ipynb** is a jupyter notebook has contains function can be trying the model using other image from outside the dataset.
- **Inference_model** is a folder contains a image for testing inference_model.ipynb.
- **saved_models.rar** is a rar format contains save model.

## References
- Tensorflow Documentation: https://www.tensorflow.org/api_docs/python/tf
- Journal Classification of Diseases Based on Nail Color Using Digital Signal Processing: https://openlibrarypublications.telkomuniversity.ac.id/index.php/engineering/article/view/18989 
- References nails disease each classes:
    - Beau’s Line: https://hellosehat.com/penyakit-kulit/perawatan-kuku/garis-beau-pada-kuku/
    - Terry Nails: https://hellosehat.com/penyakit-kulit/perawatan-kuku/kuku-terry/
    - Onychomicosis: https://www.halodoc.com/kesehatan/onychomicosis-jamur-kuku
    - Koilonychia: https://www.alodokter.com/koilonychia-kenali-penyebab-dan-pencegahannya
    - Blue Finger: https://www.honestdocs.id/kuku-jari-biru
    - Pitting: https://www.klikdokter.com/info-sehat/kulit/kenali-nail-pitting-penyebab-kuku-berlubang-dan-bergelombang
    - Clubbing Finger: https://www.alodokter.com/clubbing-finger
    - Muehrcke's nails: https://hellosehat.com/penyakit-kulit/perawatan-kuku/garis-mees-pada-kuku/
    - Acral Lentiginous Melanoma: https://hellosehat.com/kanker/kanker-kulit/garis-hitam-di-kuku-melanoma-subungual/
    - Healthy Nail: https://www.klikdokter.com/info-sehat/kulit/coba-dicek-ini-ciri-ciri-kuku-yang-sehat
