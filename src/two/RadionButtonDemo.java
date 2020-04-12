package two;

import com.sun.org.apache.bcel.internal.generic.CASTORE;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import one.CheckBoxPanel;

public class RadionButtonDemo extends JPanel implements ActionListener {

    static final String BIRD_NAME = "Bird";
    static final String CAT_NAME = "Cat";
    static final String DOG_NAME = "Dog";
    static final String PIG_NAME = "Pig";
    static final String RABBIT_NAME = "Rabbit";

    private JLabel pictureJLabel;

    public RadionButtonDemo() {
        super(new BorderLayout());
        JRadioButton birdButton = new JRadioButton(BIRD_NAME);
        birdButton.setMnemonic(KeyEvent.VK_B);
        birdButton.setActionCommand(BIRD_NAME);
        birdButton.setSelected(true);

        JRadioButton catButton = new JRadioButton(CAT_NAME);
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand(CAT_NAME);
        catButton.setSelected(true);

        JRadioButton dogButton = new JRadioButton(DOG_NAME);
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand(DOG_NAME);
        dogButton.setSelected(true);

        JRadioButton pigButton = new JRadioButton(PIG_NAME);
        pigButton.setMnemonic(KeyEvent.VK_P);
        pigButton.setActionCommand(PIG_NAME);
        pigButton.setSelected(true);

        JRadioButton rabbitButton = new JRadioButton(RABBIT_NAME);
        rabbitButton.setMnemonic(KeyEvent.VK_R);
        rabbitButton.setActionCommand(RABBIT_NAME);
        rabbitButton.setSelected(true);

        //RADIOBUTTON GROUP
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(birdButton);
        buttonGroup.add(catButton);
        buttonGroup.add(dogButton);
        buttonGroup.add(pigButton);
        buttonGroup.add(rabbitButton);

        //ACTION LISTENERS
        birdButton.addActionListener(this);
        catButton.addActionListener(this);
        dogButton.addActionListener(this);
        pigButton.addActionListener(this);
        rabbitButton.addActionListener(this);

        //PICTURE LABEL
        pictureJLabel = new JLabel(createImageIcon(BIRD_NAME));
        Dimension dimension = new Dimension(185, 125);
        pictureJLabel.setPreferredSize(dimension);

        JPanel radioButtonPanel = new JPanel(new GridLayout(5, 5));
        radioButtonPanel.add(birdButton);
        radioButtonPanel.add(catButton);
        radioButtonPanel.add(dogButton);
        radioButtonPanel.add(pigButton);
        radioButtonPanel.add(rabbitButton);

        add(radioButtonPanel, BorderLayout.LINE_START);
        add(pictureJLabel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
        String pictureName;
        ImageIcon imageIcon = createImageIcon(CAT_NAME);
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
