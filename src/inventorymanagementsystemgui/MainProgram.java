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
public class MainProgram extends JFrame{


    public static void main(String[] args) {
        JFrame frame = new JFrame("SuperMarket");
        Side side = new Side();
        Supermarket db = new Supermarket();
        Warehouse d = new Warehouse();
        Bill b1 = new Bill();
        MainWindow win = new MainWindow();
        side.sideSetup();
        win.emptyTable();
        Setup s = new Setup(side,win);
        s.initializeStyling();
        ButtonEvent b = new ButtonEvent(db,d,b1,win);
        frame.add(side.side);
        frame.add(win.main);
        b.addEventsButton(side.getItem);
        b.addEventwButton(side.getItemWare);
        b.addEventSuperAll(side.getAllItems);
        b.addEventWareAll(side.getAllItemsWare);
        b.addEventBillAll(side.getAllBills);
        b.addSuperItem(side.setItem);
        b.addBillEvent(side.setBill);
        frame.setSize(1000,1000);
        frame.setVisible(true);
    }
   
}






