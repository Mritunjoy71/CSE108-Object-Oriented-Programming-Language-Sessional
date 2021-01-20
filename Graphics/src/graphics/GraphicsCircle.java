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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class GraphicsCircle extends Application {
    double r=30;
    Circle rect=new Circle(40,89,r,new Color(Math.random(),Math.random(),Math.random(),Math.random()));
    Scene scene;
    
    double dx=4;
    double dy=5;
    
    public void updateRectangle(long time){
        
        double cx=rect.getCenterX();
        double cy=rect.getCenterY();
        
        if(cx+r>scene.getWidth()||cx-r<0)dx=-dx;
        if(cy+r>scene.getHeight()||cy-r<0)dy=-dy;
        
        rect.setCenterX(cx+dx);
        rect.setCenterY(cy+dy);
        
        
        
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        Group root=new Group();
        
        
        
        
        
        AnimationTimer timer=new AnimationTimer() {

            @Override
            public void handle(long now) {
                updateRectangle(now);
            }
        };
        
        timer.start();
        
        
        
        
        root.getChildren().add(rect);
        
        scene = new Scene(root, 300, 250);
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
