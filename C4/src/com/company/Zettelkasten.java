package com.company;
/**
 * @author Florian Eimann
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Zettelkasten implements Iterable<Medium> {

    private ArrayList<Medium> myZettelkasten = new ArrayList<>();

    public boolean addMedium(Medium medium){
        myZettelkasten.add(medium);
        sortierung = null;                          //weil Element hinzugefügt wurde, ist alte Sortierung hinfällig
        return true;
    }
    private int n = 0;
    public boolean dropMedium(String titel)throws duplicateEntry{
        List<Medium> dopplungen = new ArrayList<>();
        if(dopplungen.size()>1){
            for(Medium test : dopplungen){
                if(test.getTitel().equals(titel)){
                    throw new duplicateEntry("duplicateEntry Exception");
                }
                else myZettelkasten.remove(findSingleMedium(titel));
            }
        }
        return myZettelkasten.remove(findSingleMedium(titel));
    }

   /* public boolean dropMedium(String titel, int inder)throws duplicateEntry{

        return myZettelkasten.remove(dopplungen.get(inder));
    }
    public boolean dropMedium(String titel, int index, int inde)throws duplicateEntry{

        return myZettelkasten.remove(dopplungen.get(index))&&myZettelkasten.remove(dopplungen.get(inde));
    }

    */

   /* public boolean dropAlleMedien(String titel){
        boolean gelöscht = false;
        for (Medium test5: findMedium(titel)) {
            gelöscht |= myZettelkasten.remove(test5);
        }
        return gelöscht;
    }*/




    public Medium findSingleMedium(String titel){
        for(Medium medium : myZettelkasten){
            if(medium.getTitel().equals(titel)){
                return medium;
            }
        }
        return null;

    }

    public List<Medium> findMedium(String titel) {
        List<Medium> dopplungen = new ArrayList<>();
        for(Medium medium : myZettelkasten){
            if(medium.getTitel().equals(titel)){
                    dopplungen.add(medium);
            }
        }

        return dopplungen;

    }

    public Iterator iterator(){
        return myZettelkasten.iterator();
    }
    Boolean sortierung = null;          //null unsortiert, true absteigend sortiert, false aufsteigend sortiert
    public boolean sort(boolean absteigend){
        if(absteigend==true){
            if (sortierung != null && sortierung.equals(true)){
                return false;
            }else{
                Collections.sort(myZettelkasten);
                sortierung = true;
            }

        }else{
            if(sortierung != null && sortierung.equals(false)){
                return false;
            }
            Collections.sort(myZettelkasten, Collections.reverseOrder());
            sortierung = false;
       }
        return true;

    }


}
