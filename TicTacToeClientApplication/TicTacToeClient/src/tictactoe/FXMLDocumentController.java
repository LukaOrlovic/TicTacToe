/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tictactoeOsluskivaci.OsluskivacDugmeUIgri;

/**
 *
 * @author orlov
 */
public class FXMLDocumentController implements Initializable {

    Stage stage;
    GameController controller;

    @FXML
    public Button p00;

    @FXML
    public Button p01;

    @FXML
    public Button p02;

    @FXML
    public Button p10;

    @FXML
    public Button p11;

    @FXML
    public Button p12;

    @FXML
    public Button p20;

    @FXML
    public Button p21;

    @FXML
    public Button p22;

    @FXML
    public GridPane mainField;

    @FXML
    public MenuItem izlaz;

    @FXML
    public MenuItem autorPrograma;

    @FXML
    public MenuItem informacije;
    
    @FXML
    public MenuItem rangLista;
    
    @FXML
    public MenuItem start;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controller = new GameController(this);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
