package com.company;

/**
 * @author Florian Eimann
 */


public class duplicateEntry extends IllegalArgumentException {

    public duplicateEntry(String fehlermeldung){
        super(fehlermeldung);
    }
    public duplicateEntry(String fehlermeldung, Throwable fehler){
        super(fehlermeldung, fehler);
    }
}
