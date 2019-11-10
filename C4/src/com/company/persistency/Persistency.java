package com.company.persistency;
/**
 * @author Florian Eimann
 */

import com.company.Zettelkasten;

import java.io.IOException;

public interface Persistency {

    public void save(Zettelkasten zk, String dateiname)throws IOException;
    public Zettelkasten load(String dateiname)throws IOException, ClassNotFoundException;                   //Interface zum implementieren von persistency(save)

}



