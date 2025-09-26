package com.tech.lbs4.javaapplication;


import java.io.IOException;

public class CurrencyCalculator {

    public static void main(String[] args) throws IOException, InterruptedException {
        CurrencyCalculatorView currencyCalculatorView = new CurrencyCalculatorView();
        currencyCalculatorView.getMainFrame();

        Currency.getUsdExchangeRates();
    }
}
