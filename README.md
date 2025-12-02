# Pharmacy Inventory System

A simple Java-based Pharmacy Inventory Management application using JDBC and MySQL.  
This project performs basic CRUD operations such as adding, viewing, updating, and deleting medicine records.

---

## 🚀 Features

- Add new medicine
- View all medicines
- Update existing medicine details
- Delete a medicine by ID
- MySQL database connectivity using JDBC
- Clean and simple console-based UI

---

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


## 🛠️ Technologies Used

- **Java (Core Java)**
- **JDBC**
- **MySQL Database**

---

## ⚙️ Setup Instructions

### 1. Clone the repository


git clone https://github.com/AravinthSelvakumar/pharmacy-inventory-system.git


### 2. Create MySQL database


CREATE DATABASE pharmacy;
USE pharmacy;

CREATE TABLE medicine (
id INT PRIMARY KEY,
name VARCHAR(50),
quantity INT,
price DOUBLE
);


### 3. Update DB credentials  
In `DBConnection.java`, change your:


URL
USERNAME
PASSWORD


### 4. Compile and Run the project


javac *.java
java PharmacyInventorySystem


---

## 📸 Sample Output



===== Pharmacy Inventory System =====

Add Medicine

View Medicines

Update Medicine

Delete Medicine

Exit
Enter your choice:


---

## 👨‍💻 Author

**Aravinth Selvakumar**  
GitHub: https://github.com/AravinthSelvakumar

---

## ⭐ Contribution

Feel free to fork this repo and submit pull requests!

---

## 📜 License

This project is open-source and free to use.

🔥 Tips to Avoid Formatting Errors

✔ Copy only from the triple-backtick (```) block
✔ Do not copy from the preview
✔ Paste directly in GitHub's Markdown editor
✔ GitHub recognizes Markdown automatically
✔ Use Preview before committing
