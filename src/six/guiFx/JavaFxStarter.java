/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package six.guiFx;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxStarter extends Application{
    
  
    @Override
    public void start(Stage stage) throws Exception {
        
        //kontorle
        Button button = new Button("Hello Corona");
        //kontenjer - region- regija
        VBox vBox = new VBox();
        vBox.getChildren().add(button);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Moja prva fx aplikacija");
        stage.show();
    
    }
    
     public static void main(String[] args) {
        int number = 23;
        //ISKORAK
        IntegerProperty numberProperty = new SimpleIntegerProperty(23);
        //ChangeListener 
        numberProperty.addListener(new NumberPropertyChangeListener());
        numberProperty.addListener((observable, oldValue, newValue) -> System.out.println("LAMBDA:Old = " + oldValue + ", new value = " + newValue));
        //INVALIDATION event 
        numberProperty.addListener(new NumberPropertyInvalidationListener());
        numberProperty.set(24);
        numberProperty.set(25);
        System.out.println("DOhvacena: " + numberProperty.get());

    }

    static class NumberPropertyInvalidationListener implements InvalidationListener{

        @Override
        public void invalidated(Observable observable) {
            System.out.println("INVALIDATION event: " + observable);
        }

    }

    static class NumberPropertyChangeListener implements ChangeListener<Number> {

        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            System.out.println("Vrijednost koju nosi property se promijenila:");
            System.out.println("Old = " + oldValue + ", new value = " + newValue);
        }
    }
}