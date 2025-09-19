package com.tech.lbs4.staruml;

public abstract class Fahrzeug {
    private String reifen;
    private Motor motor; // Wenn man Fahrräder einschließen möchte, gehört dieses Attribut weg.
    private LenkradTyp lenkradTyp;
    private double hoechstGeschwindigkeit;
    private double anzahlSitzplaetze;
    private Hersteller hersteller;
    private double preis;
    private boolean faehrt;
    private int aktuellerGang;

    @SuppressWarnings("unused")
    public String getReifen() {
        return reifen;
    }

    public void setReifen(String reifen) {
        this.reifen = reifen;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @SuppressWarnings("unused")
    public LenkradTyp getLenkradTyp() {
        return lenkradTyp;
    }

    @SuppressWarnings("unused")
    public void setLenkradTyp(LenkradTyp lenkradTyp) {
        this.lenkradTyp = lenkradTyp;
    }

    @SuppressWarnings("unused")
    public double getHoechstGeschwindigkeit() {
        return hoechstGeschwindigkeit;
    }

    @SuppressWarnings("unused")
    public void setHoechstGeschwindigkeit(double hoechstGeschwindigkeit) {
        this.hoechstGeschwindigkeit = hoechstGeschwindigkeit;
    }

    @SuppressWarnings("unused")
    public double getAnzahlSitzplaetze() {
        return anzahlSitzplaetze;
    }

    @SuppressWarnings("unused")
    public void setAnzahlSitzplaetze(double anzahlSitzplaetze) {
        this.anzahlSitzplaetze = anzahlSitzplaetze;
    }

    @SuppressWarnings("unused")
    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @SuppressWarnings("unused")
    public boolean isFaehrt() {
        return faehrt;
    }

    @SuppressWarnings("unused")
    public void setFaehrt(boolean faehrt) {
        this.faehrt = faehrt;
    }

    public void starten() {
        aktuellerGang += 1;
        faehrt = true;
    }

    public void schalten(boolean hochschalten) {
        if (hochschalten) {
            aktuellerGang += 1;
            System.out.println("Hochschalten in Gang " + aktuellerGang);
        } else {
            aktuellerGang -= 1;
            System.out.println("Runterschalten in Gang " + aktuellerGang);
        }
    }

    /**
     * Diese Methode lässt ein Fahrzeug blinken.
     *
     * @author Lieke Schors
     */
    public void blinken() {
        if (hersteller != null) {
            if (hersteller.getName().equalsIgnoreCase("bmw")) {
                System.out.println("?");
            } else {
                System.out.println("Fahrzeug blinkt");
            }
        }
    }

    /**
     * Mit dieser Methode wird simuliert, wie ein LKW vs. ein anderes Fahrzeug beschleunigt.
     *
     * @author Lieke Schors
     */
    public abstract void beschleunigen();

}
