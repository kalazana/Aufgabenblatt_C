package com.company;
/**
 * @author Florian Eimann
 */

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
        setLabel(_label);
        setKuenstler(_kuenstler);
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
        if(label == null || label.equals("")) {
            throw new IllegalArgumentException("Fehlerhaftes Lable!");
        }else{
            this.label = label;
        }

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
        if(kuenstler == null || kuenstler.equals("")) {
            throw new IllegalArgumentException("Fehlerhafter Kuenstler!");
        }else{
            this.kuenstler = kuenstler;
        }

    }

    @Override
    public String calculateRepresentation() {
        StringBuilder CD = new StringBuilder();
        return CD.append("Titel: ").append(getTitel()).append("\nLabel: ").append(getLabel()).append("\nKuenstler: ").append(getKuenstler()).toString();        //Stringbuilder für CD

    }

}