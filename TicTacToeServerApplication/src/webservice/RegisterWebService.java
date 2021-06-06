/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import SO.RegistrujSO;
import dto.RequestDto;
import dto.ResponseDto;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author orlov
 */
@WebService
public class RegisterWebService {
    
    @WebMethod
    public ResponseDto registruj(RequestDto request) {
        return (new RegistrujSO().registruj(request));
    }
}
