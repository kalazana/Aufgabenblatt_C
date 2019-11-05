package com.company;

/**
 * The type Cd.
 */
public class CD extends Medium {

    private String label;
    private String kuenstler;

    /**
     * Instantiates a new Cd.
     *
     * @param _titel     the titel
     * @param _label     the label
     * @param _kuenstler the kuenstler
     */
    public CD(String _titel, String _label, String _kuenstler) {  //Konstruktor für CD
        super(_titel);
        this.label = _label;
        this.kuenstler = _kuenstler;
    }


    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets label.
     *
     * @param label the label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Gets kuenstler.
     *
     * @return the kuenstler
     */
    public String getKuenstler() {
        return kuenstler;
    }

    /**
     * Sets kuenstler.
     *
     * @param kuenstler the kuenstler
     */
    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder CD = new StringBuilder();
        return CD.append("Titel: ").append(getTitel()).append("\nLabel: ").append(getLabel()).append("\nKuenstler: ").append(getKuenstler()).toString();        //Stringbuilder für CD

    }

}