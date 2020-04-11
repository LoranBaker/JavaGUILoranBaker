/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener{
    
    private final JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    public ButtonPanel() {
        ImageIcon leftButtonIcon = createImageIcon("right.gif");
        leftButton = new JButton("Disable button in the middle", leftButtonIcon);
        leftButton.setVerticalTextPosition(AbstractButton.CENTER);
        leftButton.setHorizontalTextPosition(AbstractButton.LEADING);
        leftButton.setMnemonic(KeyEvent.VK_D);
        leftButton.setActionCommand("disable");
        add(leftButton);
        
        ImageIcon middleButtonIcon = createImageIcon("middle.gif");
        middleButton = new JButton("Middle", middleButtonIcon);
        middleButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        middleButton.setHorizontalTextPosition(AbstractButton.CENTER);
        middleButton.addActionListener(this);
        add(middleButton);
        
        ImageIcon rightButtonIcon = createImageIcon("left.gif");
        rightButton = new JButton("Right", rightButtonIcon);
        rightButton.setMnemonic(KeyEvent.VK_E);
        rightButton.setActionCommand("enable");
        rightButton.addActionListener(this);
        add(rightButton);
    }
    
    private ImageIcon createImageIcon(String fileName){
        URL imageURL = ButtonPanel.class.getResource(fileName);
        if(imageURL != null){
            return new ImageIcon(imageURL);
        }else{
            System.err.printf("Nmg pronaci ikonicu", fileName);
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
       java.awt.EventQueue.invokeLater(ButtonPanel::createAndShowGUI);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        if("disable".equals(actionCommand)){
            leftButton.setEnabled(false);
            middleButton.setEnabled(false);
            rightButton.setEnabled(true);
            
        }else if("enable".equals(actionCommand)){
            leftButton.setEnabled(true);
            middleButton.setEnabled(true);
            rightButton.setEnabled(false);
        
        }else{
            System.out.println("eror");
        }
        
    }
    
}
