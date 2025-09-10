package com.tech.lbs4;

import com.tech.lbs4.bmicalc.Bmi;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // Colors for the console
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("Welcome to THE BMI-calculator!");
        System.out.println(ANSI_RED + "Caution! The BMI of Babys and small children cannot be calculated accurately with this tool!" + ANSI_RESET);

        boolean endProgram = false;

        while (!endProgram) {
            Bmi participantBmi = new Bmi();

            System.out.println("Please enter your height in meters (m): ");
            double minHeight = 0; // Should it be higher?
            double maxHeight = 2.5;
            double height = readUserInput(minHeight, maxHeight);
            participantBmi.setHeight(height);

            System.out.println("Please enter your weight in kilograms (kg): ");
            double minWeight = 0; // Should it be higher?
            double maxWeight = 250;
            double weight = readUserInput(minWeight, maxWeight);
            participantBmi.setWeigth(weight);

            String result = participantBmi.createResult(participantBmi);
            System.out.println(result);

            System.out.println("Do you want to use the calculator again? Enter 'y' for yes, 'n' for no");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) {
                endProgram = true;
            }
        }
    }

    /**
     * Tries to convert the user input into a double, until the value is valid for further processing.
     *
     * @param minValue The lowest valid value.
     * @param maxValue The hightest valid value.
     * @return The user input as a double.
     * @throws NumberFormatException, if the input value could not be parsed into a double value.
     */
    private static double readUserInput(double minValue, double maxValue) {
        boolean invalidValue = true;

        double userInput = -1;
        while (invalidValue) {
            try {
                userInput = Double.parseDouble(scanner.next());

                if (userInput > minValue && userInput <= maxValue) {
                    invalidValue = false;
                } else {
                    System.out.println("Please enter a value between " + minValue + " and " + maxValue + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid decimal number: ");
            }
        }

        return userInput;
    }
}
