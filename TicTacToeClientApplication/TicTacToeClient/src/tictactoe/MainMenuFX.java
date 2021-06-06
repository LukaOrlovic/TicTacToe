/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import domain.Korisnik;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author orlov
 */
public class MainMenuFX extends Application{
    
    FXMLDocumentController con;
    public static Stage stage;
    static Korisnik korisnik;

    @Override
    public void start(Stage stage) throws Exception {
        
        this.stage = stage;
        
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLDocumentController) fxmlLoader.getController();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.setTitle("Tic tac toe");
        stage.show();
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
}
