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

//WE WILL USE BOTH DATABASE AND GUI PART HERE.

//Basically each button on the side panel is going to have its own functionality (callback function).
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class ButtonEvent extends JFrame {
    Supermarket sButton;
    Warehouse wButton;
    Bill bButton;
    MainWindow main;

    public ButtonEvent(Supermarket m, Warehouse w, Bill b,MainWindow main){
        this.sButton = m;
        this.wButton = w;
        this.bButton = b;
        this.main = main;
        
    }
    
    public void addBillEvent(JButton btn){
            btn.addActionListener(e ->{
            JFrame frame = new JFrame();
            frame.setLayout(new GridLayout(0,1));
            JCustomTextField id = new JCustomTextField("BILL ID"); //the problem is that swing does not offer a placeholder.
            JCustomTextField cusName = new JCustomTextField("CUSTOMER NAME"); 
            JCustomTextField itemname = new JCustomTextField("ITEM NAME");
            JCustomTextField quantity = new JCustomTextField("QUANTITY");
            
            JButton submit = new JButton("submit");
            frame.add(id);
            frame.add(cusName);
            frame.add(itemname);
            frame.add(quantity);
            frame.add(submit,BorderLayout.EAST);
            frame.setMinimumSize(new Dimension(300,200));
            frame.setResizable(false);
            frame.setVisible(true);
            submit.addActionListener(e1->{
                String billId = id.getText();
                String customer = cusName.getText();
                String name = itemname.getText();
                String quan = quantity.getText();
                if(quan.equals("")|| billId.equals("")){
                    JOptionPane.showMessageDialog(frame,"QUANTITY OR BILL ID FIELDS ARE EMPTY.");
                }
                
                else{
                try{
                     bButton.addBill(Integer.parseInt(billId), customer, name, Integer.parseInt(quan));
                     frame.dispose();
                    }
                catch(NumberFormatException er){
                    JOptionPane.showMessageDialog(frame,"QUANTITY AND BILL ID MUST BE INTEGERS");
                    }
                catch(Exception r){
                    JOptionPane.showMessageDialog(frame, "BILL ID already exists.");
                }
         
                if(bButton.name_popup){
                    JOptionPane.showMessageDialog(frame, name+" is not available in supermarket.");
                    
                    
                }
                else if(bButton.quantity_popup){
                    JOptionPane.showMessageDialog(frame, "INVALID QUANTITY ");
                }
                }
                
                
            });
            
            
            
        }
        );
    }
    
    public void addSuperItem(JButton btn){
        btn.addActionListener(e ->{
            JFrame frame = new JFrame();
            frame.setLayout(new GridLayout(0,1));
            JCustomTextField itemname = new JCustomTextField("ITEM NAME");
            JCustomTextField quantity = new JCustomTextField("QUANTITY");
            JButton submit = new JButton("submit");
            frame.add(itemname);
            frame.add(quantity);
            frame.add(submit,BorderLayout.EAST);
            frame.setMinimumSize(new Dimension(300,150));
            frame.setResizable(false);
            frame.setVisible(true);
            submit.addActionListener(e1->{
                String name = itemname.getText();
                String quan = quantity.getText();
                if(quan.equals("")){
                    JOptionPane.showMessageDialog(frame,"QUANTITY FIELD IS EMPTY.");
                }
                else{
                try{
                    sButton.addItem(name, Integer.parseInt(quan));
                    frame.dispose();
                    
                }
                catch(NumberFormatException er){
                    System.out.println(Integer.getInteger(quan) instanceof Integer);
                    JOptionPane.showMessageDialog(frame,"QUANTITY MUST BE AN INTEGER.");
                }
  
         
                if(sButton.name_popup){
                    JOptionPane.showMessageDialog(frame, name+" is not available in warehouse.");
                    
                }
                else if(sButton.quantity_popup){
                    JOptionPane.showMessageDialog(frame, "INVALID QUANTITY ");
                }
                }
               
                
            });
            
            
            
        }
        );
    }
    
    public void addEventsButton(JButton btn){
        btn.addActionListener(e ->{
                JFrame frame = new JFrame();
                frame.setLayout(new GridLayout(0,1));
                JCustomTextField text = new JCustomTextField("ITEM NAME");
                JButton submit = new JButton("submit");
                submit.setPreferredSize(new Dimension(10,100));
                text.setPreferredSize(new Dimension(10,20));
                frame.add(text);
                frame.add(submit,BorderLayout.EAST);
                frame.setMinimumSize(new Dimension(300,100));
                frame.setResizable(false);
                frame.setVisible(true);
                submit.addActionListener(e1->{
                        String txt = text.getText();
                        main.initializeTable(sButton.searchSuperItem(txt));
                        frame.dispose();
                   

                });
                
                
                

        });
    }
    
    public void addEventwButton(JButton btn){
          btn.addActionListener(e ->{
          JFrame frame = new JFrame();
          frame.setLayout(new GridLayout(0,1));
          JCustomTextField text = new JCustomTextField("ITEM NAME");
          JButton submit = new JButton("submit");
          submit.setPreferredSize(new Dimension(50,50));
          text.setPreferredSize(new Dimension(200,200));
          frame.add(text);
          frame.add(submit,BorderLayout.EAST);
          frame.setMinimumSize(new Dimension(300,100));
          frame.setResizable(false);
          frame.setVisible(true);
          submit.addActionListener(e1->{
                  String txt = text.getText();
                  main.initializeTable(wButton.searchWareItem(txt));
                  frame.dispose();


          });
          




  });
    }
    
  
  public void addEventBillAll(JButton btn){
      btn.addActionListener(e->{
          main.initializeBillTable(bButton.getAllBills());
      });
  }
  public void addEventWareAll(JButton btn){
      btn.addActionListener(e->{
          main.initializeTable(wButton.getAllWareItems());
          
      });
  }
   public void addEventSuperAll(JButton btn){
       btn.addActionListener(e->{
           main.initializeTable(sButton.getAllSuperItems());
       });
  }
    
    
}
