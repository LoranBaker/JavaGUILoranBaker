package Converter;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UnitConverter extends JPanel {
    
    private boolean state = true;
    
    public UnitConverter() {
        
        JFrame frame = new JFrame("Unit Converter");
        
        frame.setLocationRelativeTo(null);

        //prvi red, dodavanje labela
        JButton convertOne = new JButton("Convert");
        JLabel labelOne = new JLabel("Enter km/h: ");
        labelOne.setHorizontalAlignment(SwingConstants.CENTER);
        labelOne.setVerticalAlignment(SwingConstants.CENTER);
        JLabel endLabelOne = new JLabel("m/s");
        endLabelOne.setHorizontalAlignment(SwingConstants.CENTER);
        endLabelOne.setVerticalAlignment(SwingConstants.CENTER);
        JTextField textFieldOne = new JTextField();
        textFieldOne.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField firstOutput = new JTextField();
        
        convertOne.addActionListener((ActionEvent e) -> {
            if (state) {
                double kilometersPerHour = Double.parseDouble(textFieldOne.getText());
                double metersPerSecond = 5 * kilometersPerHour / 18;
                firstOutput.setText(String.format("%.10g", metersPerSecond));
            } else {
                double metersPerSecond = Double.parseDouble(textFieldOne.getText());
                double kilometersPerHour = 3.6 * metersPerSecond;
                firstOutput.setText(String.format("%.10g", kilometersPerHour));
            }
        });

        //drugi red dodvanje labela
        JButton convertTwo = new JButton("Convert");
        convertTwo.setVerticalAlignment(SwingConstants.CENTER);
        convertTwo.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel endLabelTwo = new JLabel("Kilometers");
        endLabelTwo.setVerticalAlignment(SwingConstants.CENTER);
        endLabelTwo.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel labelTwo = new JLabel();
        labelTwo.setText("Enter Miles :");
        labelTwo.setVerticalAlignment(SwingConstants.CENTER);
        labelTwo.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField textFieldTwo = new JTextField();
        textFieldTwo.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField secondOutput = new JTextField();
        
        convertTwo.addActionListener((ActionEvent e) -> {
            if (state) {
                double miles = Double.parseDouble(textFieldTwo.getText());
                double kilometers = miles * 1.609344;
                secondOutput.setText(String.format("%.10g", kilometers));
            } else {
                double kilometers = Double.parseDouble(textFieldTwo.getText());
                double miles = kilometers / 1.609344;
                secondOutput.setText(String.format("%.10g", miles));
            }
        });

        // treci red dodavanje labela
        JButton covertThree = new JButton("Convert");
        covertThree.setVerticalAlignment(SwingConstants.CENTER);
        covertThree.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel endLabelThree = new JLabel("Dollars");
        endLabelThree.setVerticalAlignment(SwingConstants.CENTER);
        endLabelThree.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel thirdLabel = new JLabel();
        thirdLabel.setText("Enter Euros :");
        thirdLabel.setVerticalAlignment(SwingConstants.CENTER);
        thirdLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField thirdTextField = new JTextField();
        thirdTextField.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField thirdOutput = new JTextField();
        
        covertThree.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (state) {
                    
                    double euro = Double.parseDouble(thirdTextField.getText());
                    double dollars = euro * 1.09;
                    thirdOutput.setText(String.format("%.5g", dollars));
                } else {
                    double dollars = Double.parseDouble(thirdTextField.getText());
                    double euro = dollars * 0.92;
                    thirdOutput.setText(String.format("%.5g", euro));
                }
                
            }
        });
        
        frame.setSize(new Dimension(600, 300));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridLayout gridLayout = new GridLayout(0, 5, 10, 5);
        
        frame.setLayout(gridLayout);
        frame.add(labelOne);
        frame.add(textFieldOne);
        frame.add(convertOne);
        frame.add(firstOutput);
        frame.add(endLabelOne);
        
        frame.add(labelTwo);
        frame.add(textFieldTwo);
        frame.add(convertTwo);
        frame.add(secondOutput);
        frame.add(endLabelTwo);
        
        frame.add(thirdLabel);
        frame.add(thirdTextField);
        frame.add(covertThree);
        frame.add(thirdOutput);
        frame.add(endLabelThree);

        //switch units button
        JButton switchButton = new JButton("Switch Units");
        switchButton.setLayout(gridLayout);
        frame.add(switchButton);
        
        switchButton.addActionListener((ActionEvent e) -> {
            if (state) {
                state = false;
                labelOne.setText("Enter m/s:");
                endLabelOne.setText("km/h:");
                labelTwo.setText("Enter kilometers: ");
                endLabelTwo.setText("Miles:");
                thirdLabel.setText("Enter dollars: ");
                endLabelThree.setText("Euros: ");
                
            } else if (!state) {
                state = true;
                labelOne.setText("Enter km/h: ");
                endLabelOne.setText("m/s: ");
                labelTwo.setText("Enter miles: ");
                endLabelTwo.setText("Kilometers: ");
                thirdLabel.setText("Enter euros: ");
                endLabelThree.setText("Dollars: ");
                
            }
            
        });
        
    }
    public static void main(String[] args) {
        new UnitConverter();
    }
    
}
