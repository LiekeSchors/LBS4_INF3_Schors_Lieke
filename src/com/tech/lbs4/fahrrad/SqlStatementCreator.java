package com.tech.lbs4.fahrrad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlStatementCreator {
    DatabaseConnection databaseConnection = new DatabaseConnection();

    public void createDatabase(String dbName) {
        Connection connection = databaseConnection.getConnection();

        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        try {
            Statement statement = connection.createStatement();
            boolean result = statement.execute(sql);
            if (result) {
                System.out.println("Die Datenbank wurde erstellt.");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Datenbank.");
        } finally {
            databaseConnection.closeConnection();
        }
    }

    public void dropDatabase(String dbName) {
        Connection connection = databaseConnection.getConnection();

        String sql = "DROP DATABASE IF EXISTS " + dbName;
        try {
            Statement statement = connection.createStatement();
            boolean result = statement.execute(sql);
            if (result) {
                System.out.println("Die Datenbank wurde gelöscht.");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Löschen der Datenbank.");
        } finally {
            databaseConnection.closeConnection();
        }
    }

    public void createTable(String tableName) {
        Connection connection = databaseConnection.getConnection();

        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (id INT NOT NULL PRIMARY KEY);";

        try {
            Statement statement = connection.createStatement();
            boolean result = statement.execute(sql);
            if (result) {
                System.out.println("Die Tabelle wurde erstellt.");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle.");
        } finally {
            databaseConnection.closeConnection();
        }
    }

    public void dropTable(String tableName) {
        Connection connection = databaseConnection.getConnection();

        String sql = "DROP TABLE IF EXISTS" + tableName;
        try {
            Statement statement = connection.createStatement();
            boolean result = statement.execute(sql);
            if (result) {
                System.out.println("Die Tabelle wurde gelöscht.");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle.");
        } finally {
            databaseConnection.closeConnection();
        }
    }

    public void addColumn(String tableName, String columnName, String dataType) {
        Connection connection = databaseConnection.getConnection();

        String sql = "ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " " + dataType + ")";
        try {
            Statement statement = connection.createStatement();
            boolean result = statement.execute(sql);
            if (result) {
                System.out.println("Die Spalte " + columnName + " wurde in " + tableName + " erstellt.");
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Hinzufügen der Spalte.");
        } finally {
            databaseConnection.closeConnection();
        }
    }

    public void getAustrianCustomers() {
        String sql = "SELECT Vorname, Name, Strasse, PLZ, Ort, Countrycode" +
                " FROM kunde" +
                " LEFT JOIN wohnort ON kunde.Ortnr = wohnort.Ortnr" +
                " LEFT JOIN land ON wohnort.Landnr = land.Landnr" +
                " WHERE Countrycode = 'AUT'";
        Connection connection = databaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            String kopfUndTrennzeile =
                    "+---------------------------" +
                    "+-------------------------------------" +
                    "+-------------------------------------" +
                    "+------------" +
                    "+---------------------------------------------------------" +
                    "+-----------------+%n";
            System.out.format(kopfUndTrennzeile);

            String spaltenbreite = "| %-25s | %-35s | %-35s | %-10s | %-55s | %-15s |%n";
            System.out.format(
                    spaltenbreite,
                    "Vorname", "Nachname", "Strasse", "PLZ", "Ort", "Countrycode");

            System.out.format(kopfUndTrennzeile);

            while (rs.next()) {
                System.out.format(spaltenbreite,
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                System.out.format(kopfUndTrennzeile);
            }

        } catch (SQLException e) {
            System.out.println("Fehler beim Select: " + e.getMessage());
        }

        databaseConnection.closeConnection();
    }

    /**
     * Mieteinnahmen aller Fahrräder (Best Bike?), gruppiert nach Bezeichnung
     */
    public void getMieteinnahmen() {
        String sql = """
                SELECT Bezeichnung, (Tagesmietpreis * sum(bis - von)) as Mieteinnahmen
                FROM fahrrad
                JOIN vermietung
                ON fahrrad.Fahrradnr =  vermietung.Fahrradnr
                GROUP BY Bezeichnung;
                """;

        Connection connection = databaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            String kopfUndTrennzeile = "+----------------------" +
            "+-----------------------%n";
            System.out.format(kopfUndTrennzeile);
            String spaltenbreite = "| %-20s | %-20s |%n";
            System.out.format(
                    spaltenbreite,
                    "Bezeichnung", "Mieteinnahmen");

            System.out.format(kopfUndTrennzeile);
            while (rs.next()) {
                System.out.format(spaltenbreite, rs.getString(1), rs.getDouble(2));
                System.out.format(kopfUndTrennzeile);
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Select: " + e.getMessage());
        }
    }

    public void insertData(String tableName) {

    }
}
