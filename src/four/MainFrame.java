
package four;



import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import three.ComboBoxPicturePanel;

public class MainFrame extends JFrame {

    private final JComponent component;

    public MainFrame(String title, JComponent component) {
        super(title);
        this.component = component;
    }

    public void showFrame() {
        add(component);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        ComboBoxPicturePanel boxPicturePanel = new ComboBoxPicturePanel();
       MainFrame mainFrame = new MainFrame("ComboBox with picture",boxPicturePanel);
       SwingUtilities.invokeLater(mainFrame::showFrame);
    }
}