package com.tech.lbs4.staruml;

public class Motor {
    private Hersteller hersteller;
    private int leistung;
    private MotorTyp motorTyp;

    public Motor(Hersteller hersteller, int leistung, MotorTyp motorTyp) {
        this.hersteller = hersteller;
        this.leistung = leistung;
        this.motorTyp = motorTyp;
    }

    public Hersteller getHersteller() {
        return hersteller;
    }

    public void setHersteller(Hersteller hersteller) {
        this.hersteller = hersteller;
    }

    public int getLeistung() {
        return leistung;
    }

    public void setLeistung(int leistung) {
        this.leistung = leistung;
    }

    public MotorTyp getMotorTyp() {
        return motorTyp;
    }

    public void setMotorTyp(MotorTyp motorTyp) {
        this.motorTyp = motorTyp;
    }
}
