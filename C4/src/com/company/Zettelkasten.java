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
    public boolean dropMedium(String titel)throws duplicateEntry{
        ArrayList<Medium> dopplungen = new ArrayList<>();
            for(Medium test : myZettelkasten){
                dopplungen.add(findSingleMedium(titel));
                if(test.getTitel()==(null)){
                    System.out.println("Titel wurde nicht gefunden!!!");
                }else if(test.getTitel() == titel){
                  dopplungen.remove(findSingleMedium(titel));
                }
                else{
                    System.out.println("HAAALLOOO");
                }
            }

        return true;
    }

  public boolean dropMedium(String titel, int index)throws duplicateEntry{
        ArrayList<Medium> dopplungen = new ArrayList<>();
        for(Medium medium : myZettelkasten){
            dopplungen.add(medium);
      }
        myZettelkasten.remove(index);
        return true;

    }

    public boolean dropMedium(String titel, String alleLöschen){
        if(alleLöschen == "ja"){
        boolean gelöscht = false;
        for (Medium test5: findMedium(titel)) {
            gelöscht |= myZettelkasten.remove(test5);
        }
        return gelöscht;
        }else{
            System.out.println("Biite geben sie 'ja' ein wenn sie alle Duplikate löschen möchten!");
        }
        return true;
    }

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
            }else{
                Collections.sort(myZettelkasten, Collections.reverseOrder());
            }
            sortierung = false;
       }
        return true;

    }


}
