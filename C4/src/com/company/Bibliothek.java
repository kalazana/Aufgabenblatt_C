package com.company;

/**
 * @author Florian Eimann
 */


import static com.company.Buch.checkISBN10;
import static com.company.Buch.checkISBN13;
import static com.company.ElektronischesMedium.checkURL;

/**
 * The type Bibliothek.
 */
public class Bibliothek {
    private int i = 0;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       Zettelkasten zettelkasten = new Zettelkasten();

       // zettelkasten.addMedium(new Buch("Duden 01. Die deutsche Rechtschreibung", 2004, "Bibliographisches Institut, Mannheim","3-411-04013-0","-" ));  //Setzt die Strings für die jeweiligen Objekte
       // zettelkasten.addMedium(new CD ("1", "Apple (bea (EMI))", "The Beatles"));
       // zettelkasten.addMedium(new Zeitschrift("Der Spiegel", "0038-7452",54,6));
       // zettelkasten.addMedium(new ElektronischesMedium("Hochschule-Stralsund", "http://www.hochschule-stralsund.de"));
         zettelkasten.addMedium(new CD("4", "Queen", "Parlophone (EMI)"));
        zettelkasten.addMedium(new CD ("4", "Apple (bea (1)", "The Beatles"));
        zettelkasten.addMedium(new CD ("4", "Apple (bea (2)", "The Beatles"));
        zettelkasten.addMedium(new CD ("4", "Apple (bea (3)", "The Beatles"));
     //  zettelkasten.findMedium("4");
    //    zettelkasten.addMedium(new Buch(" ", 890, "asfgsdfg", "3-411-04013-0"," " ));
        zettelkasten.sort(false); // für Aufgabe C.5
       zettelkasten.dropAlleMedien("4");

        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());
            System.out.println();
        }
    }
}
