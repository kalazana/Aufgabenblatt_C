package com.company;
import java.net.URL;
/**
 * @author Florian Eimann
 */

/**
 * The type Elektronisches medium.
 */
public class ElektronischesMedium extends Medium{
    private String URL;

    /**
     * Instantiates a new Elektronisches medium.
     *
     * @param _titel the titel
     * @param _URL   the url
     */
    public ElektronischesMedium(String _titel, String _URL){  //Konstruktor für Elektronisches Medium
        super(_titel);
        setURL(_URL);

    }

    /**
     * Sets url.
     *
     * @param URL the url
     */
    public void setURL(String URL) {
    if (URL == null || URL.equals("")) {
            throw new IllegalArgumentException("Fehlerhafte URL!");
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
    public static boolean checkURL(String urlString)            //Zur überprüfung ob eine eingegebene URL existiert, wird in der Main überprüft mit einem Beispiel
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