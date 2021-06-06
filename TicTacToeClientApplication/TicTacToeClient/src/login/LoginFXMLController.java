/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import communication.Communication;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author orlov
 */
public class LoginFXMLController implements Initializable {

    Stage stage;  
    LoginController controller;
    
    @FXML
    public TextField usernameField;
    
    @FXML
    public TextField emailField;
    
    @FXML
    public PasswordField passwordField;
    
    @FXML 
    public Button loginButton;
    
    @FXML 
    public Button signupButton;
    
    @FXML
    public Label propratniLabel;
    
    @FXML
    public Label loginLabel;
    
    Communication communication;
    private boolean showLogin = true;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = new LoginController(this);
        this.communication = Communication.getInstance();
    }
    
    @FXML
    public void zameni(){
        showLogin = !showLogin;
        signupButton.setDisable(showLogin);
        signupButton.setVisible(!showLogin);
        
        loginButton.setDisable(!showLogin);
        loginButton.setVisible(showLogin);
        
        emailField.setVisible(!showLogin);
        
        if(showLogin){
            propratniLabel.setText("If you haven't signed up, click ");
            loginLabel.setText("Login Form");
        }
        else {
            propratniLabel.setText("If you have signed up, click");
            loginLabel.setText("Signup Form");
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    } 
    
    void closeForm() {
        this.stage.close();
    }
    
}
