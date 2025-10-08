package com.tech.lbs4.zugfahrplan.test;

import com.tech.lbs4.zugfahrplan.DatabaseConnection;

import java.sql.*;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        // given
        DatabaseConnection databaseConnection = new DatabaseConnection();

        // when
        Connection con = DatabaseConnection.getConnection();

        // then
        try {
            DatabaseMetaData databaseMetaData = con.getMetaData();
            String url = databaseMetaData.getURL();
            System.out.println("Erfolgreich verbunden! URL: " + url);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT name FROM stadt")) {
            while (rs.next()) {
                System.out.println("Test-Query Ergebnis: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Fehler bei der Datenbankverbindung.");
            e.printStackTrace();
        }
    }
}

