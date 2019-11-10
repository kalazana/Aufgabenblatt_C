package com.company;

/**
 * @author Florian Eimann
 */


public class duplicateEntry extends IllegalArgumentException {                                          //selbstgeschriebene Fehlermeldung, wird dann in der Klasse Zettelkasten bei DropMedium dann eingesetzt, soll einfach nur verhindern dass man etwas löscht was mehrfach vorhanden ist

    public duplicateEntry(String fehlermeldung){
        super(fehlermeldung);
    }
}
