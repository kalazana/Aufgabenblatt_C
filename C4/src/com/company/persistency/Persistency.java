package com.company.persistency;

import com.company.Zettelkasten;

public interface Persistency {

    public void save(Zettelkasten zk, String dateiname);
    public Zettelkasten load(String dateiname);

}
