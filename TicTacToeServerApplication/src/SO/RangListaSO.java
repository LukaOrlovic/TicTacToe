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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author orlov
 */
public class RangListaSO extends OpsteIzvrsenjeSO {

    List<? extends GeneralDObject> rangLista = new LinkedList<>();
    private RequestDto request;
    private ResponseDto response;

    public ResponseDto prikaziRangListu(RequestDto request) {
        this.request = request;
        response = new ResponseDto();
        //set response code boolean
        this.opsteIzvrsenjeSO();
        return this.response;
    }

    @Override
    public boolean izvrsiSO() {
        
        rangLista = bbp.findRecord((GeneralDObject) request.getRang(), request.getRang().getWhereCondition());
        response.setDone(true);

        response.setRangLista(rangLista);
        return true;
    }
}
