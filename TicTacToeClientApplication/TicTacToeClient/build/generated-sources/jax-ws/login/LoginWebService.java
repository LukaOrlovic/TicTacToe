
package login;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LoginWebService", targetNamespace = "http://webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LoginWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns login.ResponseDto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "login", targetNamespace = "http://webservice/", className = "login.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://webservice/", className = "login.LoginResponse")
    @Action(input = "http://webservice/LoginWebService/loginRequest", output = "http://webservice/LoginWebService/loginResponse")
    public ResponseDto login(
        @WebParam(name = "arg0", targetNamespace = "")
        RequestDto arg0);

}
