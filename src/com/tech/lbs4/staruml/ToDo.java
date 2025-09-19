package com.tech.lbs4.staruml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Eine Annotation für To-dos. Die Annotation ist nur bei Methoden, Konstruktoren und lokalen Variablen anwendbar.
 *
 * @author Lieke Schors
 * @version 5.0
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToDo {
    /**
     * Gibt die Aufgabe aus, die erledigt werden soll.
     *
     * @return
     *      die zu erledigende Aufgabe
     */
    String aufgabe();

    /**
     * Gibt das Datum zurück, bis wann das To-do aufgelöst sein soll.
     *
     * @return
     *      Das Deadline-Datum als String.
     */
    String bisDatum();

    /**
     * Gibt ein Boolean zurück, mit der Info, ob dieses To-do ein Muss ist bis zum Bis-Datum.
     *
     * @return
     *      ein Boolean mit der Info, ob das To-do erledigt werden muss.
     */
    boolean pflicht() default true;
}
