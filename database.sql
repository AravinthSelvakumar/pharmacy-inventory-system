CREATE DATABASE pharmacy;
USE pharmacy;

CREATE TABLE medicine (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    quantity INT,
    price DOUBLE
);
