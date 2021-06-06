/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import communication.Communication;
import domain.Igra;
import domain.Rang;
import dto.RequestDto;
import dto.ResponseDto;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tictactoeOsluskivaci.OsluskivacAutorPrograma;
import tictactoeOsluskivaci.OsluskivacDugmeUIgri;
import tictactoeOsluskivaci.OsluskivacIzlaz;
import tictactoeOsluskivaci.OsluskivacOProgramu;
import tictactoeOsluskivaci.OsluskivacRangLista;
import tictactoeOsluskivaci.OsluskivacStartuj;
import util.Operacija;

/**
 *
 * @author orlov
 */
public class GameController {

    FXMLDocumentController docCtrl;
    Communication communication;
    Igra trenutnaIgra = new Igra();

    private int[][] igra;

    int brojRedova = 3;
    int brojKolona = 3;

    int brojPoteza;

    public GameController(FXMLDocumentController docCtrl) {
        this.docCtrl = docCtrl;
        this.communication = Communication.getInstance();

        this.docCtrl.izlaz.setOnAction(new OsluskivacIzlaz(this));
        this.docCtrl.autorPrograma.setOnAction(new OsluskivacAutorPrograma(this));
        this.docCtrl.informacije.setOnAction(new OsluskivacOProgramu(this));
        this.docCtrl.start.setOnAction(new OsluskivacStartuj(this));
        this.docCtrl.rangLista.setOnAction(new OsluskivacRangLista(this));

        this.brojPoteza = 0;
        this.igra = new int[brojRedova][brojKolona];
    }

    public void izlaz() {
        Platform.exit();
        System.exit(0);
    }

    public void autorPrograma() {
        String naslov = "Autor programa:";
        String poruka = "\n \t Luka Orlovic";
        popupPoruka(naslov, poruka);
    }

    public void oProgramu() {
        String naslov = "O programu:";
        String poruka = "Iks oks igra se na praznom polju 3x3 na papiru.\n Igrač 'O' postavlja kružiće, a igrač 'X' iksiće."
                + "\n Počevši od igrača sa iksiće, igrači naizmenično biraju prazna polja i unutar njih crtaju svoj znak."
                + "\n Igrač pobjeđuje kada ostvari 3 svoja znaka uzastopno u nekom redu, koloni, glavnoj ili sporednoj dijagonali."
                + "\n Ako to ne uspe nijednom igraču, igra završava nerešeno.";
        popupPoruka(naslov, poruka);
    }

    public void startuj() {
        for (Field f : docCtrl.getClass().getDeclaredFields()) {
            if (f.getType() == Button.class) {
                try {
                    Button button = (Button) f.get(docCtrl);
                    button.setOnMouseClicked(new OsluskivacDugmeUIgri(this, button));
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    popupPoruka("Start", "Igra ne moze biti startovana!");
                }
            }
        }

        RequestDto request = new RequestDto();
        trenutnaIgra.setIdKorisnika(MainMenuFX.korisnik.getIdKorisnika());
        request.setIgra(trenutnaIgra);
        request.setOperacija(Operacija.STARTUJ);

        Communication.getInstance().sendRequest(request);
        ResponseDto response = Communication.getInstance().readResponse();

        if (response.isDone()) {
            trenutnaIgra = (Igra) response.getIgra();
            popupPoruka("Start", "Igra startovana!");
        } else {
            popupPoruka("Start", "Igra ne moze biti startovana!");
        }

    }

    public void selektujPolje(Button button) {
        int znak = 0;
        brojPoteza++;
        int izabraniRed = Integer.parseInt(button.getId().substring(1, 2));
        int izabranaKolona = Integer.parseInt(button.getId().substring(2));

        if (igra[izabraniRed][izabranaKolona] == 0) {
            if ((brojPoteza % 2) == 1) {
                znak = 1;
            } else {
                znak = 2;
            }

            igra[izabraniRed][izabranaKolona] = znak;
        } else {
            popupPoruka("Pogresno polje", "Izabrali ste pogresno polje.");
        }

        dodajSlikuNaPolje(button, znak);

        if (brojPoteza > 4 && proveriPobedu(izabraniRed, izabranaKolona, znak)) {
            zavrsiIgru();
            return;
        }

        if (brojPoteza == Math.pow(brojRedova, 2)) {
            popupPoruka("Zavrsena igra", "Igra se zavrsila nereseno.");
            zavrsiIgru();
            return;
        }

        selektujRandom();
    }

    private void zavrsiIgru() {

        this.igra = new int[brojRedova][brojKolona];
        this.brojPoteza = 0;

        for (Field f : docCtrl.getClass().getDeclaredFields()) {
            if (f.getType() == Button.class) {
                try {
                    Button button = (Button) f.get(docCtrl);
                    button.setGraphic(null);
                    button.setOnMouseClicked(null);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    popupPoruka("Zavrsnica", "Igra ne moze biti zavrsena!");
                }
            }
        }
    }

