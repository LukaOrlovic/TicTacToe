/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communication;

import dto.RequestDto;
import dto.ResponseDto;
import dto.GeneralTransferObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orlov
 */
public class Communication {

    private static Communication instance;
    private Socket socket;

    private Communication() {
        try {
            socket = new Socket("localhost", 3724);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void sendRequest(RequestDto request) {
        try {
            ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
            outSocket.writeObject(request);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResponseDto readResponse() {
        ObjectInputStream inSocket = null;
        try {
            inSocket = new ObjectInputStream(socket.getInputStream());
            return (ResponseDto) inSocket.readObject();
        } catch (Exception ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
