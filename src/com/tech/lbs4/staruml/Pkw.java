package com.tech.lbs4.staruml;

public class Pkw extends Fahrzeug {
    private double stauraum;
    private boolean _4x4;
    private String farbe;


    public double getStauraum() {
        return stauraum;
    }

    public void setStauraum(double stauraum) {
        this.stauraum = stauraum;
    }

    public boolean is_4x4() {
        return _4x4;
    }

    public void set_4x4(boolean _4x4) {
        this._4x4 = _4x4;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public boolean anschnallen() {
        return true;
    }
}
