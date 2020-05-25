CREATE USER 'hbstudent'@'%' IDENTIFIED BY 'hbstudent';

GRANT ALL PRIVILEGES ON * . * TO 'hbstudent'@'%';

ALTER USER 'hbstudent'@'%' IDENTIFIED WITH mysql_native_password BY 'hbstudent';