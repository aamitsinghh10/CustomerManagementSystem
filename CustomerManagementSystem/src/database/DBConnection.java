package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection(){
        Connection conn = null;
        //1.load the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","amitsinghh10");
            System.out.println("Connected");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
