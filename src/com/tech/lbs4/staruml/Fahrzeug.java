package com.tech.lbs4.staruml;

public class Fahrzeug { // Die Klasse könnte man abstract machen, sodass keine Instanzen davon erzeugt werden können und immer ein spezifisches Fahrzeug angelegt werden muss.
    // In der Realität wäre das wohl sinnvoller. Zur Veranschaulichung des Themas Vererbung bietet sich die normale Klasse m.E. besser an.
    private String reifen;
    private Motor motor; // Wenn man Fahrräder einschließen möchte, gehört dieses Attribut weg.
    private LenkradTyp lenkradTyp;
    private double hoechstGeschwindigkeit;
    private double anzahlSitzplaetze;
    private Hersteller hersteller;
    private double preis;
    private boolean faehrt;
    private int aktuellerGang;

    public Fahrzeug() {
        faehrt = false;
        aktuellerGang = 0;
    }

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

    public LenkradTyp getLenkradTyp() {
        return lenkradTyp;
    }

    public void setLenkradTyp(LenkradTyp lenkradTyp) {
        this.lenkradTyp = lenkradTyp;
    }

    public double getHoechstGeschwindigkeit() {
        return hoechstGeschwindigkeit;
    }

    public void setHoechstGeschwindigkeit(double hoechstGeschwindigkeit) {
        this.hoechstGeschwindigkeit = hoechstGeschwindigkeit;
    }

    public double getAnzahlSitzplaetze() {
        return anzahlSitzplaetze;
    }

    public void setAnzahlSitzplaetze(double anzahlSitzplaetze) {
        this.anzahlSitzplaetze = anzahlSitzplaetze;
    }

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

    public boolean isFaehrt() {
        return faehrt;
    }

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

    public void blinken() {
        if (hersteller.getName().equalsIgnoreCase("bmw")) {
            System.out.println("?");
        } else {
            System.out.println("Fahrzeug blinkt");
        }
    }

    /**
     * Mit dieser Methode wird simuliert, wie ein LKW vs. ein anderes Fahrzeug beschleunigt. Die Zeiten und Geschwindigkeiten
     * entsprechen höchstwahrscheinlich nicht der Wirklichkeit.
     */
    public void beschleunigen() {
        /* Bei Verwendung einer abstrakten Klasse könnte diese Methode z.B. abstrakt gemacht werden. Die Unterklassen
         müssen sich dann selbst um die Implementierung kümmern und hier würde nicht so viel Code stehen. Andere Methoden
         könnten in dieser Klasse dennoch schon bereitgestellt werden.*/
        System.out.println("10 KMH");
        if (this instanceof Lkw) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException _) {
            }
            System.out.println("20 KMH");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException _) {
            }
            System.out.println("30 KMH");

            try {
                Thread.sleep(3500);
            } catch (InterruptedException _) {
            }
            System.out.println("40 KMH");
        } else {
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
    }
}
