
package communication;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseDto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseDto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="done" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="igra" type="{http://webservice/}igra" minOccurs="0"/>
 *         &lt;element name="objekat" type="{http://webservice/}korisnik" minOccurs="0"/>
 *         &lt;element name="rangLista" type="{http://webservice/}generalDObject" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseDto", propOrder = {
    "done",
    "igra",
    "objekat",
    "rangLista"
})
public class ResponseDto {

    protected boolean done;
    protected Igra igra;
    protected Korisnik objekat;
    @XmlElement(nillable = true)
    protected List<GeneralDObject> rangLista;

    /**
     * Gets the value of the done property.
     * 
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Sets the value of the done property.
     * 
     */
    public void setDone(boolean value) {
        this.done = value;
    }

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
     * Gets the value of the rangLista property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rangLista property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRangLista().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneralDObject }
     * 
     * 
     */
    public List<GeneralDObject> getRangLista() {
        if (rangLista == null) {
            rangLista = new ArrayList<GeneralDObject>();
        }
        return this.rangLista;
    }

}
