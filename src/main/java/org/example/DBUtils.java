package org.example;

import org.example.entity.DataSingleton;

import java.sql.Connection;
import java.sql.DriverManager;

public interface DBUtils {




    static Connection getConnection() {

        final String DB_USERNAME = "postgres";
        final String DB_PASSWORD = "root";
        final String DB_URL = "jdbc:postgresql://192.168.17.119:5432/univ";

        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (conn != null) {
                System.out.println("DB✔");
            } else {
                System.out.println("Connection failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}