package com.company;
import java.lang.reflect.Array;

/**
 * @author Florian Eimann
 */

/**
 * The type Medium.
 */
public abstract class Medium implements Comparable<Medium>{

    private String titel;

    /**
     * Instantiates a new Medium.
     *
     * @param titel the titel
     */
    public Medium(String titel){
        setTitel(titel);
    }                                        //abstrakte Definition für Titel (Grundgerüst) für alle anderen Klassen

    /**
     * Gets titel.
     *
     * @return the titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Sets titel.
     *
     * @param titel the titel
     */
    public void setTitel(String titel) {                                    //zur Überprüfung ob Titel = null oder leerer String ist, gibt dann Fehlermeldung zurück
        if(titel == null || titel.equals("")) {
            throw new IllegalArgumentException("Fehlerhafter Titel!");
        }else{
            this.titel = titel;
        }

    }

    /**
     * Calculate representation string.
     *
     * @return the string
     */
    public abstract String calculateRepresentation();       //für die Vererbung der Methode in die anderen Klassen

    @Override
    public int compareTo(Medium medium) {                           //Grundklasse für claculateRepresentation in den anderen Klassen/Methoden
        return this.getTitel().compareTo(medium.getTitel());
    }
}