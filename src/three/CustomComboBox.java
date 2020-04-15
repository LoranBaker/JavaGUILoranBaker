/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three;

import java.awt.BorderLayout;
import java.awt.Component;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import two.RadionButtonDemo;

public class CustomComboBox extends JPanel {
    
    private ImageIcon[] imageIcons;
    private String[] petStrings = {"Bird", "Cat", "Dog", "Pig", "Rabbit"};

    public CustomComboBox() {
        super(new BorderLayout());
        imageIcons = new ImageIcon[petStrings.length];
        Integer[] imageNumberArray = new Integer[petStrings.length];
        JComboBox<Integer> petList = new JComboBox<>();
        petList.setRenderer(null);
        
        
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
     
    class ComboBoxRenderer extends JLabel implements ListCellRenderer<Integer>{

        @Override
        public Component getListCellRendererComponent(JList<? extends Integer> list, Integer value, int index, boolean isSelected, boolean cellHasFocus) {
          
            return this;
        }
        
    }
    
}
