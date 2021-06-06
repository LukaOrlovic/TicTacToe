/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domain.GeneralDObject;
import domain.Igra;
import domain.Korisnik;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author orlov
 */
public class ResponseDto implements Serializable{
    
    private Korisnik objekat;
    private Igra igra;
    private List<? extends GeneralDObject> rangLista;
    private boolean done;

    public Korisnik getObjekat() {
        return objekat;
    }

    public void setObjekat(Korisnik objekat) {
        this.objekat = objekat;
    }

    public Igra getIgra() {
        return igra;
    }

    public void setIgra(Igra igra) {
        this.igra = igra;
    }
    
    public List<? extends GeneralDObject> getRangLista() {
        return rangLista;
    }

    public void setRangLista(List<? extends GeneralDObject> rangLista) {
        this.rangLista = rangLista;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
