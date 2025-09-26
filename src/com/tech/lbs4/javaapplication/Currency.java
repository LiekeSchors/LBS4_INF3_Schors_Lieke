package com.tech.lbs4.javaapplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * This enum lists currencies.
 * TODO: Automatic Update of Exchange Rates
 */
public enum Currency {
    EURO('€', 1.0, 1.17, 0.87, 1.79),
    USD('$', 0.86, 1.0, 0.75, 1.53),
    STERLING('£', 1.14, 1.34, 1.0, 2.05),
    AUD('$', 0.56, 0.65, 0.49, 1.0);

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

    public static void getUsdExchangeRates() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/4a646f4fa7461076f3865d7f/latest/USD"))
                .header("Accept", "application/json")
                .timeout(Duration.ofSeconds(15))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        if (statusCode == 200) {
            String body = response.body();
            System.out.println(body);
        }


    }
}
