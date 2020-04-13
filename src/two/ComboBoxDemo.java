
package two;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import one.CheckBoxPanel;

public class ComboBoxDemo extends JPanel implements ActionListener {
    
    private final JLabel pictureLabel;

    public ComboBoxDemo() {
        super(new BorderLayout());
        String[] petNames = {"Bird", "Cat", "Dog", "Pig", "Rabbit"};
        
        JComboBox<String> petComboBox = new JComboBox<>(petNames);
        petComboBox.setSelectedIndex(4);//default vrijednost
        petComboBox.addActionListener(this);
        
        this.pictureLabel=  new JLabel();
        updatePictureLabel(petNames[petComboBox.getSelectedIndex()]);
        
        add(petComboBox, BorderLayout.PAGE_START);
        add(pictureLabel, BorderLayout.PAGE_END);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //todo
        JComboBox<String> comboBox =(JComboBox<String>)e.getSource();
        String petName = (String) comboBox.getSelectedItem();
        updatePictureLabel(petName);
        
    }

    private void updatePictureLabel(String petName) {
        ImageIcon icon = createImageIcon(petName);
        pictureLabel.setIcon(icon);
    }
    
    private ImageIcon createImageIcon(String pictureName) {
        String fileName = pictureName + ".gif";
        URL imageURL = RadionButtonDemo.class.getResource(fileName);
        if (imageURL != null) {
            return new ImageIcon(imageURL);
        } else {
            System.err.printf("Nmg pronaci ikonicu", fileName);
            return null;
        }
    }
    
    static void createAndShowGUI() {
        //prozor
        JFrame frame = new JFrame("Demonstracija korištenja combo box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //kreirati kontrole i poredati ih
        JComponent combobox = new ComboBoxDemo();
        combobox.setOpaque(true);
        frame.setContentPane(combobox);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(ComboBoxDemo::createAndShowGUI);
    }

}
    

