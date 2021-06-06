/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import domain.GeneralDObject;
import domain.Korisnik;
import dto.RequestDto;
import dto.ResponseDto;

/**
 *
 * @author orlov
 */
public class LoginSO extends OpsteIzvrsenjeSO{

    private RequestDto request;
    private ResponseDto response;
    
    public ResponseDto login(RequestDto request){
        this.request = request;
        response = new ResponseDto();
        //set response code boolean
        this.opsteIzvrsenjeSO();
        System.out.println(this.response.getObjekat().getIdKorisnika());
        return this.response;
    }
    
    @Override
    public boolean izvrsiSO() {
        
        Korisnik korisnik = (Korisnik) bbp.findRecord((GeneralDObject) this.request.getObjekat());
        
        if(korisnik != null) this.response.setDone(true);
        else this.response.setDone(false);
        
        this.response.setObjekat(korisnik);
        return true;
    }
    
}
