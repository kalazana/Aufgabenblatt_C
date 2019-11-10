package com.company;
import java.net.URL;
/**
 * @author Florian Eimann
 */

/**
 * The type Elektronisches medium.
 */
public class ElektronischesMedium extends Medium{
    private String URL;                                        //String für die URL

    /**
     * Instantiates a new Elektronisches medium.
     *
     * @param _titel the titel
     * @param _URL   the url
     */
    public ElektronischesMedium(String _titel, String _URL){  //Konstruktor für Elektronisches Medium
        super(_titel);                                          //aus Klasse Medium
        setURL(_URL);                                           //so gemacht damit im setter direkt überprüft wird ob die URL stimmt

    }

    /**
     * Sets url.
     *
     * @param URL the url
     */
    public void setURL(String URL) {
    if (!checkURL(URL)) {
            throw new IllegalArgumentException("Fehlerhafte URL!");         //setter für URL mit Fehlermeldung falls URL mithilfe der check URL Methode als fehlerhaft gekennzeichnet wird
        }else{
            this.URL = URL;
        }
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getURL() {
        return URL;
    }


    /**
     * Check url boolean.
     *
     * @param urlString the url string
     * @return the boolean
     */
    public static boolean checkURL(String urlString)            //Zur überprüfung ob eine eingegebene URL existiert
    {
        try
        {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception)
        {
            return false;
        }
    }

    public String calculateRepresentation() {
        StringBuilder EM = new StringBuilder();
        return EM.append("Titel: ").append(getTitel()).append("\nURL: ").append(getURL()).toString();  //Stringbuilder für Elektronisches Medium

    }

}