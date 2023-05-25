DROP USER IF EXISTS 'springstudent'@'localhost';

CREATE USER 'springstudent'@'localhost' identified BY 'springstudent';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'localhost';