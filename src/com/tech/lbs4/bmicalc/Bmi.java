package com.tech.lbs4.bmicalc;

import static com.tech.lbs4.AnsiColors.*;

public class Bmi {
    private double weight;
    private double height;
    private double bmi;

    // No constructor needed, as values will be set via Setters

    @SuppressWarnings("unused")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @SuppressWarnings("unused")
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }


    /**
     * Combines the bmi-result with a short description about it.
     *
     * @param
     *      bmi The BMI-Object, in which userdata is saved.
     * @return
     *      A user-friendly presentation of the result.
     */
    public String createResult(Bmi bmi) {
        double bmiValue = bmi.calculateBmi(bmi.weight, bmi.height);
        bmi.setBmi(bmiValue);
        String bmiDescription = createBmiDescription(bmiValue);

        return "Your BMI is: " + String.format("%.2f", bmi.getBmi()) + " (" + bmiDescription + ")";
    }

    private double calculateBmi(double weight, double height) {
        double bmi = -1;
        try {
            bmi = weight / (height * height);
        } catch (ArithmeticException e) { // This does not make a lot of sense, since the user input cannot be 0 (see Main.java)
            System.out.println(ANSI_RED + "An error occurred while calculating the bmi. (Division by 0)" + ANSI_RESET);
        } finally {
            System.out.println("Calculated BMI = " + bmi);
            System.out.println();
            System.out.println(ANSI_RED + "If your result is -1, your result is not interpretable due an error." + ANSI_RESET);
        }

        return bmi;
    }

    /**
     * Creates a short description to bmi-values.
     *
     * @return A short description about the bmi value.
     */
    private String createBmiDescription(double bmi) {
        String bmiDescription;

        if (bmi <= 16.0) {
            bmiDescription = ANSI_CYAN + "Critical underweight" + ANSI_RESET;
        } else if (bmi <= 19.9) {
            bmiDescription = ANSI_YELLOW + "Underweight" + ANSI_RESET;
        } else if (bmi <= 24.9) {
            bmiDescription = ANSI_GREEN + "Normal weight" + ANSI_RESET;
        } else if (bmi <= 29.9) {
            bmiDescription = ANSI_RED + "Overweight" + ANSI_RESET;
        } else if (bmi <= 34.9) {
            bmiDescription = ANSI_BLUE + "Obese grade 1" + ANSI_RESET;
        } else if (bmi <= 39.9) {
            bmiDescription = ANSI_PURPLE + "Obese grade 2" + ANSI_RESET;
        } else {
            bmiDescription = ANSI_WHITE + "Obese grade 3" + ANSI_RESET;
        }

        return bmiDescription;
    }
}
