
package eight;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableNumberValue;
import javafx.beans.value.ObservableValue;

public class JavaFxStarter {
    public static void main(String[] args) {       
    //OBservable objekat
    IntegerProperty counterProperty = new SimpleIntegerProperty(100);
    //OBserver objekat - eager
    ChangeListener<Number> counterListener = new CounterChangeListener();
    //observer objekat - eager/lazy
    InvalidationListener counterInvalidationListener = new CounterInvalidationListener();
    counterProperty.add((ObservableNumberValue) counterListener);
    counterProperty.addListener(counterInvalidationListener);
    counterProperty.setValue(100);
    counterProperty.setValue(101);
}
static class CounterChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            System.out.println("OLD value = " + oldValue + " +, NEW value = " + newValue);
        }
    }

    static class CounterInvalidationListener implements InvalidationListener {

        @Override
        public void invalidated(Observable observable) {
            System.out.println("Invalidation change listener je obaviješten");
        }

    }
}
