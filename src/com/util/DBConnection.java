package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/pharmacy";
    private static final String USER = "root";         // change if different
    private static final String PASS = "Aravinth@555"; // change to your MySQL root password

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

