
package seven;

import five.CustomerInfoDao;
import five.CustomerInfoPanel;
import five.DerbyConnectionPool;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GuiStarter extends JFrame {

    private JPanel panel;

    public GuiStarter(JPanel panel) {
        this.panel = panel;
    }

    public void showFrame() {
        setTitle("Test");
        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        DerbyConnectionPool pool = new DerbyConnectionPool();
        CustomerInfoDao customerDao = new CustomerInfoDao(pool);
        JPanel custJPanel = new CustomerPanel(customerDao);
        GuiStarter gs = new GuiStarter(custJPanel);
        SwingUtilities.invokeLater(gs::showFrame);
    }
}