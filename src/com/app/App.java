package com.app;

import com.service.InventoryService;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        InventoryService service = new InventoryService();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- PHARMACY INVENTORY SYSTEM ---");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Medicines");
            System.out.println("3. Update Medicine");
            System.out.println("4. Delete Medicine");
            System.out.println("5. Expiry Alerts (30 days)");
            System.out.println("6. Low Stock (<10)");
            System.out.println("7. Purchase Medicine");
            System.out.println("8. Delete Expired Medicines");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            try {
                service.handleChoice(choice);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
