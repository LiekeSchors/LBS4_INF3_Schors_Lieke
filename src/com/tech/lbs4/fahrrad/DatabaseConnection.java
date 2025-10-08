package com.tech.lbs4.fahrrad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = System.getenv("DB_URL");
    private static final String DB_USER = System.getenv("DB_USER");
    private static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    private Connection connection = null;

    public Connection getConnection() {
        System.out.println("Connecting to database..." +  DB_URL + DB_USER + DB_PASSWORD);

        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Verbindung zur Datenbank fehlgeschlagen.");
        }
        return connection;
    }

    public void closeConnection() {
        assert connection != null;
        try {
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Verbindung zur Datenbank geschlossen.");
            } else {
                System.out.println("Beim Schließen der Datenbankverbindung ist ein Problem aufgetreten.");
            }
        } catch (SQLException ex) {
            System.out.println("Fehler beim Schließen der Datenbank: " + ex.getMessage());
        }
    }
}
