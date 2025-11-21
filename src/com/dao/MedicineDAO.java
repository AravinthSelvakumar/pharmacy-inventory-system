package com.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.model.Medicine;
import com.util.DBConnection;

public class MedicineDAO {

    public void addMedicine(Medicine m) throws Exception {
        String sql = "INSERT INTO medicine(name, batch_no, category, price, stock, expiry_date, supplier_id) VALUES(?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, m.getName());
            ps.setString(2, m.getBatchNo());
            ps.setString(3, m.getCategory());
            ps.setDouble(4, m.getPrice());
            ps.setInt(5, m.getStock());
            ps.setDate(6, Date.valueOf(m.getExpiryDate()));
            ps.setInt(7, m.getSupplierId());
            ps.executeUpdate();
        }
    }

    public List<Medicine> getAllMedicines() throws Exception {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM medicine";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Medicine m = new Medicine();
                m.setMedicineId(rs.getInt("medicine_id"));
                m.setName(rs.getString("name"));
                m.setBatchNo(rs.getString("batch_no"));
                m.setCategory(rs.getString("category"));
                m.setPrice(rs.getDouble("price"));
                m.setStock(rs.getInt("stock"));
                Date d = rs.getDate("expiry_date");
                if (d != null) m.setExpiryDate(d.toLocalDate());
                m.setSupplierId(rs.getInt("supplier_id"));
                list.add(m);
            }
        }
        return list;
    }

    public void updateMedicineStock(int medicineId, int newStock) throws Exception {
        String sql = "UPDATE medicine SET stock = ? WHERE medicine_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newStock);
            ps.setInt(2, medicineId);
            ps.executeUpdate();
        }
    }

    public void updateMedicinePrice(int medicineId, double newPrice) throws Exception {
        String sql = "UPDATE medicine SET price = ? WHERE medicine_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, medicineId);
            ps.executeUpdate();
        }
    }

    public void updateMedicineExpiry(int medicineId, LocalDate expiryDate) throws Exception {
        String sql = "UPDATE medicine SET expiry_date = ? WHERE medicine_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(expiryDate));
            ps.setInt(2, medicineId);
            ps.executeUpdate();
        }
    }

    public void deleteMedicine(int medicineId) throws Exception {
        String sql = "DELETE FROM medicine WHERE medicine_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, medicineId);
            ps.executeUpdate();
        }
    }

    public void deleteExpiredMedicines() throws Exception {
        String sql = "DELETE FROM medicine WHERE expiry_date < CURDATE()";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }

    public List<Medicine> getExpiringWithinDays(int days) throws Exception {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM medicine WHERE expiry_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL ? DAY)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, days);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medicine m = new Medicine();
                    m.setMedicineId(rs.getInt("medicine_id"));
                    m.setName(rs.getString("name"));
                    m.setBatchNo(rs.getString("batch_no"));
                    m.setCategory(rs.getString("category"));
                    m.setPrice(rs.getDouble("price"));
                    m.setStock(rs.getInt("stock"));
                    Date d = rs.getDate("expiry_date");
                    if (d != null) m.setExpiryDate(d.toLocalDate());
                    m.setSupplierId(rs.getInt("supplier_id"));
                    list.add(m);
                }
            }
        }
        return list;
    }

    public List<Medicine> getLowStockMedicines(int threshold) throws Exception {
        List<Medicine> list = new ArrayList<>();
        String sql = "SELECT * FROM medicine WHERE stock < ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, threshold);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medicine m = new Medicine();
                    m.setMedicineId(rs.getInt("medicine_id"));
                    m.setName(rs.getString("name"));
                    m.setBatchNo(rs.getString("batch_no"));
                    m.setCategory(rs.getString("category"));
                    m.setPrice(rs.getDouble("price"));
                    m.setStock(rs.getInt("stock"));
                    Date d = rs.getDate("expiry_date");
                    if (d != null) m.setExpiryDate(d.toLocalDate());
                    m.setSupplierId(rs.getInt("supplier_id"));
                    list.add(m);
                }
            }
        }
        return list;
    }
}

