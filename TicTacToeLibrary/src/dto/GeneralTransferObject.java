/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domain.GeneralDObject;
import java.io.Serializable;

/**
 *
 * @author orlov
 */
public class GeneralTransferObject implements Serializable{
    
    private GeneralDObject objekat;
    private int operacija;
    private boolean uspelo;

    public GeneralDObject getObjekat() {
        return objekat;
    }

    public void setObjekat(GeneralDObject objekat) {
        this.objekat = objekat;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public boolean isUspelo() {
        return uspelo;
    }

    public void setUspelo(boolean uspelo) {
        this.uspelo = uspelo;
    }
    
}
