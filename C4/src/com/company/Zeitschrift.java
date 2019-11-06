package com.company;
/**
 * @author Florian Eimann
 */

/**
 * The type Zeitschrift.
 */
public class Zeitschrift extends Medium{


    private String ISSN;
    private int Volume;
    private int Nummer;

    /**
     * Instantiates a new Zeitschrift.
     *
     * @param _titel  the titel
     * @param _ISSN   the issn
     * @param _Volume the volume
     * @param _Nummer the nummer
     */
    public Zeitschrift(String _titel, String _ISSN, int _Volume, int _Nummer){      //Konstruktor für Zeitschrift
        super(_titel);
        setISSN(_ISSN);
        setVolume(_Volume);
        setNummer(_Nummer);

    }

    /**
     * Sets nummer.
     *
     * @param nummer the nummer
     */
    public void setNummer(int nummer) {
        if(nummer<0) {
            throw new IllegalArgumentException("Fehlerhafte Nummer!");
        }else{
            nummer = nummer;
        }

    }

    /**
     * Gets nummer.
     *
     * @return the nummer
     */
    public int getNummer() {
        return Nummer;
    }

    /**
     * Sets volume.
     *
     * @param Volume the volume
     */
    public void setVolume(int Volume) {
        if(Volume<0) {
            throw new IllegalArgumentException("Fehlerhaftes Volume!");
        }else{
            Volume = Volume;
        }
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public int getVolume() {
        return this.Volume;
    }

    /**
     * Sets issn.
     *
     * @param ISSN the issn
     */
    public void setISSN(String ISSN) {
        if(ISSN == null || ISSN.equals("")) {
            throw new IllegalArgumentException("Fehlerhafte ISSN!");
        }else{
        this.ISSN = ISSN;
        }

    }

    /**
     * Gets issn.
     *
     * @return the issn
     */
    public String getISSN() {
        return this.ISSN;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder Zeit = new StringBuilder();
        return Zeit.append("Titel: ").append(getTitel()).append("\nISSN: ").append(getISSN()).append("\nVolume: ").append(getVolume()).append("\nNummer: ").append(getNummer()).toString();     //StringBuilder für Zeitschrift

    }

}