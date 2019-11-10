package com.company;

/**
 * @author Florian Eimann
 */

/**
 * The type Buch.
 */
public class Buch extends Medium{

    private int Erscheinungsjahr;
    private String Verlag;
    private String ISBN;
    private String Verfasser;



    /**
     * Instantiates a new Buch.
     *
     * @param _titel            the titel
     * @param _Erscheinungsjahr the erscheinungsjahr
     * @param _Verlag           the verlag
     * @param _ISBN             the isbn
     * @param _Verfasser        the verfasser
     */
    public Buch(String _titel, int _Erscheinungsjahr, String _Verlag, String _ISBN, String _Verfasser){         //Konstruktor für Buch
        super(_titel);
        this.Erscheinungsjahr = setErscheinungsjahr(_Erscheinungsjahr);
        this.Verlag= setVerlag(_Verlag);
        this.Verfasser = setVerfasser(_Verfasser);
        setISBN(_ISBN);

    }



    public String calculateRepresentation() {                                   //Stringbuilder für Buch
        StringBuilder Bch = new StringBuilder();
        return Bch.append("Titel: ")
                .append(getTitel())
                .append("\nErscheinungsjahr: ")
                .append(getErscheinungsjahr())
                .append("\nVerlag: ")
                .append(getVerlag())
                .append("\nISBN: ")
                .append(getISBN())
                .append("\nVerfasser ")
                .append(getVerfasser())
                .toString(); //Stringbuilder für Buch

    }

    /**
     * Sets verfasser.
     *
     * @param verfasser the verfasser
     * @return
     */
    public String setVerfasser(String verfasser) {                              //Verfasser wird überprüft ob er null oder leerer String ist, wenn nicht wird der Verfasser gesetzt, ansosnten kommt eine Fehlermeldung
        if(verfasser == null || verfasser.equals("")) {
            throw new IllegalArgumentException("Fehlerhafter Verfasser!");
        }else{
            this.Verfasser = Verfasser;
        }
        return verfasser;
    }

    /**
     * Gets verfasser.
     *
     * @return the verfasser
     */
    public String getVerfasser() {
        return this.Verfasser = Verfasser;
    }

    /**
     * Sets isbn.
     *
     * @param ISBN the isbn
     */
    public void setISBN(String ISBN) {
        // [...] = Zeichenkategorie
        // ^ = Invertierung

        //Mithilfe von Simon Biewald !!!
        String zahlentester = ISBN.replaceAll("[^0-9X]", "");  //eckige zeichen = zeichenkategorie; ZAhlen von 0-9 sind erlaubt, sowei x, alles andere wird entfernt (weil bindestriche
        int[] zahlen = new int[13];                                              //erstellt ein nuees maximaL 13 zeichen großes array, 0-9 und x sind erlaubt , alles andere wird ersetzt (weil Bindestriche bei ISBN sind)
        for(int i = 0; i< zahlentester.length(); i++) {                          //for schleife die das array durch geht
            char c = zahlentester.charAt(i);
            if(c == 'X') {                                                       //ersetzt das Zeichen X durch 10
                zahlen[i] = 10;
            }else{
                zahlen[i] = c;
            }
        }
        if(zahlentester.length() == 10 && checkISBN10(zahlen)){                 //ISBN checker 10 wird getestet wenn bedingung der länge erfüllt ist
            this.ISBN = ISBN;
        }else if(zahlentester.length() == 13 && checkISBN13(zahlen)){           //ISBN 13 checker wird getestet, wenn bedingung stimmt dass die länge 13 ist
            this.ISBN = ISBN;
        } else {
            throw new IllegalArgumentException("Fehlerhafte ISBN!!!");          //falls isbn andere länge hat wird diese Fehlermeldung ausgegeben
        }

    }



    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getISBN() {

        return ISBN;
    }

    /**
     * Sets verlag.
     *
     * @param verlag the verlag
     * @return
     */
    public String setVerlag(String verlag) {                            //Verlag wird überprüft ob er null oder leerer String ist, wenn nicht wird der Verlag gesetzt, ansosnten kommt eine Fehlermeldung
        if(verlag == null || verlag.equals("")) {
            throw new IllegalArgumentException("Fehlerhafter Verlag!");
        }else{
            this.Verlag = Verlag;
        }

        return verlag;
    }

    /**
     * Gets verlag.
     *
     * @return the verlag
     */
    public String getVerlag() {

        return Verlag;
    }

    /**
     * Sets erscheinungsjahr.
     *
     * @param erscheinungsjahr the erscheinungsjahr
     * @return
     */
    public int setErscheinungsjahr(int erscheinungsjahr) {                  //falls Erscheinungsjahr vor 870 angegeben wird, wird fehlermedlung ausgegeben (siehe link für begrüdnung)
        if(erscheinungsjahr<870) {
            throw new IllegalArgumentException("Fehlerhaftes Erscheinungsjahr: https://www.history.de/news/detail/das-aelteste-buch-der-welt.html");
        }else{
            erscheinungsjahr = erscheinungsjahr;
        }
        return erscheinungsjahr;
    }

    /**
     * Gets erscheinungsjahr.
     *
     * @return the erscheinungsjahr
     */
    public int getErscheinungsjahr() {

        return Erscheinungsjahr;
    }


    /**
     * Check isbn 10 boolean.
     *
     * @param isbn the isbn
     * @return the boolean
     */
    public static boolean checkISBN10(int[] isbn) {  //Methode zur Überprüfung ider ISBN auf korrektheit, wird in der Main mit jeweils einem Beispiel überprüft
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check isbn 13 boolean.
     *
     * @param isbn the isbn
     * @return the boolean
     */
    public static boolean checkISBN13(int[] isbn) {  //Methode zur Überprüfung ider ISBN auf korrektheit, wird in der Main mit jeweils einem Beispiel überprüft
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }

}
