/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author RemasTech
 */
public class Model {
     private Connection connect() throws SQLException{
    
    Connection conn= null;
    String url = "jdbc:sqlite:C:/Users/RemasTech/Desktop/UQU/Advance Programming/Hotels.db";
    conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established");
        return conn;
    }
            
      public void registerUser (String username, String password) throws SQLException{
      String sql = "INSERT INTO Users (UserName, Password ) VALUES ('"+username+"','"+password+"' )";
      Connection con =  this.connect();
      Statement st = con.createStatement();
      st.executeUpdate(sql);
      st.close();
      con.close ();
          System.out.println("okay  ");
      }
       public boolean loginuser (String username, String password )throws SQLException  
       {
           
           String sql = "SELECT UserName, Password FROM Users";
             Connection con =  this.connect();
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      boolean b = false;    
      while(rs.next())
        {
            String n = rs.getString("UserName");
            String p = rs.getString("Password");
            if(username.equals(n) && password.equals(p))
            {
               
                b = true;
                break;
            }
            else
            {
                
                b= false;
            }
            
        }
         st.close();
         con.close();
        return b;
        
    }  
       }

