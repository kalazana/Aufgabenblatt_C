package com.company;
import java.lang.reflect.Array;

/**
 * The type Medium.
 */
public abstract class Medium {

    private String titel;

    /**
     * Instantiates a new Medium.
     *
     * @param titel the titel
     */
    public Medium(String titel){
        this.titel = titel;
    }       //abstrakte Definition für Titel (Grundgerüst) für alle anderen Klassen

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
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Calculate representation string.
     *
     * @return the string
     */
    public abstract String calculateRepresentation();       //für die Vererbung der Methode in die anderen Klassen









}