package com.tech.lbs4.staruml;

/**
 * Klasse für Fahrzeugmotoren.
 *
 * @author Lieke Schors
 * @since 1.1
 */
public class Motor {
    private Hersteller hersteller;
    private int leistung;
    private MotorTyp motorTyp;

    public Motor(Hersteller hersteller, int leistung, MotorTyp motorTyp) {
        this.hersteller = hersteller;
        this.leistung = leistung;
        this.motorTyp = motorTyp;
    }

    @SuppressWarnings("unused")
    public Hersteller getHersteller() {
        return hersteller;
    }

    @SuppressWarnings("unused")
    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    @SuppressWarnings("unused")
    public int getLeistung() {
        return leistung;
    }

    @SuppressWarnings("unused")
    public void setLeistung(int leistung) {
        this.leistung = leistung;
    }

    @SuppressWarnings("unused")
    public MotorTyp getMotorTyp() {
        return motorTyp;
    }

    @SuppressWarnings("unused")
    public void setMotorTyp(MotorTyp motorTyp) {
        this.motorTyp = motorTyp;
    }
}
