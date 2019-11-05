package com.company.persistency;

import com.company.Zettelkasten;

import java.io.IOException;

public interface Persistency {

    public void save(Zettelkasten zk, String dateiname)throws IOException;
    public Zettelkasten load(String dateiname)throws IOException, ClassNotFoundException;

}
