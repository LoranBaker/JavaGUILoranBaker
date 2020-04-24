/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package six;

import five.CustomerInfoDao;
import five.DerbyConnectionPool;
import java.sql.SQLException;
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
    
    public static void main(String[] args) throws SQLException, SQLException{
      
       
       DerbyConnectionPool connectionPool = new DerbyConnectionPool();
       
       CustomerInfoDao customerInfoDao = new CustomerInfoDao(connectionPool);
       
       JComponent jComponent = new CustomerInfoPanel(customerInfoDao);
       CustomerInfoFrame customerInfoFrame = new CustomerInfoFrame("Customer info", jComponent);
       SwingUtilities.invokeLater(customerInfoFrame::showFrame);
    }
}