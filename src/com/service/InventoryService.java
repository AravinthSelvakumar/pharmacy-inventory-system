package com.service;

import com.dao.MedicineDAO;
import com.model.Medicine;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class InventoryService {
    private MedicineDAO dao = new MedicineDAO();
    private Scanner sc = new Scanner(System.in);

    public void handleChoice(int choice) throws Exception {
        switch (choice) {
            case 1: addMedicine(); break;
            case 2: viewMedicines(); break;
            case 3: updateMedicine(); break;
            case 4: deleteMedicine(); break;
            case 5: checkExpiryAlerts(); break;
            case 6: checkLowStock(); break;
            case 7: purchaseMedicine(); break;
            case 8: deleteExpired(); break;
            case 0: System.out.println("Goodbye!"); System.exit(0); break;
            default: System.out.println("Invalid choice");
        }
    }

    private void addMedicine() throws Exception {
        Medicine m = new Medicine();
        System.out.println("Name:");
        m.setName(sc.nextLine());
        System.out.println("Batch no:");
        m.setBatchNo(sc.nextLine());
        System.out.println("Category:");
        m.setCategory(sc.nextLine());
        System.out.println("Price:");
        m.setPrice(Double.parseDouble(sc.nextLine()));
        System.out.println("Stock:");
        m.setStock(Integer.parseInt(sc.nextLine()));
        System.out.println("Expiry date (YYYY-MM-DD):");
        m.setExpiryDate(LocalDate.parse(sc.nextLine()));
        System.out.println("Supplier ID:");
        m.setSupplierId(Integer.parseInt(sc.nextLine()));
        dao.addMedicine(m);
        System.out.println("Medicine added.");
    }

    private void viewMedicines() throws Exception {
        List<Medicine> list = dao.getAllMedicines();
        for (Medicine m : list) {
            System.out.println(m.getMedicineId() + " | " + m.getName() + " | " + m.getStock() + " | Expiry: " + m.getExpiryDate());
        }
    }

    private void updateMedicine() throws Exception {
        System.out.println("Enter medicine id to update:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("1. Update stock\n2. Update price\n3. Update expiry date");
        int ch = Integer.parseInt(sc.nextLine());
        if (ch == 1) {
            System.out.println("New stock:");
            int s = Integer.parseInt(sc.nextLine());
            dao.updateMedicineStock(id, s);
        } else if (ch == 2) {
            System.out.println("New price:");
            double p = Double.parseDouble(sc.nextLine());
            dao.updateMedicinePrice(id, p);
        } else if (ch == 3) {
            System.out.println("New expiry (YYYY-MM-DD):");
            dao.updateMedicineExpiry(id, LocalDate.parse(sc.nextLine()));
        }
        System.out.println("Updated.");
    }

    private void deleteMedicine() throws Exception {
        System.out.println("Enter medicine id to delete:");
        int id = Integer.parseInt(sc.nextLine());
        dao.deleteMedicine(id);
        System.out.println("Deleted.");
    }

    private void checkExpiryAlerts() throws Exception {
        System.out.println("Medicines expiring within 30 days:");
        List<Medicine> list = dao.getExpiringWithinDays(30);
        for (Medicine m : list) {
            System.out.println(m.getMedicineId() + " | " + m.getName() + " | Expiry: " + m.getExpiryDate());
        }
    }

    private void checkLowStock() throws Exception {
        List<Medicine> list = dao.getLowStockMedicines(10);
        System.out.println("Low stock medicines (<10):");
        for (Medicine m : list) {
            System.out.println(m.getMedicineId() + " | " + m.getName() + " | Stock: " + m.getStock());
        }
    }

    private void purchaseMedicine() throws Exception {
        System.out.println("Enter medicine id to purchase:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter quantity:");
        int q = Integer.parseInt(sc.nextLine());
        // fetch current stock
        List<Medicine> list = dao.getAllMedicines();
        Medicine found = null;
        for (Medicine m : list) if (m.getMedicineId() == id) found = m;
        if (found == null) {
            System.out.println("Medicine not found.");
            return;
        }
        if (found.getStock() < q) {
            System.out.println("Not enough stock. Current stock: " + found.getStock());
            return;
        }
        dao.updateMedicineStock(id, found.getStock() - q);
        System.out.println("Purchase completed. Remaining stock: " + (found.getStock() - q));
        if (found.getStock() - q < 10) System.out.println("WARNING: Low stock!");
    }

    private void deleteExpired() throws Exception {
        dao.deleteExpiredMedicines();
        System.out.println("Expired medicines deleted.");
    }
}

