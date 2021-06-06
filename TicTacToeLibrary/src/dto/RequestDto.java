/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domain.Igra;
import domain.Korisnik;
import domain.Rang;
import java.io.Serializable;

/**
 *
 * @author orlov
 */
public class RequestDto implements Serializable{
    
    private Korisnik objekat;
    private Igra igra;
    private Rang rang;
    private int operacija;

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

    public Rang getRang() {
        return rang;
    }

    public void setRang(Rang rang) {
        this.rang = rang;
    }
    
    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

}
