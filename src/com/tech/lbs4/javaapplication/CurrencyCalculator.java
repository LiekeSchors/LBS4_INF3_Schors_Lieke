package com.tech.lbs4.javaapplication;

import java.io.IOException;
import java.net.URISyntaxException;

public class CurrencyCalculator {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // TODO: Nur einmal am Tag
        Currency.getEuroExchangeRates();
        Currency.getUsdExchangeRates();
        Currency.getGbpExchangeRates();
        Currency.getAudExchangeRates();
        CurrencyCalculatorView currencyCalculatorView = new CurrencyCalculatorView();
        currencyCalculatorView.getMainFrame();
    }
}
