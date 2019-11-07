package com.company;

/**
 * @author Florian Eimann
 */


public class duplicateEntry extends IllegalArgumentException {

    public duplicateEntry(String fehlermeldung){
        super(fehlermeldung);
    }
}
