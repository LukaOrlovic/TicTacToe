/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import domain.GeneralDObject;
import domain.Igra;
import dto.RequestDto;
import dto.ResponseDto;

/**
 *
 * @author orlov
 */
public class SacuvajSO extends OpsteIzvrsenjeSO{

    private RequestDto request;
    private ResponseDto response;
    
    public ResponseDto sacuvaj(RequestDto request){
        this.request = request;
        response = new ResponseDto();
        this.opsteIzvrsenjeSO();
        return this.response;
    }
    
    @Override
    public boolean izvrsiSO() {
        
        boolean uspeh = bbp.updateRecord((GeneralDObject) this.request.getIgra());

        response.setDone(uspeh);
        
        if(uspeh){
            response.setIgra((Igra) bbp.findRecord((GeneralDObject) request.getIgra()));
            return true;
        }
        else return false;
    }
    
}
