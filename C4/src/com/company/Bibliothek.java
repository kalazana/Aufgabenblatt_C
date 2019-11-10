package com.company;

/**
 * @author Florian Eimann
 */



import java.sql.*;

/**
 * The type Bibliothek.
 */
public class Bibliothek {
    private int i = 0;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       Zettelkasten zettelkasten = new Zettelkasten();

        zettelkasten.addMedium(new  Buch("Duden 01. Die deutsche Rechtschreibung", 2004, "Bibliographisches Institut, Mannheim","3-411-04013-0","-" ));  //Setzt die Strings für die jeweiligen Objekte
        zettelkasten.addMedium(new CD ("Beatles-CD", "Apple (bea (EMI))", "The Beatles"));
        zettelkasten.addMedium(new Zeitschrift("Der Spiegel", "0038-7452",54,6));
        zettelkasten.addMedium(new ElektronischesMedium("Hochschule-Stralsund", "http://www.hochschule-stralsund.de"));
        zettelkasten.addMedium(new CD("Live at Wembley", "Queen", "Parlophone (EMI)"));
        zettelkasten.sort(true); //

        //zettelkasten.dropMedium("Der Spiegel");
        //zettelkasten.findSingleMedium("4");
        //System.out.println(zettelkasten.findSingleMedium("Der Spiegel"));
        //System.out.println();

        for(Medium medium : zettelkasten){
            System.out.println(medium.calculateRepresentation());
            System.out.println();                                   //hinzugefügt für bessere lesbarkeit der Ausgabe, kann wenn nicht benötigt wird einfach entfernt werden

        }


        //gesamte Datenbank basiert auf der Vorlesung von Dr. Pieper (Apache Derby)


       try(                                                             //hier werden Daten erstellt und in die Datenbank eingelesen
            Connection con = createConnection();
            Statement statement = con.createStatement();){


            DatabaseMetaData metaData = con.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "Medien",null);

           if(!tables.next()){
                statement.execute(dbSaveerstellen());               //wenn Datenbank noch aktuell ist wird sie nicht geupdatet, ansonsten werden die selben Objekte immer wieder neu eingefügt
            }

            statement.executeUpdate(buildInsertStatement("CD","4","Apple","Test"));             //einfügen der Elemente in die Datenbank
            statement.executeUpdate(buildInsertStatement("ElektronischesMedium","test27","host.de"));
            statement.executeUpdate(buildInsertStatement("Zeitschrift","holger","4564356","37","42"));
            statement.executeUpdate(buildInsertStatement("Buch", "test", "27","test","test","test"));

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        final String query = "SELECT * FROM MEDIEN WHERE TYP = 'Buch'";              //Ab hier beginnt die Datenbank, SQL Anweisung zum auswählen was angezeigt werden soll

        try(
                Connection con = createConnection();                                 //stellt Verbidnung zur Datenbank her, hier wird ausgegebenn was in der Datenbank alles exisitiert (und der SQL anweisung entspricht
                Statement statement = con.createStatement();) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {                                                  //while Schleife zum durchgehen der gesamten Datenbank
                String id = result.getString("ID");                       //einzelne Kategorien die jedes Objekt hat (wenn das Obekt diese nicht besitzt wird es automatisch auf null gesetzt)
                String typ = result.getString("TYP");
                String titel = result.getString("TITEL");
                String label = result.getString("LABEL");
                String kuenstler = result.getString("KUENSTLER");
                String ISSN = result.getString("ISSN");
                String URL = result.getString("URL");
                String Nummer = result.getString("NUMMER");
                String Volume= result.getString("VOLUME");
                String Erscheinungsjahr = result.getString("ERSCHEINUNGSJAHR");
                String Verlag = result.getString("VERLAG");
                String Verfasser = result.getString("VERFASSER");
                System.out.printf("MEDIEN_ID: %s, Typ: %s, titel: %s, Label: %s, Kuenstler: %s, ISSN: %s, URL: %s, Nummer: %s, Volume: %s, Erscheinungsjahr: %s, Verlag: %s, Verfasser %s%n", id, typ, titel, label, kuenstler, ISSN, URL, Nummer,Volume, Erscheinungsjahr, Verlag, Verfasser);
            }
        }catch(ClassNotFoundException|SQLException e){
            e.printStackTrace();

        }

    }

    private static Connection createConnection() throws ClassNotFoundException, SQLException{               //Verbindung der Datenbank und IntelliJ, gibt Speicherort an
        Class.forName("org.apache.derby.impl.jdbc.EmbedConnection");
        Connection connection = DriverManager.getConnection("jdbc:derby:db/Medien;create=true");
        return connection;
    }



                                                                                                                                //überladene Methoden für die verschiedenen Medien
    private static String buildInsertStatement(String typ, String titel, String label, String kuenstler) {                      //für CD
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, LABEL, KUENSTLER)").append(String.format("VALUES('%s','%s','%s','%s')", typ, titel, label, kuenstler)).toString();
    }

    private static String buildInsertStatement (String typ, String titel,String erscheinungsjahr, String verlag, String                 //für Buch
            ISBN, String verfasser){
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, ERSCHEINUNGSJAHR, VERLAG, ISBN, VERFASSER)").append(String.format("VALUES('%s','%s','%s','%s', '%s', '%s')", typ, titel, erscheinungsjahr, verlag, ISBN, verfasser)).toString();
    }

    private static String buildInsertStatement (String typ, String titel,String ISSN, String volume, String nummer){                     //für Zeitschrift
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, ISSN, VOLUME, NUMMER)").append(String.format("VALUES('%s','%s','%s','%s', '%s')", typ, titel, ISSN, volume, nummer)).toString();
    }

    private static String buildInsertStatement (String typ, String titel,String URL){                                                       //für ElektronischesMedium
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, URL)").append(String.format("VALUES('%s','%s','%s')", typ, titel, URL)).toString();
    }


    private static String dbSaveerstellen() {                                                                   //Stringbuilder für die Medien, Attribute eingebaut da für alle Medien der selbe String Builder verwendet wird
        String nl = System.lineSeparator();
        return new StringBuilder()
                .append("CREATE TABLE MEDIEN").append(nl)
                .append("(").append(nl)
                .append("  ID INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,").append(nl)
                .append("  TYP VARCHAR(32),").append(nl)
                .append("  TITEL VARCHAR(32),").append(nl)
                .append("  LABEL VARCHAR(32),").append(nl)
                .append("  KUENSTLER VARCHAR(32),")
                .append("  ERSCHEINUNGSJAHR VARCHAR(32),")
                .append("  VERLAG VARCHAR(32),")
                .append("  ISBN VARCHAR(32),")
                .append("  VERFASSER VARCHAR(32),")
                .append("  ISSN VARCHAR(32),")
                .append("  VOLUME VARCHAR(32),")
                .append("  NUMMER VARCHAR(32),")
                .append("  URL VARCHAR(32),")
                .append("  PRIMARY KEY(ID)").append(")").toString();


    }



}

