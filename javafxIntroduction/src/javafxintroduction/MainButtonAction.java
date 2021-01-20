/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxintroduction;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MainButtonAction extends Application{
    
    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        
        Button clickMe=new Button("Click Me");
        
        //MyEventHandler eventHandler=new MyEventHandler();        
        //clickMe.setOnMouseClicked(eventHandler);
        
        /*EventHandler handler=new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                
            }                    
        };
        
        clickMe.setOnMouseClicked(handler);*/
        /*
        clickMe.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                System.out.println("clicked here from inner class");
            }
        
        });
        */
        /*
        clickMe.setOnMouseClicked(event->{
            System.out.println("clicked");
        });
        */
        
        
        root.getChildren().add(clickMe);
        
        Scene scene=new Scene(root,400,400);        
        stage.setScene(scene);        
        stage.setTitle("JavaFXintro");        
        stage.show();
        
    }
    
}
