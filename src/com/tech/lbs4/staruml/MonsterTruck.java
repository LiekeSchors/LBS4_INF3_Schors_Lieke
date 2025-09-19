package com.tech.lbs4.staruml;

public class MonsterTruck extends Fahrzeug {
    private String federung;

    @SuppressWarnings("unused")
    public String getFederung() {
        return federung;
    }

    @SuppressWarnings("unused")
    public void setFederung(String federung) {
        this.federung = federung;
    }

    public void huepfen() {
        System.out.println("Monster Truck hüpft.");
    }

    @Override
    public void beschleunigen() {
        System.out.println("Ich bin ein Monster Truck! Ich hüpfe und springe nur.");
    }
}
