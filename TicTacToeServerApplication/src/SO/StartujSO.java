/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SO;

import static SO.OpsteIzvrsenjeSO.bbp;
import domain.GeneralDObject;
import domain.Igra;
import dto.RequestDto;
import dto.ResponseDto;

/**
 *
 * @author orlov
 */
public class StartujSO extends OpsteIzvrsenjeSO{
    
    private RequestDto request;
    private ResponseDto response;
    
    public ResponseDto startuj(RequestDto request){
        this.request = request;
        response = new ResponseDto();
        //set response code boolean
        this.opsteIzvrsenjeSO();
        return this.response;
    }
    
    @Override
    public boolean izvrsiSO() {
        
        int poslednji = bbp.getRecordsNumber(this.request.getIgra());
        this.request.getIgra().setID(++poslednji);
        boolean uspeh = bbp.insertRecord((GeneralDObject) this.request.getIgra());
        
        response.setDone(uspeh);
        
        if(uspeh){
            response.setIgra((Igra) bbp.findRecord((GeneralDObject) request.getIgra()));
            return true;
        }
        else return false;
    }
}
