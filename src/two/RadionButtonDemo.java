package two;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.stream.Stream;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadionButtonDemo extends JPanel implements ActionListener {

    private JLabel pictureJLabel;
    private final ButtonGroup buttonGroup;
    private final JPanel buttonPanel;

    public RadionButtonDemo() {
        super(new BorderLayout());
        buttonGroup = new ButtonGroup();
        buttonPanel = new JPanel(new GridLayout(0, 1));
        Stream.of(AnimalButtonEnum.values()).forEach(this::createRadioButton);
        pictureJLabel = new JLabel(createImageIcon(AnimalButtonEnum.BIRD.getName()));
        pictureJLabel.setPreferredSize(new Dimension(187, 122));
        add(buttonPanel, BorderLayout.LINE_START);
        add(pictureJLabel, BorderLayout.CENTER);

    }
    private JRadioButton createRadioButton(AnimalButtonEnum animalButton) {
        JRadioButton radioButton = new JRadioButton(animalButton.getName());
        radioButton.setMnemonic(animalButton.getMnemonic());
        radioButton.setActionCommand(animalButton.getCommand());
        radioButton.setSelected(animalButton.isSelected());
        radioButton.addActionListener(this);
        buttonGroup.add(radioButton);
        buttonPanel.add(radioButton);
        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
        String pictureName = e.getActionCommand();
        ImageIcon imageIcon = createImageIcon(pictureName);
        pictureJLabel.setIcon(imageIcon);
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
        JFrame frame = new JFrame("Demonstracija korištenja radio button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //kreirati kontrole i poredati ih
        JComponent radioButtonPanel = new RadionButtonDemo();
        radioButtonPanel.setOpaque(true);
        frame.setContentPane(radioButtonPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(RadionButtonDemo::createAndShowGUI);
    }

}
