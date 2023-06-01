import pymysql
import os


def db_connection():
    try:
        connection = pymysql.connect(
            host = os.environ.get('DB_HOST'),
            user = os.environ.get('DB_USER'),
            password = os.environ.get('DB_PASSWORD'),
            database = os.environ.get('DB_NAME'),
            charset = 'utf8mb4',
            cursorclass = pymysql.cursors.DictCursor
        )
        print('Connected to the MySQL database')
        return connection
    except pymysql.Error as e:
        print(f'Error connecting to the MySQL database: {e}')
        return None