/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class Graphics extends Application {
    
    Rectangle rect=new Rectangle(10,50, 20, 40);
    double angle=0;
    
    public void updateRectangle(long time){
        angle=(angle+10)%360;
        rect.setRotate(angle);
        
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root=new Group();
        
        
        rect.setFill(Color.RED);
        rect.setStroke(Color.AZURE);
        
        
        
        
        AnimationTimer timer=new AnimationTimer() {

            @Override
            public void handle(long now) {
                updateRectangle(now);
            }
        };
        
        timer.start();
        
        
        
        
        root.getChildren().add(rect);
        
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
