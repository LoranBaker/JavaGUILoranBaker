/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eight;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javax.sound.midi.Soundbank;

public class BindingTest2 {
    public static void main(String[] args) {
    SimpleIntegerProperty oneProperty = new SimpleIntegerProperty(1);
    SimpleIntegerProperty twoProperty = new SimpleIntegerProperty(2);
    NumberBinding sum = oneProperty.add(twoProperty);
    System.out.println("SUM = " + sum.getValue());
    ChangeListener<Number> changeListener =(observable, oldValue, newValue)->System.out.println("Old = " + oldValue + " New value = " + newValue);
    InvalidationListener invalidationListener = (observable)->System.out.println("Invalidation called");
    sum.addListener(changeListener);
    System.out.println("Valid sum: " + sum.isValid());
    sum.addListener(invalidationListener);
    oneProperty.set(23);
    twoProperty.set(32);System.out.println("Valid sum: " + sum.isValid());
}
}