/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxgui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLController implements Initializable {
    @FXML
    private TextField userValue;
    @FXML
    private PasswordField passValue;
    @FXML
    private Button login;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void handleLogin(MouseEvent event) {
        System.out.println(userValue.getText()+"\t"+passValue.getText());
        
    }
    
}
