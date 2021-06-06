/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import SO.LoginSO;
import SO.OpsteIzvrsenjeSO;
import SO.RangListaSO;
import SO.SacuvajSO;
import SO.StartujSO;
import dto.RequestDto;
import dto.ResponseDto;
import dto.GeneralTransferObject;

/**
 *
 * @author orlov
 */
public class Kontroler {
    
    private static Kontroler instance;
    private OpsteIzvrsenjeSO so;
    
    public static Kontroler getInstance(){
        if(instance == null){
            instance = new Kontroler();
        }
        return instance;
    } 
    
    public ResponseDto startuj(RequestDto request){
        so = new StartujSO();
        return ((StartujSO) so).startuj(request);
    }
    
    public ResponseDto sacuvaj(RequestDto request){
        so = new SacuvajSO();
        return ((SacuvajSO) so).sacuvaj(request);
    }
    
    public ResponseDto rangLista(RequestDto request){
        so = new RangListaSO();
        return ((RangListaSO) so).prikaziRangListu(request);
    }
    
}
