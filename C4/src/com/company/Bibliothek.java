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

        zettelkasten.addMedium(new Buch("1", 2004, "Bibliographisches Institut, Mannheim","3-411-04013-0","-" ));  //Setzt die Strings für die jeweiligen Objekte
        zettelkasten.addMedium(new CD ("2", "Apple (bea (EMI))", "The Beatles"));
        zettelkasten.addMedium(new Buch("4", 2004, "Bibliographisches Institut, Mannheim","3-411-04013-0","-" ));
        zettelkasten.addMedium(new Zeitschrift("4", "0038-7452",54,6));
        zettelkasten.addMedium(new ElektronischesMedium("4", "http://www.hochschule-stralsund.de"));
        zettelkasten.addMedium(new CD("4", "Queen", "Parlophone (EMI)"));
        zettelkasten.addMedium(new Zeitschrift("4", "0038-7452",54,6));
        //zettelkasten.addMedium(new CD ("4", "Apple (bea (1)", "The Beatles"));
        //zettelkasten.addMedium(new CD ("4", "Apple (bea (2)", "The Beatles"));
        //zettelkasten.addMedium(new CD ("4", "Apple (bea (3)", "The Beatles"));
       // zettelkasten.addMedium(new Buch("4", 890, "asfgsdfg", "3-411-04013-0","-" ));
        //zettelkasten.sort(true); // für Aufgabe C.5
       // zettelkasten.dropMedium("4",1);
        //zettelkasten.findSingleMedium("4");
        //for(Medium medium : zettelkasten){

            System.out.println(zettelkasten.findMedium("4"));
            System.out.println();
        //}

    }
}
