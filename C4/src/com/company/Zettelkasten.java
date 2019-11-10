package com.company;
/**
 * @author Florian Eimann
 */

import java.util.*;


public class Zettelkasten implements Iterable<Medium> {

    private ArrayList<Medium> myZettelkasten = new ArrayList<>();

    public boolean addMedium(Medium medium){
        myZettelkasten.add(medium);
        sortierung = null;                          //weil Element hinzugefügt wurde, ist alte Sortierung hinfällig
        return true;
    }
    public void dropMedium(String titel)throws duplicateEntry {
        ArrayList<Medium> dopplungen = new ArrayList<>();
        for (Medium medium : myZettelkasten) {

            if (medium.getTitel() == titel) {                       //falls der Titel des Mediums dem gesuchten/eingegebenen Titel übereinstimmt füge der ArrayList dopplungen
                dopplungen.add(medium);
                if(dopplungen.size()>1){                            //Falls die Anzahl der Elemente in Dopplungen größer ist als 1 wirft er eine neue Fehlermedlung duplicate entry da das gesuchte Element 2 mal vorhanden ist
                    throw new duplicateEntry("duplicateEntry\n");
                }
            }else if(!myZettelkasten.contains(findMedium(titel))) { //falls der Titel in der schon gefüllten ArrayList myZettelkasten nicht vorhanden ist wird die Fehlermedlung zurückgegeben und die Schleife wird abgebrochen
                System.out.println("Titel ist nicht vorhanden!\n");
                break;
            }else{
            }
            }
        if(dopplungen.size()==1){                                       //Falls in der ArrayList genau ein Element gefunden wurde was ddem einegebenen String entspricht wird es gelöscht
            myZettelkasten.remove(dopplungen.get(0));
        }



        }




  public boolean dropMedium(String titel, int index){
        ArrayList<Medium> dopplungen = new ArrayList<>();
        for(Medium medium : myZettelkasten){
            if(medium.getTitel()==titel){
                dopplungen.add(medium);
            }
      }
        myZettelkasten.remove(dopplungen.get(index));
        System.out.println(dopplungen);
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
    //test
    public List<Medium> findMedium(String titel) {
        int i = 0;
            List<Medium> dopplungen = new ArrayList<>();
            List<Medium> dopplungenSortiert = new ArrayList<>();
            List<Medium> Zeitschrift = new ArrayList<>();
            List<Medium> CD = new ArrayList<>();
            List<Medium> Buch = new ArrayList<>();
            List<Medium> ElektronischesMedium = new ArrayList<>();

            for(Medium medium : myZettelkasten){
                if(medium.getTitel().equals(titel)){
                    dopplungen.add(medium);
                    if(medium.getClass().getName()=="com.company.Zeitschrift"){
                        Zeitschrift.add(medium);
                    }else if(medium.getClass().getName()=="com.company.CD") {
                        CD.add(medium);
                    }else if(medium.getClass().getName()=="com.company.Buch"){
                        Buch.add(medium);
                    }else if(medium.getClass().getName()=="com.company.ElektronischesMedium"){
                        ElektronischesMedium.add(medium);
                    }else{
                        i++;
                    }
                }

            }

            dopplungenSortiert.addAll(Zeitschrift);
            dopplungenSortiert.addAll(CD);
            dopplungenSortiert.addAll(Buch);
            dopplungenSortiert.addAll(ElektronischesMedium);




        return dopplungenSortiert;
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
