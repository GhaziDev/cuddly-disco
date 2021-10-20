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
import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;

//side panel.
public class Side extends JPanel {
    JPanel side;
    JButton getItem; //from supermarket inventory
    JButton getAllItems; //from supermarket inventory
    JButton getItemWare;
    JButton getAllItemsWare; 
    JButton setItem;
    JButton setBill;
    JButton getAllBills;
    public Side(){
        this.side = new JPanel();
        this.getItem = new JButton("Fetch supermarket item");
        this.getAllItems = new JButton("Fetch all supermaket items");
        this.getAllItemsWare = new JButton("Fetch all warehouse items");
        this.getItemWare = new JButton("Fetch warehouse item");
        this.setItem = new JButton("Add item to supermarket");
        this.setBill = new JButton("Create a bill");
        this.getAllBills = new JButton("Fetch all bills");
}
    public void sideSetup(){
        this.side.setLayout(new GridLayout(0,1));
        this.side.setBounds(0, 0, 200,1000);
        this.getItem.setPreferredSize(new Dimension(1100,400));
        this.getAllItems.setPreferredSize(new Dimension(1100,400));
        this.getItemWare.setPreferredSize(new Dimension(1100,400));
        this.getAllItemsWare.setPreferredSize(new Dimension(1100,400));
        this.getAllBills.setPreferredSize(new Dimension(1100,400));
        this.setBill.setPreferredSize(new Dimension(1100,400));
        this.setItem.setPreferredSize(new Dimension(1100,400));
        this.side.add(getItem);
        this.side.add(getAllItems);
        this.side.add(getAllItemsWare);
        this.side.add(getItemWare);
        this.side.add(this.setBill);
        this.side.add(this.getAllBills);
        this.side.add(this.setItem);
        this.side.setVisible(true);
        
        
    }
    
    
}
