/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import SO.LoginSO;
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
public class WebservicesImplementation {

    @WebMethod
    public ResponseDto login(RequestDto request) {
        return (new LoginSO().login(request));
    }

//    @Override
//    public ResponseDto registruj(RequestDto request) {
//        return (new RegistrujSO().registruj(request));
//    }
    
}
