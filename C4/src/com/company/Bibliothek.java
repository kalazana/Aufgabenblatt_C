package com.company;

/**
 * @author Florian Eimann
 */


import javax.xml.transform.Result;
import java.sql.*;

import static com.company.Buch.checkISBN10;
import static com.company.Buch.checkISBN13;
import static com.company.ElektronischesMedium.checkURL;

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

        zettelkasten.addMedium(new Buch("1", 2004, "Bibliographisches Institut, Mannheim","3-411-04013-0","-" ));  //Setzt die Strings für die jeweiligen Objekte
        zettelkasten.addMedium(new CD ("2", "Apple (bea (EMI))", "The Beatles"));
        zettelkasten.addMedium(new Buch("4", 2004, "Bibliographisches Institut, Mannheim","3-411-04013-0","-" ));
        zettelkasten.addMedium(new Zeitschrift("4", "0038-7452",54,6));
        zettelkasten.addMedium(new ElektronischesMedium("4", "http://www.hochschule-stralsund.de"));
        zettelkasten.addMedium(new CD("4", "Queen", "Parlophone (EMI)"));
        zettelkasten.addMedium(new Zeitschrift("4", "0038-7452",54,6));
        //zettelkasten.addMedium(new CD ("4", "Apple (bea (1)", "The Beatles"));
        //zettelkasten.addMedium(new CD ("4", "Apple (bea (2)", "The Beatles"));
        //zettelkasten.addMedium(new CD ("4", "Apple (bea (3)", "The Beatles"));
       // zettelkasten.addMedium(new Buch("4", 890, "asfgsdfg", "3-411-04013-0","-" ));
        //zettelkasten.sort(true); // für Aufgabe C.5
       // zettelkasten.dropMedium("4",1);
        //zettelkasten.findSingleMedium("4");
        //for(Medium medium : zettelkasten){

            System.out.println(zettelkasten.findMedium("4"));
            System.out.println();
        //}

       final String query = "SELECT * FROM MEDIEN WHERE TYP = 'Buch'";

        try(
                Connection con = createConnection();
                Statement statement = con.createStatement();) {
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                String id = result.getString("ID");
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



       try(
            Connection con = createConnection();
            Statement statement = con.createStatement();){


            DatabaseMetaData metaData = con.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "Medien",null);

           // if(!tables.next()){
             //   statement.execute(dbSaveerstellen());
            //}

            statement.executeUpdate(buildInsertStatement("CD","4","Apple","Test"));
            statement.executeUpdate(buildInsertStatement("ElektronischesMedium","test27","host.de"));
            statement.executeUpdate(buildInsertStatement("Zeitschrift","holger","4564356","37","42"));
            statement.executeUpdate(buildInsertStatement("Buch", "test", "27","test","test","test"));

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    private static Connection createConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.apache.derby.impl.jdbc.EmbedConnection");
        Connection connection = DriverManager.getConnection("jdbc:derby:db/Medien;create=true");
        return connection;
    }




    private static String buildInsertStatement(String typ, String titel, String label, String kuenstler) {
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, LABEL, KUENSTLER)").append(String.format("VALUES('%s','%s','%s','%s')", typ, titel, label, kuenstler)).toString();
    }



    private static String buildInsertStatement (String typ, String titel,String erscheinungsjahr, String verlag, String
            ISBN, String verfasser){
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, ERSCHEINUNGSJAHR, VERLAG, ISBN, VERFASSER)").append(String.format("VALUES('%s','%s','%s','%s', '%s', '%s')", typ, titel, erscheinungsjahr, verlag, ISBN, verfasser)).toString();
    }
    private static String buildInsertStatement (String typ, String titel,String ISSN, String volume, String nummer){
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, ISSN, VOLUME, NUMMER)").append(String.format("VALUES('%s','%s','%s','%s', '%s')", typ, titel, ISSN, volume, nummer)).toString();
    }
    private static String buildInsertStatement (String typ, String titel,String URL){
        return new StringBuilder("INSERT INTO MEDIEN").append("(TYP, TITEL, URL)").append(String.format("VALUES('%s','%s','%s')", typ, titel, URL)).toString();
    }
    private static String dbSaveerstellen() {
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

