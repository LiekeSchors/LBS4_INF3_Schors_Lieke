package com.tech.lbs4.staruml;

/**
 * Spezialisierte Fahrzeugklasse für Pkws.
 *
 * @author Lieke Schors
 */
public class Pkw extends Fahrzeug implements Verkaufbar {
    private double stauraum;
    private boolean _4x4;
    private String farbe;

    @SuppressWarnings("unused")
    public double getStauraum() {
        return stauraum;
    }

    @SuppressWarnings("unused")
    public void setStauraum(double stauraum) {
        this.stauraum = stauraum;
    }

    @SuppressWarnings("unused")
    public boolean is_4x4() {
        return _4x4;
    }

    public void set_4x4(boolean _4x4) {
        this._4x4 = _4x4;
    }

    @SuppressWarnings("unused")
    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    /**
     * Diese Methode schnallt einen Fahrer im Pkw an.
     *
     * @return ein Boolean, mit der Angabe, ob das Anschnallen erfolgreich war.
     */
    @ToDo(aufgabe = "if-else implementieren", bisDatum = "11.09.2025")
    public boolean anschnallen() {
        return true;
    }

    /**
     * @see #Fahrzeug.beschleunigen()
     */
    @Override
    @ToDo(aufgabe = "Andere Implementierung", bisDatum = "23.09.2025", pflicht = false)
    public void beschleunigen() {
        System.out.println("10 KMH");
        try {
            Thread.sleep(500);
        } catch (InterruptedException _) {
        }
        System.out.println("30 KMH");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException _) {
        }
        System.out.println("60 KMH");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException _) {
        }
        System.out.println("100 KMH");
    }

    @Override
    public double rabattBerechnen() {
        return getPreis() * 0.1;
    }

    @Override
    public double verkaufen() {
        double praemie = 500;
        return getPreis() - rabattBerechnen() - praemie;
    }
}

