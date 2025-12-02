-- Create database
CREATE DATABASE pharmacy;
USE pharmacy;

-------------------------------------------------------------
-- Supplier Table
-------------------------------------------------------------
CREATE TABLE supplier (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    contact VARCHAR(50),
    address VARCHAR(255)
);

-------------------------------------------------------------
-- Medicine Table
-------------------------------------------------------------
CREATE TABLE medicine (
    medicine_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    batch_no VARCHAR(50),
    category VARCHAR(50),
    price DOUBLE,
    stock INT,
    expiry_date DATE,
    supplier_id INT,
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
);

-------------------------------------------------------------
-- Insert Sample Data (Suppliers)
-------------------------------------------------------------
INSERT INTO supplier (name, contact, address) VALUES
('Acme Pharma', '9876543210', 'Bangalore'),
('MedLife Distributors', '9123456780', 'Chennai'),
('HealthPlus Pharma', '9988776655', 'Hyderabad'),
('WellCare Medicines', '9090909090', 'Mumbai'),
('CureWell Pharmaceuticals', '7788996655', 'Delhi'),
('BioMed Supplies', '9900112233', 'Pune'),
('LifeSaver Drugs', '8888999900', 'Kolkata'),
('NovaHeal Pharma', '9665544332', 'Coimbatore'),
('GreenLeaf Pharma', '9556677889', 'Mysore'),
('PrimeCure Suppliers', '9001122334', 'Trichy');

-------------------------------------------------------------
-- Insert Sample Data (Medicines)
-------------------------------------------------------------
INSERT INTO medicine (name, batch_no, category, price, stock, expiry_date, supplier_id) VALUES
('Paracetamol 500mg', 'B001', 'Analgesic', 25.0, 50, '2026-05-01', 1),
('Ibuprofen 400mg', 'B002', 'Pain Relief', 40.0, 60, '2026-06-15', 2),
('Amoxicillin 250mg', 'B003', 'Antibiotic', 85.0, 30, '2025-12-20', 3),
('Azithromycin 500mg', 'B004', 'Antibiotic', 120.0, 45, '2026-01-10', 4),
('Cetirizine 10mg', 'B005', 'Allergy', 15.0, 80, '2027-03-05', 5),
('Dolo 650mg', 'B006', 'Analgesic', 30.0, 100, '2027-07-15', 1),
('Metformin 500mg', 'B007', 'Diabetes', 55.0, 70, '2026-11-25', 6),
('Atorvastatin 10mg', 'B008', 'Cholesterol', 95.0, 40, '2027-09-30', 7),
('Pantoprazole 40mg', 'B009', 'Acidity', 48.0, 90, '2027-02-11', 8),
('Ranitidine 150mg', 'B010', 'Acidity', 35.0, 65, '2025-10-20', 9),
('Ciprofloxacin 500mg', 'B011', 'Antibiotic', 110.0, 50, '2026-12-12', 10),
('Vitamin C 500mg', 'B012', 'Supplement', 60.0, 120, '2027-04-01', 1),
('Calcium 500mg', 'B013', 'Supplement', 75.0, 85, '2027-10-10', 2),
('Iron Tablets', 'B014', 'Supplement', 55.0, 50, '2027-06-01', 3),
('ORS Sachet', 'B015', 'Rehydration', 20.0, 200, '2029-01-01', 4),
('Zincovit', 'B016', 'Multivitamin', 95.0, 160, '2028-07-01', 5),
('Electral', 'B017', 'Rehydration', 22.0, 180, '2029-05-15', 6),
('Aspirin 75mg', 'B018', 'Cardiac', 18.0, 75, '2026-04-30', 7),
('Losartan 50mg', 'B019', 'BP', 65.0, 85, '2027-12-31', 8),
('Amlodipine 5mg', 'B020', 'BP', 30.0, 95, '2027-11-05', 9),
('Levocetirizine 5mg', 'B021', 'Allergy', 20.0, 70, '2025-09-09', 10),
('Sinarest', 'B022', 'Cold', 45.0, 60, '2027-03-21', 1),
('Montelukast 10mg', 'B023', 'Allergy', 75.0, 55, '2027-08-09', 2),
('Dexamethasone 4mg', 'B024', 'Steroid', 22.0, 50, '2026-09-01', 3),
('Prednisolone 5mg', 'B025', 'Steroid', 28.0, 45, '2026-12-15', 4),
('Clopidogrel 75mg', 'B026', 'Cardiac', 120.0, 35, '2027-01-11', 5),
('Insulin 10ml', 'B027', 'Diabetes', 250.0, 25, '2025-06-30', 6),
('Domperidone 10mg', 'B028', 'Digestive', 35.0, 60, '2026-02-15', 7),
('Folic Acid 5mg', 'B029', 'Supplement', 18.0, 200, '2028-08-08', 8),
('Rabeprazole 20mg', 'B030', 'Acidity', 50.0, 90, '2027-04-24', 9),
('Doxycycline 100mg', 'B031', 'Antibiotic', 95.0, 30, '2026-01-01', 10),
('Naproxen 250mg', 'B032', 'Pain Relief', 70.0, 40, '2025-03-14', 1),
('Vit D3 60k', 'B033', 'Supplement', 35.0, 150, '2028-01-10', 2),
('Betadine', 'B034', 'Antiseptic', 55.0, 110, '2029-12-31', 3),
('Bandage Roll', 'B035', 'First Aid', 15.0, 300, '2030-01-01', 4),
('Gauze Pads', 'B036', 'First Aid', 10.0, 250, '2030-05-12', 5),
('Syringe 5ml', 'B037', 'Medical Supply', 8.0, 500, '2032-12-01', 6),
('Surgical Gloves', 'B038', 'Medical Supply', 12.0, 350, '2031-11-11', 7),
('ORS Pro', 'B039', 'Rehydration', 25.0, 210, '2029-03-03', 8),
('Antacid Gel', 'B040', 'Digestive', 60.0, 120, '2027-10-20', 9);
