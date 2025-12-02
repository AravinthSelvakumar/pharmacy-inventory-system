📦 Pharmacy Inventory System

A Java-based console application for managing pharmacy inventory with features like CRUD operations, expiry alerts, low-stock detection, purchases, and automatic deletion of expired medicines.
Built using Core Java, JDBC, MySQL, and structured using a clean DAO + Service + Model architecture.

🚀 Features
🏥 Medicine Management

Add new medicines

View all medicines

Update stock, price, and expiry date

Delete medicines

Delete all expired medicines automatically

⚠ Smart Alerts

Expiry Alerts: Show medicines expiring within the next 30 days

Low Stock Alerts: Detect medicines with stock less than 10

Purchase Module: Deduct purchased quantity & show warnings

📂 Clean Architecture (Interview Friendly)

App (Presentation Layer) – Handles user menu

Service Layer – Business logic

DAO Layer – Database operations

Model Layer – POJOs

Utility Layer – Database connection

🏗 Project Structure
PharmacyInventorySystem/
│
├── src/
│   ├── com/app/App.java
│   ├── com/service/InventoryService.java
│   ├── com/dao/MedicineDAO.java
│   ├── com/model/Medicine.java
│   ├── com/util/DBConnection.java
│   └── module-info.java
│
├── lib/
│   └── mysql-connector-j.jar
│
├── .classpath
├── .project
└── README.md

🛢 Database Setup
1. Create Database
CREATE DATABASE pharmacy;
USE pharmacy;

2. Create Table
CREATE TABLE medicine (
    medicine_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    batch_no VARCHAR(50),
    category VARCHAR(50),
    price DOUBLE,
    stock INT,
    expiry_date DATE,
    supplier_id INT
);

⚙️ Configuration

Edit your MySQL username & password in:

src/com/util/DBConnection.java

private static final String USER = "root";
private static final String PASS = "your_password";


Also ensure you add MySQL Connector JAR to the classpath.

▶️ How to Run
Using Eclipse

Import project → Existing Java Project

Add MySQL JDBC JAR to the Build Path

Run App.java

Using Terminal
javac -cp .;mysql-connector-j.jar src/com/app/App.java
java -cp .;mysql-connector-j.jar com.app.App

🧩 Modules Explained
1. DBConnection

Handles MySQL connection using JDBC.

2. MedicineDAO

CRUD operations + extra features:

getLowStockMedicines

getExpiringWithinDays

deleteExpiredMedicines

3. InventoryService

Manages:

User input

Business logic

Menu navigation

4. App

Entry point of the application.

🛠 Technology Stack

Java 21

JDBC

MySQL

Eclipse

DAO Design Pattern

OOP Principles

📜 Future Improvements (Optional)

You can add these to impress interviewers:

JavaFX GUI

Supplier management module

Sales & billing module

PDF invoice generation

Login/authentication

REST API using Spring Boot

Web UI using React
