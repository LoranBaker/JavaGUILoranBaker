/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package three;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBoxPanel extends JPanel implements ActionListener{
    
    private String currentPattern;
    private JLabel dateTimeViewResultLabel;
    
    public ComboBoxPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //pattern  za formatiranje vremena
        String[] patterns = {
        "dd MMMM yyyy",
            "dd.MM.yy",
            "MM/dd/yy",
            "yyyy.MM.dd G 'at' hh:mm:ss z",
            "EEE, MMM d, \"yy",
            "h::mm a",
            "H:mm:ps:SSS",
            "K:mm a,z",
            "yyyy.MMMMM.dd GGG hh:mm aaa"
        };
        
        currentPattern = patterns[0];
        
        //label
        
        JLabel patternLAbel1 = new JLabel("Enter pattern as string or ");
        JLabel patternLAbel2 = new JLabel("select one from the list");
        
        JComboBox<String> patternListComboBox = new JComboBox<>(patterns);
        patternListComboBox.setEditable(false);
        patternListComboBox.addActionListener(this);
        
        // CREATE UI
        
        JLabel dateViewLabel = new JLabel("Current Date/Time", JLabel.LEADING);
        dateTimeViewResultLabel = new JLabel("");
        
        //posloziti u panele
        
        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));
        patternPanel.add(patternLAbel1);
        patternPanel.add(patternLAbel2);
        patternListComboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        patternPanel.add(patternListComboBox);
        
        JPanel dateTimeViewPanel = new JPanel();
        dateTimeViewPanel.setLayout(new GridLayout(0, 1));
        dateTimeViewPanel.add(dateViewLabel);
        dateTimeViewPanel.add(dateTimeViewResultLabel);
        dateTimeViewResultLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dateTimeViewPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(dateTimeViewPanel);
        
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        reformat();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboBox = (JComboBox<String>)e.getSource();
        String newPattern = (String)comboBox.getSelectedItem();
        currentPattern = newPattern;
        reformat();
        
    }
    //farmatiranje vremena
    private void reformat() {
        Date today = new Date();
        SimpleDateFormat dateFormater = new SimpleDateFormat(currentPattern);
      
        String formattedToday = dateFormater.format(today);
        dateTimeViewResultLabel.setText(formattedToday);
    }
     static void createAndShowGUI() {
        //prozor
        JFrame frame = new JFrame("Combo Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //kreirati kontrole i poredati ih
        JComponent comboBoxPanel = new ComboBoxPanel();
        comboBoxPanel.setOpaque(true);
        frame.setContentPane(comboBoxPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(ComboBoxPanel::createAndShowGUI);
    }

    
  
    
}
