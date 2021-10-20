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
public class Supermarket {
    public static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static Connection conn;
    public static String url="jdbc:derby:Inventory;create=true";
    public static String username="staff";
    public static String password="staff";
    
    boolean quantity_popup = false; //this bool variable will be used to indicate if a popup message should show or not, in ButtonEvent class
    boolean name_popup = false;
    public String[][] searchSuperItem(String item){ //read from database
          String [] names = new String[4];
          String [][] group = new String[1][];
          try{
            conn=DriverManager.getConnection(url,username,password);
            System.out.println(url+" connected...");
            String sql = "SELECT * FROM superinventory WHERE itemname =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, item);
            ResultSet result = statement.executeQuery();
            int i = 0;
            
            while(result.next()){
                names[0] = result.getString("itemid");
                names[1] = result.getString("itemname");
                names[2] = result.getString("itemquantity");
                names[3] = result.getString("itemprice");
                group[i] = names;
                i+=1;
            }    
        }
        catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
        }
        return group;   
    }
    public String[][] getAllSuperItems(){ //read from database
          String [][] empty = new String[1][];
          try{
            int i = 0;
            int count = 0;
            conn=DriverManager.getConnection(url,username,password);
            System.out.println(url+" connected...");
            Statement statement = conn.createStatement();
            ResultSet size = statement.executeQuery("SELECT * FROM SUPERINVENTORY ORDER BY itemid");
            while(size.next()){
                count = size.getInt("itemid");
            }
            String [][] group = new String [count][];
            ResultSet result = statement.executeQuery("SELECT * FROM SUPERINVENTORY");
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
        for(StackTraceElement e:ex.getStackTrace()){
            System.out.println(e);
        }
        }
        return empty; //the program wont ever reach here anyway, it only will end with `try` or `catch`
        
    }
    public void addItem(String itemname, int quantity){
        try{
            conn = DriverManager.getConnection(url,username,password);
            System.out.println(url+" connected...");
            String sql = "SELECT * FROM WAREINVENTORY WHERE itemname=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, itemname);
            ResultSet result = statement.executeQuery();
            double var;
            int var2;
            if(result.next()){
                var = result.getDouble("itemprice");
                var2 = result.getInt("itemid");
                int quan = result.getInt("itemquantity");
                if(quantity>quan || quantity<=0){
                    
                    //INVALID QUANTITY
                    quantity_popup = true;
                    
                }
                else{

                    String sql1 = "UPDATE WAREINVENTORY SET itemquantity=? WHERE itemname=?";
                    PreparedStatement statement1 = conn.prepareStatement(sql1);
                    double new_quan = quan-quantity;
                    statement1.setDouble(1,new_quan);
                    statement1.setString(2,itemname);
                    statement1.executeUpdate();
                    String supers = "SELECT * FROM SUPERINVENTORY WHERE itemname=? ";
                    PreparedStatement superstate = conn.prepareStatement(supers);
                    superstate.setString(1, itemname);
                    ResultSet super_res = superstate.executeQuery();
                    int super_quantity = 0;
                    if(super_res.next()){
                        super_quantity = super_res.getInt("itemquantity");
                    }
                    String sql2 = "UPDATE SUPERINVENTORY SET itemname = ?, itemquantity= ?, itemprice =? WHERE itemid =?";
                    PreparedStatement statement2 = conn.prepareStatement(sql2);
                    statement2.setString(1,itemname);
                    statement2.setInt(2, super_quantity+quantity);
                    statement2.setDouble(3, var);
                    statement2.setInt(4, var2);
                    statement2.executeUpdate();
                    

           

            
        }
            }
            
            else if(result.next()==false){
                name_popup = true;
            }
        }
        catch(SQLException e){
            System.out.println("SQL Error : "+e);
            for(StackTraceElement stack : e.getStackTrace()){
                System.out.println(stack);
            }
            
            
                    }
            
    }

    
}

