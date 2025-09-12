package com.tech.lbs4.staruml;

public class Hersteller {
    private String name;

    public Hersteller(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double verkaufen(Fahrzeug fahrzeug) {
        double verkaufspreis = fahrzeug.getPreis();

        // TODO: Verhandlung

        if (verkaufspreis < 0.0) {
            System.out.println("Das Fahrzeug kann nicht verkauft werden, da kein Preis gesetzt ist.");
            return 0.0;
        } else {
            System.out.println(name + " verkauft ein Fahrzeug um " + String.format("%.2f", verkaufspreis) + "€" );
        }

        return verkaufspreis;
    }
}
