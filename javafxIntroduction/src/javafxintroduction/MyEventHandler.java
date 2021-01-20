/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxintroduction;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author user
 */
public class MyEventHandler implements EventHandler<MouseEvent>{

    @Override
    public void handle(MouseEvent t) {
        
        
        System.out.println("Clicked Here");
        
    }
    
}
