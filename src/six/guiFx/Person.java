/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package six.guiFx;

//HALF LAZY - koliko god mozes odgodi poziv operatora new i koliko god mozes odgodi kreiranje java fx propertya
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Person {

    private double weight;
    private DoubleProperty weightProperty;

    public void setWeight(double weight) {
        if ((weightProperty != null) || (this.weight != weight)) {
            weightProperty.set(weight);
        }
    }

    public double getWeight() {
        return weightProperty == null ? weight : weightProperty.get();
    }

    public DoubleProperty getWeightProperty() {
        if (weightProperty == null) {
            weightProperty = new SimpleDoubleProperty(this, "WEIGHT", weight);
        }
        return weightProperty;
    }

}
