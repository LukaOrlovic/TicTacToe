
package communication;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the communication package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Registruj_QNAME = new QName("http://webservice/", "registruj");
    private final static QName _RegistrujResponse_QNAME = new QName("http://webservice/", "registrujResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: communication
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Registruj }
     * 
     */
    public Registruj createRegistruj() {
        return new Registruj();
    }

    /**
     * Create an instance of {@link RegistrujResponse }
     * 
     */
    public RegistrujResponse createRegistrujResponse() {
        return new RegistrujResponse();
    }

    /**
     * Create an instance of {@link ResponseDto }
     * 
     */
    public ResponseDto createResponseDto() {
        return new ResponseDto();
    }

    /**
     * Create an instance of {@link RequestDto }
     * 
     */
    public RequestDto createRequestDto() {
        return new RequestDto();
    }

    /**
     * Create an instance of {@link Igra }
     * 
     */
    public Igra createIgra() {
        return new Igra();
    }

    /**
     * Create an instance of {@link Korisnik }
     * 
     */
    public Korisnik createKorisnik() {
        return new Korisnik();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registruj }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "registruj")
    public JAXBElement<Registruj> createRegistruj(Registruj value) {
        return new JAXBElement<Registruj>(_Registruj_QNAME, Registruj.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrujResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "registrujResponse")
    public JAXBElement<RegistrujResponse> createRegistrujResponse(RegistrujResponse value) {
        return new JAXBElement<RegistrujResponse>(_RegistrujResponse_QNAME, RegistrujResponse.class, null, value);
    }

}
