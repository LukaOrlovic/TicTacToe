
package communication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="igra" type="{http://webservice/}igra" minOccurs="0"/>
 *         &lt;element name="objekat" type="{http://webservice/}korisnik" minOccurs="0"/>
 *         &lt;element name="operacija" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestDto", propOrder = {
    "igra",
    "objekat",
    "operacija"
})
public class RequestDto {

    protected Igra igra;
    protected Korisnik objekat;
    protected int operacija;

    /**
     * Gets the value of the igra property.
     * 
     * @return
     *     possible object is
     *     {@link Igra }
     *     
     */
    public Igra getIgra() {
        return igra;
    }

    /**
     * Sets the value of the igra property.
     * 
     * @param value
     *     allowed object is
     *     {@link Igra }
     *     
     */
    public void setIgra(Igra value) {
        this.igra = value;
    }

    /**
     * Gets the value of the objekat property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getObjekat() {
        return objekat;
    }

    /**
     * Sets the value of the objekat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setObjekat(Korisnik value) {
        this.objekat = value;
    }

    /**
     * Gets the value of the operacija property.
     * 
     */
    public int getOperacija() {
        return operacija;
    }

    /**
     * Sets the value of the operacija property.
     * 
     */
    public void setOperacija(int value) {
        this.operacija = value;
    }

}
