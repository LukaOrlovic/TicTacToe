/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeOsluskivaci;

import javafx.event.Event;
import javafx.event.EventHandler;
import tictactoe.GameController;

/**
 *
 * @author orlov
 */
public class OsluskivacOProgramu extends GlavniMeniOsluskivac implements EventHandler{

    public OsluskivacOProgramu(GameController con) {
        this.gameController = con;
    }
    
    @Override
    public void handle(Event event) {
        this.gameController.oProgramu();
    }
    
}
