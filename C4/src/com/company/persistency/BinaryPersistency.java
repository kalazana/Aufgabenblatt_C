package com.company.persistency;
/**
 * @author Florian Eimann
 */

import com.company.Medium;
import com.company.Zettelkasten;

import java.io.*;

public class BinaryPersistency implements Persistency{


    @Override
    public void save(Zettelkasten zk, String dateiname) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(dateiname)
        )) {
            out.writeObject(zk);
        }
    }

    @Override
    public Zettelkasten load(String dateiname) throws IOException, ClassNotFoundException{
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(dateiname))) {
        }
        return null;
    }
}

