package digital.library.management;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///digitallibrarymanagement","root","Sai#1407");
            s = c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
