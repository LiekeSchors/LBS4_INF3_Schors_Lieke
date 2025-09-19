package com.tech.lbs4.staruml;

/**
 * Modell für Fahrzeughersteller.
 *
 * @author Lieke Schors
 */
public class Hersteller {
    private String name;

    public Hersteller(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    public void setName(String name) {
        this.name = name;
    }
}
