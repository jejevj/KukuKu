from flask import Flask
from routes import home, predict
import os


app = Flask(__name__)


app.route('/', methods=['GET'])(home)
app.route('/predict', methods=['POST'])(predict)


if __name__ == '__main__':
    server_port = os.environ.get('PORT', '8080')
    app.run(debug=True, port=server_port, host='0.0.0.0')