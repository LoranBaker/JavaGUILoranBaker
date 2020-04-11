/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    
    private final JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    public ButtonPanel() {
        ImageIcon leftButtonIcon = createImageIcon("left.gif");
       leftButton = new JButton("Disable button in the middle", leftButtonIcon);
        add(leftButton);
    }
    
    private ImageIcon createImageIcon(String fileNime){
        URL imageURL = ButtonPanel.class.getResource(fileNime);
        if(imageURL != null){
            return new ImageIcon(imageURL);
        }else{
            System.err.printf("Nmg pronaci ikonicu", fileNime);
            return null;
        }
    }
    
    static void createAndShowGUI(){
        JFrame frame = new JFrame("Demonstracija koristenja dugmica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setOpaque(true);
        frame.setContentPane(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(()->createAndShowGUI());
    }
    
}
