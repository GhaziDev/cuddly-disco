/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorymanagementsystemgui;

/**
 *
 * @author ghazi
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//EACH BILL IS A SINGLE PURCHASE.

//Bill will search the supermarket when adding and item.

public class Bill {
    public static Connection conn;
    public static String url="jdbc:derby:Inventory;create=true";
    public static String username="staff";
    public static String password="staff";
    boolean quantity_popup = false;
    boolean name_popup =  false;
    
     public String[][] getAllBills(){ //read from database
          String [][] empty = new String[1][];
          try{
            int i = 0;
            int count = 0;
            conn=DriverManager.getConnection(url, username, password);
            System.out.println(url+" connected...");
            Statement statement = conn.createStatement();
            ResultSet size = statement.executeQuery("SELECT * FROM BILL ORDER BY bill_id");
            while(size.next()){
                count = size.getInt("bill_id");
            }
            String [][] group = new String [count][];
            ResultSet result = statement.executeQuery("SELECT * FROM BILL");
            while(result.next()){
                String[] names = new String [5];
                names[0] = result.getString("bill_id");
                names[1] = result.getString("customername");
                names[2] = result.getString("itemname");
                names[3] = result.getString("itemquantity");
                names[4] = result.getString("itemprice");
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
     
     public void addBill(int id, String name,String itemname,int quantity){ //write into the database
         try{
            conn = DriverManager.getConnection(url,username,password);
            System.out.println(url+" connected...");
            String sql = "SELECT * FROM SUPERINVENTORY WHERE itemname=?";
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

                    String sql1 = "UPDATE SUPERINVENTORY SET itemquantity=? WHERE itemname=?";
                    PreparedStatement statement1 = conn.prepareStatement(sql1);
                    int new_quan = quan-quantity;
                    statement1.setInt(1,new_quan);
                    statement1.setString(2,itemname);
                    statement1.executeUpdate();
                    String sql2 = "INSERT INTO BILL (bill_id,customername,itemname,itemquantity,itemprice)"+" VALUES(? ,?, ?, ?,?)";
                    PreparedStatement statement2 = conn.prepareStatement(sql2);
                    statement2.setInt(1, id);
                    statement2.setString(2,name);
                    statement2.setString(3,itemname);
                    statement2.setInt(4, quantity);
                    statement2.setDouble(5,var); //item price for each.
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

     };
    
