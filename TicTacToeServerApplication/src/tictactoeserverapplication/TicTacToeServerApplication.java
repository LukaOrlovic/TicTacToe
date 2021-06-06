/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserverapplication;

import javax.xml.ws.Endpoint;
import server.ServerStart;
import webservice.LoginWebService;
import webservice.RegisterWebService;
import webservice.WebservicesImplementation;

/**
 *
 * @author orlov
 */
public class TicTacToeServerApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9000/login", new LoginWebService());
        Endpoint.publish("http://localhost:9000/registruj", new RegisterWebService());
        ServerStart ss = new ServerStart();
        ss.start();
    }
    
}
