
package eight;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingTest {
    public static void main(String[] args) {
        IntegerProperty aProperty = new SimpleIntegerProperty(10);
        IntegerProperty bProperty = new SimpleIntegerProperty(25);
        aProperty.bind(bProperty);
        bProperty.set(28);
        System.out.println("A = " + aProperty.get());
        System.out.println("B = " + bProperty.get());
        aProperty.unbind();
        aProperty.set(23);
        System.out.println("A = " + aProperty.get());
        System.out.println("B = " + bProperty.get());
        
    }
}
