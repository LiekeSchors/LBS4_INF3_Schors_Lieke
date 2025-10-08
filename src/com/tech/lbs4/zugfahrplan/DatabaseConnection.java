package com.tech.lbs4.zugfahrplan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Verbindung zur Datenbank fehlgeschlagen.");
        }
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        assert connection != null;
        connection.close();
        if (connection.isClosed()) {
            System.out.println("Verbindung zur Datenbank geschlossen.");
        } else {
            System.out.println("Beim Schließen der Datenbankverbindung ist ein Problem aufgetreten.");
        }
    }
}
