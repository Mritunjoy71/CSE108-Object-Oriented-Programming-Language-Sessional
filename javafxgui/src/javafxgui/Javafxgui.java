/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Javafxgui extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
       
       FXMLLoader loader=new FXMLLoader();
       loader.setLocation(getClass().getResource("FXML.fxml"));
       
       Parent root=loader.load();
       
       
       Scene scene=new Scene(root,400,400);
       
       primaryStage.setScene(scene);
       primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
