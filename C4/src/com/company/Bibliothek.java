package com.company;

//Florian Eimann
import java.lang.reflect.Array;
import java.net.URL;

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
        Medium[] DBMedien = new Medium[4];


        DBMedien[0] =  new Buch("Duden 01. Die deutsche Rechtschreibung", 2004, "Bibliographisches Institut, Mannheim","3-411-04013-0","-" );  //Setzt die Strings für die jeweiligen Objekte
        DBMedien[1] =  new CD ("1", "Apple (bea (EMI))", "The Beatles");
        DBMedien[2] =  new Zeitschrift("Der Spiegel", "0038-7452",54,6);
        DBMedien[3] =  new ElektronischesMedium("Hochschule-Stralsund", "http://www.hochschule-stralsund.de");


        for(int i = 0; i < DBMedien.length; i++){
            System.out.println(DBMedien[i].calculateRepresentation());  //gibt die Elemente aus dem Array aus (Buch, CD etc.)

        }

        int[] isbn10 = new int[] { 3, 8, 6, 6, 8, 0, 1, 9, 2 };   //setzt die isbn ins array, überprüft die ISBN auf korrektheit, Methode ist in der Klasse Buch zu finden
        System.out.println(checkISBN10(isbn10));
        int[] isbn13 = new int[] { 9, 7, 8, 3, 7, 6, 5, 7, 2, 7, 8, 1, 8 };
        System.out.println(checkISBN13(isbn13));

        String URL = new String("http://www.hochschule-stralsund.de"); //erzeugt neuen String der Überprüft wird in der Methode checkURL zu finden in Elektronisches Medium
        System.out.println(checkURL(URL));
    }
}
