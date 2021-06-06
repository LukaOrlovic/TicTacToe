/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import dto.RequestDto;
import dto.ResponseDto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import brokerBazePodataka.*;
import kontroler.Kontroler;
import util.Operacija;

/**
 *
 * @author orlov
 */
public class KlijentNit extends Thread {

    static public BrokerBazePodataka bbp = new BrokerBazePodataka1();
    boolean active = true;
    private Socket clientSocket;

    public KlijentNit(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                ObjectInputStream inSocket = new ObjectInputStream(clientSocket.getInputStream());
                Object object = inSocket.readObject();
                ResponseDto response = handleRequests((RequestDto) object);
                ObjectOutputStream outSocket = new ObjectOutputStream(clientSocket.getOutputStream());
                outSocket.writeObject(response);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlijentNit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ResponseDto handleRequests(RequestDto request) {

        ResponseDto response = new ResponseDto();

        System.out.println(request.getOperacija());
        switch (request.getOperacija()) {
            case Operacija.STARTUJ:
                System.out.println("Switch case START");
                response = Kontroler.getInstance().startuj(request);
                break;
            case Operacija.SACUVAJ:
                System.out.println("Switch case LOL");
                response = Kontroler.getInstance().sacuvaj(request);
                break;
            case Operacija.RANGLISTA:
                System.out.println("RANG LISTA");
                response = Kontroler.getInstance().rangLista(request);
                break;
        }

        return response;
    }

}
