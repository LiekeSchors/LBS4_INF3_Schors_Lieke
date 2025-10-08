package com.tech.lbs4.fahrrad;


import org.hibernate.dialect.MySQLDialect;

import java.util.Properties;
import java.util.Scanner;

import static com.tech.lbs4.AnsiColors.ANSI_RED;
import static com.tech.lbs4.AnsiColors.ANSI_RESET;

public class Main {
    public static void main(String[] args) {
        SqlStatementCreator sqlStatementCreator = new SqlStatementCreator();
        sqlStatementCreator.createDatabase("TestDB");

        sqlStatementCreator.createTable("schueler");

        sqlStatementCreator.getAustrianCustomers();
        sqlStatementCreator.getMieteinnahmen();

//        System.out.println("Möchten Sie Spalten eingeben? Antworten Sie mit 'J' für Ja oder 'N' für Nein.");
//        Scanner scanner = new Scanner(System.in);
//        String antwort = scanner.next();
//        boolean spalteHinzufuegen = antwort.equalsIgnoreCase("j");


//
//        while (spalteHinzufuegen) {
//            String spaltenName = createColumnName(scanner);
//            System.out.println("Geben Sie den Datentyp der Spalte ein: ");
//
//            String datenTyp = scanner.next();
//
//
//            System.out.println("Möchten Sie eine weitere Spalte hinzufügen?");
//            spalteHinzufuegen = antwort.equalsIgnoreCase("j");
//
//        }

//        System.out.println("Es können aktuell keine weiteren Spalten hinzugefügt werden.");


    }

    private static String createColumnName(Scanner scanner) {
        System.out.println("Geben Sie den Namen der Spalte ein: ");

        boolean validInput = false;
        String name = scanner.next();

        return name;

    }
//
//    private static MySQLDataType createDataType(Scanner scanner) {
//
//    }
}
