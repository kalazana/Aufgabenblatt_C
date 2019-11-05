package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium> {

    private ArrayList<Medium> myZettelkasten = new ArrayList<>();

    public boolean addMedium(Medium medium){
        myZettelkasten.add(medium);
        return true;
    }

    public boolean dropMedium(String titel){
        return myZettelkasten.remove(findMedium(titel));
    }

    public Medium findMedium(String titel){
        for(Medium medium : myZettelkasten){
            if(medium.getTitel().equals(titel)){
                return medium;
            }
        }
        return null;

    }

    public Iterator iterator(){
        return myZettelkasten.iterator();
    }

  /*  public boolean Sort(){

    } */


}
