package com.tech.lbs4.staruml;

/**
 * Klasse, die die Main-Methode enthält.
 *
 * @author Lieke Schors
 * @version 1.0
 */
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

        Suv audiSuv = new Suv(); // Ist ein PKW, ist ein Fahrzeug, in dieser Beziehung in pkw sowohl eine allgemeine (für SUV) als auch eine spezielle Klasse (von Fahrzeug)
        audiSuv.setHersteller(audi);
        audiSuv.setSuvTyp(SuvTyp.MITTELKLASSE);
        audiSuv.set_4x4(true);
        audiSuv.setFarbe("Schwarz");
        audiSuv.blinken();
        audiSuv.setPreis(50_000);

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
        // monsterTruck.verkaufen(); Nicht möglich, weil Klasse Interface Verkaufbar nicht implementiert.

        System.out.println("\nLKW");
        Lkw lkw = new Lkw(); // Ist ein Fahrzeug
        lkw.setLkwTyp(LkwTyp.SCHWERTRANSPORT);
        lkw.starten(); // Möglich, weil auch diese Klasse von Fahrzeug ableitet
        lkw.beschleunigen();
        lkw.schalten(true);
        // lkw.huepfen(); ist nicht möglich, weil der LKW kein Monstertruck ist.
        lkw.setPreis(100_000);
        // audiSuv.ladungEntkoppeln(); Geht nicht, da audiSuv nicht von LKW ableitet.
        Hersteller lkwHersteller = new Hersteller("LKW-Hersteller");
        lkw.setHersteller(lkwHersteller);

        Motor motor = new Motor(audi, 300, MotorTyp.VERBRENNUNG);
        // motor.verkaufen(); geht nicht, weil die Klasse Verkaufbar nicht implementiert
        // motor.getPreis(); geht nicht, weil der Motor kein Fahrzeug ist (in diesem Sinne)

        audiSuv.setPreis(25000);
        double verkaufspreisAudiSuv = audiSuv.verkaufen();
        System.out.println("UVP: " + String.format("%.2f", audiSuv.getPreis()) + "€; Verkaufspreis: " + String.format("%.2f", verkaufspreisAudiSuv) + "€, "+ audi.getName() + " ist um " + String.format("%.2f", verkaufspreisAudiSuv) + "€ reicher.");

        double verkaufspreisLkw = lkw.verkaufen();
        System.out.println("UVP: " + String.format("%.2f", lkw.getPreis()) + "€; Verkaufspreis: " + String.format("%.2f", verkaufspreisLkw) + "€, "+ lkwHersteller.getName() + " ist um " + String.format("%.2f", verkaufspreisLkw) + "€ reicher.");



        //ToDo(aufgabe = "Fixen", bisDatum = "20.09.2025")
//        System.out.println("To-dos:\n");
//        try (ScanResult scanResult = new ClassGraph()
//                .enableClassInfo()
//                .acceptPackages("com.tech.lbs4.staruml")
//                .enableAnnotationInfo()
//                .scan()) {
//
//            for (ClassInfo classInfo : scanResult.getClassesWithAnnotation(ToDo.class.getName())) {
//                Class<?> clazz = classInfo.loadClass();
//                Annotation[] annotations = clazz.getAnnotations();
//
//                for (Annotation annotation : annotations) {
//                    annotation.annotationType();
//                    if (annotation.annotationType().getName().equals(ToDo.class.getTypeName())) {
//                        ToDo todo = clazz.getAnnotation(ToDo.class);
//                        System.out.println("Klasse: " + clazz.getName());
//                        System.out.println("Aufgabe: " + todo.aufgabe());
//                        System.out.println("Bis Datum: " + todo.bisDatum());
//                        System.out.println("Pflicht? " + todo.pflicht());
//                        System.out.println(); // Leerzeile zur Trennung
//                    }
//                }
//            }
//        }
    }
}
