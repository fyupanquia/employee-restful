CREATE DATABASE ems;
use ems;

CREATE TABLE employees(
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);