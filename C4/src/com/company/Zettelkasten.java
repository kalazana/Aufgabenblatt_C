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


  public boolean dropMedium(String titel, int index){                   //Drop Methode für Dopplungen an bestimmten Stellen in der ArrayList dopplungen, startet bei 0
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

    public boolean dropMedium(String titel, String alleLoeschen){        //Methode um alle Medien zu loeschen, einfach Titel eingeben der geloescht werden soll und einen zweiten String "ja" als bestätigung das auch wirklich alles gelöscht werden soll
        if(alleLoeschen == "ja"){
        boolean geloescht = true;
        for (Medium test5: findMedium(titel)) {
            myZettelkasten.remove(test5);
        }
        return geloescht;
        }else{
            System.out.println("Biite geben sie 'ja' ein wenn sie alle Duplikate löschen möchten!");  //falls etwas anderes als ja eingeben wurde wird eine Fehlermedlung ausgebenen
        }
        return true;
    }

    public Medium findSingleMedium(String titel){                       //einen einzlenen Titel finden, der erste der gefunden wird, wird zurückgegeben
        for(Medium medium : myZettelkasten){
            if(medium.getTitel().equals(titel)){
                return medium;

            }
        }
        return null;

    }
    //test
    public List<Medium> findMedium(String titel) {                         //findet alle Medien, speichert sie in den jeweiligen ArrayListen, dabei hat jede Klasse ihre eigene, bei jedem Element wird geguckt in welche der Klasse es geht
                                                                            //danach wird es in die jeweiligen ArrayLists gepackt, diese ArrayListen werden in die sortierte ArrayListe in der richtigen reihenfolge gepackt
            List<Medium> dopplungen = new ArrayList<>();                    //als letztes wird dann die sortierte ArrayList ausgegeben
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
    public boolean sort(boolean absteigend){        //falls boolean absteigend true ist wird absteigend sortiert, dabei wird direkt überprüft ob der String schon einmmal genau in der Reihenfolge sortiert wurde
        if(absteigend==true){                         //ies wird auf null gesetzt jedes mal wenn ein medium hinzugefügt wird
            if (sortierung != null && sortierung.equals(true)){                 //wenn absteigend false gesetzt ist wird ebenfalls geguck ob es schon richtig sortiert wurde, wenn nicht sortiert er es richtig
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
