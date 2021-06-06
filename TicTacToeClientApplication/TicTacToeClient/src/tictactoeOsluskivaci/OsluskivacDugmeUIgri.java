/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeOsluskivaci;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import tictactoe.FXMLDocumentController;
import tictactoe.GameController;

/**
 *
 * @author orlov
 */
public class OsluskivacDugmeUIgri extends GlavniMeniOsluskivac implements EventHandler{

    Button b;

    public OsluskivacDugmeUIgri(GameController con, Button b) {
        this.gameController = con;
        this.b = b;
    }

    @Override
    public void handle(Event event) {
        this.gameController.selektujPolje(b);
    }
    
//    public void skloniOsluskivace(FXMLDocumentController ctrl){
//        ctrl.getStage().remo
//    }
    
}
