package com.tech.lbs4.staruml;

public class Main {
    public static void main(String[] args) {
        Hersteller audi = new Hersteller("Audi");
        Hersteller bmw = new Hersteller("BMW");

        Pkw pkw = new Pkw(); // ist ein Fahrzeug (Generalisierung), Fahrzeug ist allgemein, Pkw in diesem Fall speziell.
        // pkw.setSuvTyp(); geht nicht, weil das eine Eigenschaft einer untergeordneten Klasse ist.
        // pkw.setName(); geht nicht, weil Name eine Eigenschaft von Hersteller ist und die Klassen nicht in einer Hierarchie stehen.
        // Fahrzeug und Hersteller sind 'nur' assoziiert und stehen auch nicht in einem hierarchischen Verhältnis.
        pkw.setReifen("Continental"); // PKW erbt die Eigenschaft "Reifen" von Fahrzeug.
        // pkw.ladungEntkoppeln(); ist auch nicht möglich. LKW und PKW sind zwar 'Geschwister' und 'Kinder' von Fahrzeug,
        // dieses Verhalten teilen sie allerdings nicht. Nur ein LKW kann das (nach dem als Vorlage verwendete UML-Diagramm).

        Suv audiSuv = new Suv(); // Ist ein PKW ist ein Fahrzeug, in dieser Beziehung in pkw sowohl eine allgemeine (für SUV) als auch eine spezielle Klasse (von Fahrzeug)
        audiSuv.setHersteller(audi);
        audiSuv.setSuvTyp(SuvTyp.MITTELKLASSE);
        audiSuv.set_4x4(true);
        audiSuv.setFarbe("Schwarz");
        audiSuv.blinken();

        Suv bmwSuv = new Suv();
        bmwSuv.setHersteller(bmw);
        bmwSuv.setSuvTyp(SuvTyp.MITTELKLASSE);
        bmwSuv.blinken(); // Die Klasse leitet von PKW und dann von Fahrzeug ab, sodass das möglich ist.

        System.out.println("Audi-SUV");
        boolean fahrerAngeschnallt = audiSuv.anschnallen();
        if (fahrerAngeschnallt) {
            audiSuv.starten();
            audiSuv.schalten(true); // hochschalten
            audiSuv.beschleunigen();
            audiSuv.schalten(true);
        }

        System.out.println("\nMonstertruck");
        MonsterTruck monsterTruck = new MonsterTruck(); // Ist ein Fahrzeug
        monsterTruck.starten(); // Möglich, weil die Klasse von Fahrzeug ableitet
        monsterTruck.huepfen();
        monsterTruck.blinken();

        System.out.println("\nLKW");
        Lkw lkw = new Lkw(); // Ist ein Fahrzeug
        lkw.setLkwTyp(LkwTyp.SCHWERTRANSPORT);
        lkw.starten(); // Möglich, weil auch diese Klasse von Fahrzeug ableitet
        lkw.beschleunigen();
        lkw.schalten(true);
        // lkw.huepfen(); ist nicht möglich, weil der LKW kein Monstertruck ist.

         // audiSuv.ladungEntkoppeln(); Geht nicht, da audiSuv nicht von LKW ableitet.

        Fahrzeug fahrzeug = new Fahrzeug();
        Motor motor = new Motor(audi, 300, MotorTyp.VERBRENNUNG);
        fahrzeug.setMotor(motor);
        // fahrzeug.setFederung(); nicht möglich, weil Fahrzeug die übergeordnete Klasse zu Monstertruck ist.
        // fahrzeug.setFarbe(); Ist übergeordnet zu PKW, daher kann die Klasse das Attribut nicht verwenden.
        MotorTyp motorTyp = fahrzeug.getMotor().getMotorTyp();// Jedes Fahrzeug muss einen Motor haben. Über diesen
        // Motor kann auch auf den Motortyp des Fahrzeuges zugegriffen werden. Es handelt sich um eine Kompostion.
        // Motor = Teil, Fahrzeug = Ganzes.

        audiSuv.setPreis(25000);
        double verkaufspreisAudiSuv = audi.verkaufen(audiSuv);
        System.out.println(audi.getName() + " ist um " + String.format("%.2f", verkaufspreisAudiSuv) + "€ reicher.");
    }
}
