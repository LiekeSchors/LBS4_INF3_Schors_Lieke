package com.tech.lbs4.bmicalc;

public class Bmi {
    private double weigth;
    private double height;
    private double bmi;

    // No constructor needed, as values will be set via Setters

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

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
     * Commbines the bmi-result with a short descrption about it.
     *
     * @param bmi The BMI-Object, in which userdata is saved.
     * @return A userfriendly presentation of the result.
     */
    public String createResult(Bmi bmi) {
        double bmiValue = bmi.calculateBmi(bmi.weigth, bmi.height);
        String bmiDescription = createBmiDescription(bmiValue);

        return "Your BMI is: " + String.format("%.2f", bmiValue) + " (" + bmiDescription + ")";
    }

    private double calculateBmi(double weigth, double height) {
        return weigth / (height * height);
    }

    /**
     * Creates a short description to bmi-values.
     *
     * @return A short description about the bmi value.
     */
    private String createBmiDescription(double bmi) {
        String bmiDescription;

        if (bmi <= 16.0) {
            bmiDescription = "Critical underweight";
        } else if (bmi <= 19.9) {
            bmiDescription = "Underweight";
        } else if (bmi <= 24.9) {
            bmiDescription = "Normal weight";
        } else if (bmi <= 29.9) {
            bmiDescription = "Overweight";
        } else if (bmi <= 34.9) {
            bmiDescription = "Obese grade 1";
        } else if (bmi <= 39.9) {
            bmiDescription = "Obese grade 2";
        } else {
            bmiDescription = "Obese grade 3";
        }

        return bmiDescription;
    }
}
