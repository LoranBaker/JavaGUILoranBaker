/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eight.fx;


import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello world");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        //spacing izmedju redova i kolona
        //horizonatalgap
        //verticalgap
        grid.setHgap(10);
        grid.setVgap(10);
        
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneText = new Text("Welcome");
        sceneText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneText, 0, 0, 2, 1);
        
        Label username = new Label("Username: ");
        grid.add(username, 0, 1);
        
        TextField usernameTextField = new TextField();
        grid.add(usernameTextField, 1,1);
        
        Label password = new Label("Password: ");
        grid.add(password, 0, 2);
        
        PasswordField passwordTextField = new PasswordField();
        grid.add(passwordTextField, 1, 2);
        
        Button saveButton = new Button("Sign in");
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.getChildren().add(saveButton);
        grid.add(hbox, 1, 4);
        
        Text validationText = new Text();
        SignInEventHandler signInEventHandler = new SignInEventHandler(validationText);
        saveButton.setOnAction(signInEventHandler);
        grid.add(validationText, 1, 6);
        
        //grid.setGridLinesVisible(true);
        
        Scene scene = new Scene(grid, 300, 275);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
   
}
