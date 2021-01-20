/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxintroduction;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        
        Button clickMe=new Button("Click Me");
        
        
        root.getChildren().add(clickMe);
        
        Scene scene=new Scene(root,400,400);        
        stage.setScene(scene);        
        stage.setTitle("JavaFXintro");        
        stage.show();
        
    }
    
}
