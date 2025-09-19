package com.tech.lbs4.staruml;

public class Lkw extends Fahrzeug implements Verkaufbar {
    private LkwTyp lkwTyp;
    private boolean ladungGekoppelt;

    @SuppressWarnings("unused")
    public LkwTyp getLkwTyp() {
        return lkwTyp;
    }

    public void setLkwTyp(LkwTyp lkwTyp) {
        this.lkwTyp = lkwTyp;
    }

    @SuppressWarnings("unused")
    public void ladungEntkoppeln() {
        if (ladungGekoppelt) {
            ladungGekoppelt = false;
            System.out.println("Ladung wurde entkoppelt.");
        } else {
            System.out.println("Die Ladung konnte nicht entkoppelt werden, da keine gekoppelt war.");
        }
    }

    @SuppressWarnings("unused")
    public void ladungKoppeln() {
        if (!ladungGekoppelt) {
            ladungGekoppelt = true;
            System.out.println("Ladung wurde gekoppelt.");
        } else {
            System.out.println("Es konntee keine Ladung gekoppelt werden, da bereits eine gekoppelt ist.");
        }
    }

    /**
     * @see #Fahrzeug.beschleunigen()
     */
    @Override
    public void beschleunigen() {
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
    }

    @Override
    public double rabattBerechnen() {
        return getPreis() * 0.5;
    }

    @Override
    public double verkaufen() {
        return getPreis() - rabattBerechnen();
    }
}
