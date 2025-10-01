package com.tech.lbs4.javaapplication;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


/**
 * This enum lists currencies.
 * TODO: Automatic Update of Exchange Rates
 */
public enum Currency {


    EURO(),
    USD(),
    STERLING(),
    AUD();

    private char symbol;
    private double erEuro;
    private double erUsd;
    private double erSterling;
    private double erAud;

    Currency() {

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

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setErEuro(double erEuro) {
        this.erEuro = erEuro;
    }

    public void setErUsd(double erUsd) {
        this.erUsd = erUsd;
    }

    public void setErSterling(double erSterling) {
        this.erSterling = erSterling;
    }

    public void setErAud(double erAud) {
        this.erAud = erAud;
    }

    public static void getUsdExchangeRates() throws IOException, URISyntaxException {
        USD.setSymbol('$');
        USD.setErUsd(1);
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/4a646f4fa7461076f3865d7f/latest/USD";

        // Making Request
        URI uri = new URI(url_str);
        URL url = uri.toURL();
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        JsonObject req_result = jsonobj.get("conversion_rates").getAsJsonObject();
        USD.setErEuro(req_result.get("EUR").getAsDouble());
        USD.setErSterling(req_result.get("GBP").getAsDouble());
        USD.setErAud(req_result.get("AUD").getAsDouble());
    }

    public static void getEuroExchangeRates() throws IOException, URISyntaxException {
        EURO.setSymbol('€');
        EURO.setErEuro(1);
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/4a646f4fa7461076f3865d7f/latest/EUR";

        // Making Request
        URI uri = new URI(url_str);
        URL url = uri.toURL();
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        JsonObject req_result = jsonobj.get("conversion_rates").getAsJsonObject();
        EURO.setErUsd(req_result.get("USD").getAsDouble());
        EURO.setErSterling(req_result.get("GBP").getAsDouble());
        EURO.setErAud(req_result.get("AUD").getAsDouble());
    }

    public static void getGbpExchangeRates() throws IOException, URISyntaxException {
        STERLING.setSymbol('£');
        STERLING.setErUsd(1);
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/4a646f4fa7461076f3865d7f/latest/GBP";

        // Making Request
        URI uri = new URI(url_str);
        URL url = uri.toURL();
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        JsonObject req_result = jsonobj.get("conversion_rates").getAsJsonObject();
        STERLING.setErUsd(req_result.get("USD").getAsDouble());
        STERLING.setErEuro(req_result.get("EUR").getAsDouble());
        STERLING.setErAud(req_result.get("AUD").getAsDouble());
    }

    public static void getAudExchangeRates() throws IOException, URISyntaxException {
        AUD.setSymbol('$');
        AUD.setErUsd(1);
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/4a646f4fa7461076f3865d7f/latest/AUD";

        // Making Request
        URI uri = new URI(url_str);
        URL url = uri.toURL();
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing object
        JsonObject req_result = jsonobj.get("conversion_rates").getAsJsonObject();
        AUD.setErUsd(req_result.get("EUR").getAsDouble());
        AUD.setErSterling(req_result.get("GBP").getAsDouble());
        AUD.setErUsd(req_result.get("USD").getAsDouble());
    }
}
