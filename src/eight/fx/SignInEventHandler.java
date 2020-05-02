
package eight.fx;



import javafx.event.EventHandler;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author PC
 */
public class SignInEventHandler implements EventHandler<javafx.event.ActionEvent>{

    private final Text textValidation;

    public SignInEventHandler(Text textValidation) {
        this.textValidation = textValidation;
    }
    
    @Override
    public void handle(javafx.event.ActionEvent t) {
        textValidation.setFill(Color.FIREBRICK);
        textValidation.setText("Input is incorrect!"); }
    
    
    
}
