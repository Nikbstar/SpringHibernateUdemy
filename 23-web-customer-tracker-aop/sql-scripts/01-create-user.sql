CREATE USER 'springstudent'@'%' IDENTIFIED BY 'springstudent';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';

ALTER USER 'springstudent'@'%' IDENTIFIED WITH mysql_native_password BY 'springstudent';