    private void selektujRandom() {

        if (brojPoteza % 2 == 0) {
            return;
        }

        new Thread(() -> {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    boolean petlja = true;
                    Button button = new Button();
                    while (petlja) {
                        int nasumicanRed = ThreadLocalRandom.current().nextInt(0, 3);
                        int nasumicnaKolona = ThreadLocalRandom.current().nextInt(0, 3);
                        if (igra[nasumicanRed][nasumicnaKolona] == 0) {
                            petlja = false;
                            try {
                                Field polje = docCtrl.getClass().getField("p" + nasumicanRed + nasumicnaKolona);
                                button = (Button) polje.get(docCtrl);
                            } catch (NoSuchFieldException ex) {
                                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SecurityException ex) {
                                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalArgumentException ex) {
                                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    selektujPolje(button);
                }
            });
        }).start();
    }

    private void dodajSlikuNaPolje(Button button, int znak) {
        if (znak == 0) {
            popupPoruka("Greska!", "Selektovali ste vec popunjeno polje.");
            return;
        }

        String location = null;

        if (znak == 1) {
            location = "/slike/X.png";
        }
        if (znak == 2) {
            location = "/slike/O.png";
        }

        InputStream input = GameController.class.getResourceAsStream(location);
        Image image = new Image(input, 133, 90, true, true);
        ImageView imgView = new ImageView(image);
        button.setGraphic(imgView);
    }

    public void popupPoruka(String naslov, String poruka) {
        Alert.AlertType alertType = Alert.AlertType.INFORMATION;
        Alert infoAlert = new Alert(alertType);
        infoAlert.setTitle(naslov);
        infoAlert.setContentText(poruka);
        infoAlert.setHeaderText(null);
        infoAlert.showAndWait();
    }

    private boolean proveriPobedu(int izabraniRed, int izabranaKolona, int znak) {

        boolean rezultat = false;

        //provera kolone
        for (int i = 0; i < brojKolona; i++) {
            if (igra[izabraniRed][i] != znak) {
                break;
            }
            if (i == brojKolona - 1) {
                rezultat = true;
            }
        }

        //proveri redove
        for (int i = 0; i < brojRedova; i++) {
            if (igra[i][izabranaKolona] != znak) {
                break;
            }
            if (i == brojRedova - 1) {
                rezultat = true;
            }
        }

        //proveri dijagonalu
        if (izabraniRed == izabranaKolona) {
            for (int i = 0; i < brojRedova; i++) {
                if (igra[i][i] != znak) {
                    break;
                }
                if (i == brojRedova - 1) {
                    rezultat = true;
                }
            }
        }

        //proveri sporednu dijagonalu
        if (izabraniRed + izabranaKolona == brojRedova - 1) {
            for (int i = 0; i < brojRedova; i++) {
                if (igra[i][(brojRedova - 1) - i] != znak) {
                    break;
                }
                if (i == brojRedova - 1) {
                    rezultat = true;
                }
            }
        }

        if (rezultat) {
            System.out.println("tictactoe.GameController.proveriPobedu()");
            RequestDto request = new RequestDto();
            request.setOperacija(Operacija.SACUVAJ);
            trenutnaIgra.setBrojPoteza(brojPoteza);
            trenutnaIgra.setDatumOdigravanja(new Date());
            if (brojPoteza % 2 == 0) {
                trenutnaIgra.setPobeda(false);
            } else {
                trenutnaIgra.setPobeda(true);
            }
            trenutnaIgra.setIdKorisnika(MainMenuFX.korisnik.getIdKorisnika());
            request.setIgra(trenutnaIgra);
            System.out.println("tictactoe.GameController.proveriPobedu()");
            Communication.getInstance().sendRequest(request);
            System.out.println("tictactoe.GameController.proveriPobedu()");
            ResponseDto response = Communication.getInstance().readResponse();
            System.out.println("tictactoe.GameController.proveriPobedu()");

            if (response.isDone()) {
                popupPoruka("Pobeda", "Igra je sačuvana!");
            } else {
                popupPoruka("Greska", "Igra ne moze biti sačuvana!");
            }

        }

        return rezultat;

    }

    public void prikaziRangListu() {
        
        RequestDto request = new RequestDto();
        Rang rangReq = new Rang();
        request.setRang(rangReq);
        request.setOperacija(Operacija.RANGLISTA);

        Communication.getInstance().sendRequest(request);

        ResponseDto response = Communication.getInstance().readResponse();

        List<Rang> rangLista = (List<Rang>) response.getRangLista();
        
        if(rangLista.isEmpty()){
            popupPoruka("Greska", "Rang lista ne moze biti prikazana.");
            return;
        }
        
        List<String> stringLista = new ArrayList<>();
        
        rangLista.forEach((rang) -> {
            stringLista.add(rang.toString());
        });
       
//        ObservableList<String> observableList = FXCollections.observableList(stringLista);
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        
        VBox vbox = dodajUListu(stringLista);
        
        dialogStage.setScene(new Scene(vbox));
        dialogStage.show();
    }
    
    private <T> VBox dodajUListu(List<T> elements) {
        ObservableList<T> observableList = FXCollections.observableArrayList();
        for (T t : elements) {
            observableList.add(t);
        }
        
        Label label = new Label("Rang lista:");
        
        ListView<T> listView = new ListView<>(observableList);
        
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));
        vbox.getChildren().addAll(label, listView);
        
        return vbox;
    }


}
