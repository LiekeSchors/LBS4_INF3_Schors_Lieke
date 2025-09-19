package com.tech.lbs4.staruml;

public class Suv extends Pkw {
    private SuvTyp suvTyp;

    @SuppressWarnings("unused")
    public SuvTyp getSuvTyp() {
        return suvTyp;
    }

    public void setSuvTyp(SuvTyp suvTyp) {
        this.suvTyp = suvTyp;
    }

    @Override
    @ToDo(aufgabe = "Implementieren", bisDatum = "30.11.2025")
    public void blinken() {
        super.blinken();
    }
}
