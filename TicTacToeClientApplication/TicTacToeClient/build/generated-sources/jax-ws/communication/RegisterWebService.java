
package communication;

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
@WebService(name = "RegisterWebService", targetNamespace = "http://webservice/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RegisterWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns communication.ResponseDto
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registruj", targetNamespace = "http://webservice/", className = "communication.Registruj")
    @ResponseWrapper(localName = "registrujResponse", targetNamespace = "http://webservice/", className = "communication.RegistrujResponse")
    @Action(input = "http://webservice/RegisterWebService/registrujRequest", output = "http://webservice/RegisterWebService/registrujResponse")
    public ResponseDto registruj(
        @WebParam(name = "arg0", targetNamespace = "")
        RequestDto arg0);

}
