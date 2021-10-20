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
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

//this is the main panel where it contain JTable. 
public class MainWindow extends JPanel{
    JPanel main;
    JTable table;
    MainWindow(){
        main = new JPanel();
        table = new JTable();
        
    }
    
    public void initializeTable(String [][] group){
        main.setVisible(false);
        String [] column = {"Item ID","Item Name","Item Quantity","Item Price"};
        DefaultTableModel model = new DefaultTableModel(group,column){
            @Override
            public boolean isCellEditable(int row, int column)
    {
      return false;//This causes all cells to be not editable
    }
        };
        main.removeAll();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(1220,990));
        table.setRowHeight(100);
        main.add(scroll);
        main.setVisible(true);
        main.setBounds(500,500,1000, 1000);
    }
    
    public void initializeBillTable(String [][] group){
        
        main.setVisible(false);
        String [] column = {"Bill ID","Customer Name","Item Name","Item Quantity","Item Price"};
        DefaultTableModel model = new DefaultTableModel(group,column){
            @Override
            public boolean isCellEditable(int row, int column)
    {
      return false;//This causes all cells to be not editable
    }
        };
        main.removeAll();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(1220,990));
        table.setRowHeight(100);
        main.add(scroll);
        main.setVisible(true);
        main.setBounds(500,500,1000, 1000);
    }
    public void emptyTable(){
        main.setVisible(false);
        String [] column = {"","","","",""};
        String [][] group = new String[11][];
        DefaultTableModel model = new DefaultTableModel(group,column){
            @Override
            public boolean isCellEditable(int row, int column)
    {
      return false;//This causes all cells to be not editable
    }
        };
        main.removeAll();
        table.setModel(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(1220,990));
        table.setRowHeight(89);
        main.add(scroll);
        main.setVisible(true);
        main.setBounds(500,500,1000, 1000);
    } //an empty table to show if the user has not pressed any button yet.
    
}
