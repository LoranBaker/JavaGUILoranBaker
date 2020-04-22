/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package five;

import java.util.List;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author PC
 */
public class CustomerInfoFrame extends JFrame {
    
    private final JComponent component;

    public CustomerInfoFrame(String title, JComponent component) {
        super(title);
        this.component = component;
    }
    
    public void showFrame(){
        add(component);
        pack();
        setVisible(true);
    }
    /*
    public static void main(String[] args) {
     /*
        JComponent component1= new CustomerInfoPanel(CustomerInfoDao);
        CustomerInfoFrame customerInfo = new CustomerInfoFrame("Customer Info", component);
        SwingUtilities.invokeLater(customerInfo::showFrame);
    }*/
}
