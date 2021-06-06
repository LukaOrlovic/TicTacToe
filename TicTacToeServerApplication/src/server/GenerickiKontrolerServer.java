/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import SO.LoginSO;
import SO.RegistrujSO;
import dto.RequestDto;
import dto.ResponseDto;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author orlov
 */
@WebService(serviceName = "GenerickiKontrolerServer")
public class GenerickiKontrolerServer {


    @WebMethod
    public ResponseDto login(RequestDto request) {
        return (new LoginSO().login(request));
    }
    
    @WebMethod
    public ResponseDto registruj(RequestDto request) {
        return (new RegistrujSO().registruj(request));
    }
}
