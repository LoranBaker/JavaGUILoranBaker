/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two;

import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;

public enum AnimalButtonEnum {
    
    BIRD("Bird", "Bird", KeyEvent.VK_B, true),
    CAT("Cat", "Cat", KeyEvent.VK_C, false),
    DOG("Dog", "Dog", KeyEvent.VK_D, false),
    PIG("Pig", "Pig", KeyEvent.VK_P, false),
    RABBIT("Rabbit", "Rabbit", KeyEvent.VK_R, false),;

    private final String name;
    private final String command;
    private final int mnemonic;
    private final boolean selected;

    private AnimalButtonEnum(String name, String command, int mnemonic, boolean selected) {
        this.name = name;
        this.command = command;
        this.mnemonic = mnemonic;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return name + ".gif";
    }

    public int getMnemonic() {
        return mnemonic;
    }

    public String getCommand() {
        return command;
    }

    public boolean isSelected() {
        return selected;
    }

    public JRadioButton createButton() {
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.setMnemonic(mnemonic);
        radioButton.setActionCommand(name);
        return radioButton;
    }
}
