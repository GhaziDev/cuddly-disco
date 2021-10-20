/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystemgui;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;


/**
 *
 * @author ghazi
 */
public class Warehouse {
    public static Connection conn;
    public static String url="jdbc:derby:Inventory;create=true";
    public static String username="staff";
    public static String password="staff";
    public String[][] searchWareItem(String item){ //read from database
          String [] names = new String[4];
          String [][] group = new String[1][];
          try{
            conn=DriverManager.getConnection(url, username, password);
            System.out.println(url+" connected...");
            String sql = "SELECT * FROM superinventory WHERE itemname =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, item);
            ResultSet result = statement.executeQuery();
            
            while(result.next()){
                names[0] = result.getString("itemid");
                names[1] = result.getString("itemname");
                names[2] = result.getString("itemquantity");
                names[3] = result.getString("itemprice");
            }
            group[0] = names;    
        }
        catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
        }
        return group;   
        
    }
    public String[][] getAllWareItems(){ //read from database
          String [][] empty = new String[1][];
          try{
            int i = 0;
            int count = 0;
            conn=DriverManager.getConnection(url,username,password);
            System.out.println(url+" connected...");
            Statement statement = conn.createStatement();
            ResultSet size = statement.executeQuery("SELECT * FROM WAREINVENTORY ORDER BY itemid");
            while(size.next()){
                count = size.getInt("itemid");
            }
            String [][] group = new String [count][];
            ResultSet result = statement.executeQuery("SELECT * FROM WAREINVENTORY");
            while(result.next()){
                String[] names = new String [4];
                names[0] = result.getString("itemid");
                names[1] = result.getString("itemname");
                names[2] = result.getString("itemquantity");
                names[3] = result.getString("itemprice");
                group[i] = names;
                i+=1;
        }
            return group;
          }

        catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
        }
        return empty; //the program wont ever reach here anyway, it only will end with `try` or `catch`
        
    }
}
