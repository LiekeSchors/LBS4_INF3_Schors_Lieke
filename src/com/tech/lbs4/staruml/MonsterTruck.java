package com.tech.lbs4.staruml;

public class MonsterTruck extends Fahrzeug{
    private String federung;

    public String getFederung() {
        return federung;
    }

    public void setFederung(String federung) {
        this.federung = federung;
    }

    public void huepfen() {
        System.out.println("Monster Truck hüpft.");
    }
}
