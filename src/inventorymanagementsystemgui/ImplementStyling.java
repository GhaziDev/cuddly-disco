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

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

//to implement all styling methods from ButtonStyle and TableStyle
public class ImplementStyling implements ButtonStyle,TableStyle {
    @Override
    public void styleButton(Side side){
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        side.getItem.setForeground(Color.BLACK);
        side.getItem.setBackground(Color.WHITE);
        side.getItem.setBorder(compound);
        side.getAllItems.setForeground(Color.BLACK);
        side.getAllItems.setBackground(Color.WHITE);
        side.getAllItems.setBorder(compound);
        side.getItemWare.setForeground(Color.BLACK);
        side.getItemWare.setBackground(Color.WHITE);
        side.getItemWare.setBorder(compound);
        side.getAllBills.setForeground(Color.BLACK);
        side.getAllBills.setBackground(Color.WHITE);
        side.getAllBills.setBorder(compound);
        side.getAllItemsWare.setForeground(Color.BLACK);
        side.getAllItemsWare.setBackground(Color.WHITE);
        side.getAllItemsWare.setBorder(compound);
        side.setBill.setForeground(Color.BLACK);
        side.setBill.setBackground(Color.WHITE);
        side.setBill.setBorder(compound);
        side.setItem.setForeground(Color.BLACK);
        side.setItem.setBackground(Color.WHITE);
        side.setItem.setBorder(compound);

        
    }
    @Override
    public void styleBorder(Side side){
        side.getItem.setFocusPainted(false);
        side.getAllItems.setFocusPainted(false);
        side.setItem.setFocusPainted(false);
        side.getItemWare.setFocusPainted(false);
        side.getAllItemsWare.setFocusPainted(false);
        side.getAllBills.setFocusPainted(false);
        side.setBill.setFocusPainted(false);
    }
    
    @Override
    public void tableColor(MainWindow win){
        win.table.setForeground(Color.BLACK);
        win.table.setBackground(Color.WHITE);
        
    }
    @Override
    public void tableBorderAndFont(MainWindow win){
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        win.table.setFont(new Font("Serif",Font.BOLD,24));
        win.table.setBorder(compound);
    }
    
}
