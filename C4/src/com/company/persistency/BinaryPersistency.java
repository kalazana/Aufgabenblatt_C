package com.company.persistency;

import com.company.Medium;
import com.company.Zettelkasten;

import java.io.*;

public class BinaryPersistency implements Persistency{


    @Override
    public void save(Zettelkasten zk, String dateiname) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dateiname));
            for (Medium medium : zk) {
                out.writeObject(zk);
            }

            out.close();
        } catch (IOException e) {

        }
    }

    @Override
    public Zettelkasten load(String dateiname) {
        return null;
    }
}
