package com.tech.lbs4.javaapplication;

/**
 * This enum lists currencies.
 * TODO: Automatic Update of Exchange Rates
 */
public enum Currency {
    EURO('€', 1.0, 1.18, 0.87, 1.78),
    USD('$', 0.85, 1.0, 0.74, 1.51),
    STERLING('£', 1.15, 1.35, 1.0, 2.04),
    AUD('$', 0.56, 0.66, 0.49, 1.0);

    private final char symbol;
    private final double erEuro;
    private final double erUsd;
    private final double erSterling;
    private final double erAud;

    Currency(char symbol, double erEuro, double erUsd, double erSterling, double erAud) {
        this.symbol = symbol;
        this.erEuro = erEuro;
        this.erUsd = erUsd;
        this.erSterling = erSterling;
        this.erAud = erAud;
    }

    public char getSymbol() {
        return symbol;
    }

    public double getErEuro() {
        return erEuro;
    }

    public double getErUsd() {
        return erUsd;
    }

    public double getErSterling() {
        return erSterling;
    }

    public double getErAud() {
        return erAud;
    }
}
