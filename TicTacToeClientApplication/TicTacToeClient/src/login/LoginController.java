/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import communication.RegisterWebService;
import communication.RegisterWebServiceService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import tictactoe.MainMenuFX;

/**
 *
 * @author orlov
 */
public class LoginController {

    LoginFXMLController fxcon;

    public LoginController(LoginFXMLController fxcon) {
        this.fxcon = fxcon;
        this.fxcon.loginButton.setOnAction(new LoginListener(this));
        this.fxcon.signupButton.setOnAction(new SignupListener(this));
    }

    void login() {
        LoginWebServiceService service = new LoginWebServiceService();
        LoginWebService ws = service.getLoginWebServicePort();
        
        String korisnickoIme = this.fxcon.usernameField.getText();
        String sifra = this.fxcon.passwordField.getText();
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        RequestDto request = new RequestDto();
        request.setObjekat(korisnik);
        
        ResponseDto response = ws.login(request);
        
        Korisnik responseKorisnik = response.getObjekat();
        
        domain.Korisnik domenskiKorisnik = new domain.Korisnik();
        
        if (response.getObjekat().getIdKorisnika() != 0) {
            domenskiKorisnik = new domain.Korisnik(responseKorisnik.getIdKorisnika(), responseKorisnik.getKorisnickoIme(),
                responseKorisnik.getSifra(), responseKorisnik.getDatumPrijavljivanja().toGregorianCalendar().getTime(), responseKorisnik.getEmail());
            popupPoruka("Uspesno logovanje", "Uspesno logovanje");
        } else {
            popupPoruka("Neuspesno logovanje", "Neuspesno logovanje");
        }

        prikaziMainMenu(domenskiKorisnik);
    }

    void signup() {
        RegisterWebServiceService service = new RegisterWebServiceService();
        RegisterWebService ws = service.getRegisterWebServicePort();

        String korisnickoIme = this.fxcon.usernameField.getText();
        String sifra = this.fxcon.passwordField.getText();
        String email = this.fxcon.emailField.getText();
        communication.Korisnik korisnik = new communication.Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        korisnik.setEmail(email);
        communication.RequestDto request = new communication.RequestDto();
        request.setObjekat(korisnik);
        communication.ResponseDto response = ws.registruj(request);

        communication.Korisnik responseKorisnik = response.getObjekat();
        
        domain.Korisnik domenskiKorisnik = new domain.Korisnik(responseKorisnik.getIdKorisnika(), responseKorisnik.getKorisnickoIme(),
                responseKorisnik.getSifra(), responseKorisnik.getDatumPrijavljivanja().toGregorianCalendar().getTime(), responseKorisnik.getEmail());

        if (response.getObjekat().getIdKorisnika() != 0) {
            popupPoruka("Uspesno registrovanje", "Uspesno registrovanje");
        } else {
            popupPoruka("Neuspesno registrovanje", "Neuspesno registrovanje");
        }

        prikaziMainMenu(domenskiKorisnik);
    }

    private void prikaziMainMenu(domain.Korisnik korisnik) {
        MainMenuFX main = new MainMenuFX();
        Stage s = new Stage();

        try {
            main.setKorisnik(korisnik);
            main.start(s);
            fxcon.closeForm();
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void popupPoruka(String naslov, String poruka) {
        Alert.AlertType alertType = Alert.AlertType.INFORMATION;
        Alert infoAlert = new Alert(alertType);
        infoAlert.setTitle(naslov);
        infoAlert.setContentText(poruka);
        infoAlert.setHeaderText(null);
        infoAlert.showAndWait();
    }
}
