package com.tech.lbs4.staruml;

public class Lkw extends Fahrzeug {
    private LkwTyp lkwTyp;
    private boolean ladungGekoppelt;

    public LkwTyp getLkwTyp() {
        return lkwTyp;
    }

    public void setLkwTyp(LkwTyp lkwTyp) {
        this.lkwTyp = lkwTyp;
    }

    public void ladungEntkoppeln() {
        if (ladungGekoppelt) {
            ladungGekoppelt = false;
            System.out.println("Ladung wurde entkoppelt.");
        } else {
            System.out.println("Die Ladung konnte nicht entkoppelt werden, da keine gekoppelt war.");
        }
    }

    public void ladungKoppeln() {
        if (!ladungGekoppelt) {
            ladungGekoppelt = true;
            System.out.println("Ladung wurde gekoppelt.");
        } else {
            System.out.println("Es konntee keine Ladung gekoppelt werden, da bereits eine gekoppelt ist.");
        }
    }
}
