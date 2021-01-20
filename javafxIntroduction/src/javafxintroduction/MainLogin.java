/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxintroduction;

import java.awt.Color;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MainLogin extends Application{
    
    public static void main(String[] args) {
        launch(args);
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        GridPane root=new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        //root.setGridLinesVisible(true);
        
        Label userLabel=new Label("Username");
        Label passLabel=new Label("Password");
        
        TextField userValue=new TextField();
        PasswordField passValue=new PasswordField();
        
        Button login=new Button("Login");
        HBox loginContainer=new HBox();
        loginContainer.getChildren().add(login);
        loginContainer.setAlignment(Pos.CENTER_RIGHT);
        
        Label warning=new Label();
        
        
        root.add(userLabel, 0,0);
        root.add(passLabel, 0,1);
        
        root.add(userValue, 1,0);
        root.add(passValue, 1,1);               
        
        root.add(loginContainer, 1,2);
        
        root.add(warning,1,3);
        
        login.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent t) {
                  String username=userValue.getText();
                  String password=passValue.getText();
                  
                  System.out.println(username+"\t"+password);
                  
                  if(username.equals("siddhartha") && password.equals("1234")){
                      Home(stage);
                      //stage.close();
                  }
                  else{
                      warning.setText("Did't match");
                  }
            }
        
        
        });
        
        
        
        Scene scene=new Scene(root,400,400);        
        stage.setScene(scene);        
        stage.setTitle("Login");        
        stage.show();
        
    }
    
    public void Home(Stage stage){
        //Stage stage=new Stage();
        
        GridPane root=new GridPane();
        
        Scene scene=new Scene(root,400,400);        
        stage.setScene(scene);        
        stage.setTitle("Home");        
        stage.show();
        
    }
    
}
