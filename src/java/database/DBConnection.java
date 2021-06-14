/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author VLADA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
 private Connection conn = null;
    private String url
     = "jdbc:mysql://localhost:3306/bike_shop_new";
    private String user = "root";
    private String password = "vlada123";
    private static DBConnection instance = null;
    
    private DBConnection() throws SQLException {
 
     try {
         Class.forName("com.mysql.jdbc.Driver");
     } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
     }
  

        conn = DriverManager.getConnection
        (url, user, password);
    }
    public static Connection getConn() 
            throws SQLException{
        if(instance==null)
            instance = new DBConnection();
        return instance.conn;
    }
}