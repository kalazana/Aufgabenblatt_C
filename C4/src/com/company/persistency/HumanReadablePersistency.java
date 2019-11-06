package com.company.persistency;
/**
 * @author Florian Eimann
 */

import com.company.Medium;
import com.company.Zettelkasten;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class HumanReadablePersistency implements Persistency {


    @Override
    public void save(Zettelkasten zk, String dateiname) throws IOException {
        try(BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(dateiname), "UTF-8"))){
            for (Medium medium : zk) {
                out.write(medium.calculateRepresentation());
            }




        }
    }

    @Override
    public Zettelkasten load(String dateiname) throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Operation nicht unterstützt!");

    }
}
