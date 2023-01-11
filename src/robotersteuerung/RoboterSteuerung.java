/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package robotersteuerung;

import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.UIManager;

/**
 *
 * @author TvanDahl
 */
public class RoboterSteuerung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //FlatDarculaLaf.setup();
        //UIManager.put( "Textfield.arc", 999 );
        //try {UIManager.setLookAndFeel( new FlatDarculaLaf() );} 
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } 
        catch(Exception ignored){}
        UserInterface ui = new UserInterface();
        ui.setVisible(true);
    }
    
}
