package controllers;
import java.sql.*;

public class Conn {
    Connection c;
    public Statement s;

    public Conn() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","");
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
