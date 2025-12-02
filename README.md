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

## 📂 Project Structure

```
PharmacyInventorySystem/
|-- src/
|   |-- com/app/App.java
|   |-- com/service/InventoryService.java
|   |-- com/dao/MedicineDAO.java
|   |-- com/model/Medicine.java
|   |-- com/util/DBConnection.java
|   `-- module-info.java
|
|-- lib/
|   `-- mysql-connector-j.jar
|
|-- .classpath
|-- .project
`-- README.md
```

*(ASCII version → 100% safe, will never break in GitHub)*

---

## 🛠️ Technologies Used

- **Java (Core Java)**
- **JDBC**
- **MySQL Database**

---

## ⚙️ Setup Instructions

### **1. Clone the repository**
```bash
git clone https://github.com/AravinthSelvakumar/pharmacy-inventory-system.git
```

### **2. Create MySQL database**
```sql
CREATE DATABASE pharmacy;
USE pharmacy;

CREATE TABLE medicine (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    quantity INT,
    price DOUBLE
);
```

### **3. Update DB credentials**
In `DBConnection.java`, change your:
- URL  
- USERNAME  
- PASSWORD  

### **4. Compile and Run the project**
```bash
javac *.java
java PharmacyInventorySystem
```

---

## 📸 Sample Output

```
===== Pharmacy Inventory System =====
1. Add Medicine
2. View Medicines
3. Update Medicine
4. Delete Medicine
5. Exit
Enter your choice:
```

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

