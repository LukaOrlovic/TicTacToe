/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import static SO.OpsteIzvrsenjeSO.bbp;
import domain.GeneralDObject;
import domain.Korisnik;
import dto.RequestDto;
import dto.ResponseDto;

/**
 *
 * @author orlov
 */
public class RegistrujSO extends OpsteIzvrsenjeSO{

    private RequestDto request;
    private ResponseDto response;
    
    public ResponseDto registruj(RequestDto request){
        this.request = request;
        response = new ResponseDto();
        //set response code boolean
        this.opsteIzvrsenjeSO();
        return this.response;
    }
    
    @Override
    public boolean izvrsiSO() {
        
        boolean uspeh = bbp.insertRecord((GeneralDObject) this.request.getObjekat());
        
        response.setDone(uspeh);
        
        if(uspeh){
            response.setObjekat((Korisnik) bbp.findRecord((GeneralDObject) request.getObjekat()));
            return true;
        }
        else return false;
    }
    
}
