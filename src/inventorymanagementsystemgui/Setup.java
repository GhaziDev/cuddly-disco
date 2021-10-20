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
//this class which connect all components and panels together and style all components.
public class Setup{
    Side side;
    MainWindow win;
    public Setup(Side side,MainWindow win){
        this.side = side;
        this.win = win;
    }
    public void initializeStyling(){
       ImplementStyling style =  new ImplementStyling();
       style.styleButton(side);
       style.styleBorder(side);
       style.tableBorderAndFont(win);
       style.tableColor(win);
    }
    
    
    
}
