/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package four.tabel;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class SelectionTablePanel extends JPanel{
    
    private JTable table;
    private JCheckBox rowCheckBox;
    private JCheckBox columnCheckBox;
    private ButtonGroup buttonGroup;
    private JTextArea outputTextArea;

    public SelectionTablePanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        table = new JTable();
        add(new JScrollPane(table));
        
        add(new JLabel("Selection Mode"));
        rowCheckBox = new JCheckBox("Row selection");
        add(rowCheckBox);
        columnCheckBox = new JCheckBox("Column Selection");
        add(columnCheckBox);
        add(new JLabel("Selection Options"));
        JRadioButton singleRadioButton = new JRadioButton("Single selection");
        JRadioButton multipleRadioButton = new JRadioButton("Multiple selection");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(singleRadioButton);
        buttonGroup.add(multipleRadioButton);
        add(singleRadioButton);
        add(multipleRadioButton);
        outputTextArea = new JTextArea(5, 40);
        add(new JScrollPane(outputTextArea));
        
    }
    
    
}