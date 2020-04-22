/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package five;

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
    
    public static void main(String[] args) throws SQLException {
        String URL = "jdbc:derby://localhost:1527/sample";
        DerbyConnectionPool connectionPool = new DerbyConnectionPool(URL);
        //CRUD-statements na SQL bazu
        CustomerInfoDao customerInfoDao = new CustomerInfoDao(connectionPool);
        //VIEW
        JComponent component = new CustomerInfoPanel(customerInfoDao);
        CustomerInfoFrame customerInfoFrame = new CustomerInfoFrame("Customer info", component);
        SwingUtilities.invokeLater(customerInfoFrame::showFrame);
    }
}
