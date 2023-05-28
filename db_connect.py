import pymysql
import os


def db_connection():
    try:
        connection = pymysql.connect(
            host='34.101.67.31',
            user='',
            password='',
            database='kukuku_db',
            charset='utf8mb4',
            cursorclass=pymysql.cursors.DictCursor
        )
        print('Connected to the MySQL database')
        return connection
    except pymysql.Error as e:
        print(f'Error connecting to the MySQL database {e}')
        return None