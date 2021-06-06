/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlov
 */
public class ServerStart extends Thread {

    private ServerSocket ss;
    private boolean active = true;

    @Override
    public void run() {
        try {
            ss = new ServerSocket(3724);
            System.out.println("Server je poceo sa radom.");
            while (active) {
                Socket clientSocket = ss.accept();
                System.out.println("Server je docekao novog klijenta.");
                KlijentNit klijentNit = new KlijentNit(clientSocket);
                klijentNit.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
