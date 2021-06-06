/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author orlov
 */
public class SignupListener implements EventHandler{
    
    LoginController loginController;
    
     public SignupListener(LoginController loginController) {
        this.loginController = loginController;
    }
    
    @Override
    public void handle(Event event) {
        loginController.signup();
    }
}
