
package login;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for igra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="igra">
 *   &lt;complexContent>
 *     &lt;extension base="{http://webservice/}generalDObject">
 *       &lt;sequence>
 *         &lt;element name="brojPoteza" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="datumOdigravanja" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idIgre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idKorisnika" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pobeda" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "igra", propOrder = {
    "brojPoteza",
    "datumOdigravanja",
    "idIgre",
    "idKorisnika",
    "pobeda"
})
public class Igra
    extends GeneralDObject
{

    protected int brojPoteza;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumOdigravanja;
    protected int idIgre;
    protected int idKorisnika;
    protected boolean pobeda;

    /**
     * Gets the value of the brojPoteza property.
     * 
     */
    public int getBrojPoteza() {
        return brojPoteza;
    }

    /**
     * Sets the value of the brojPoteza property.
     * 
     */
    public void setBrojPoteza(int value) {
        this.brojPoteza = value;
    }

    /**
     * Gets the value of the datumOdigravanja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOdigravanja() {
        return datumOdigravanja;
    }

    /**
     * Sets the value of the datumOdigravanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOdigravanja(XMLGregorianCalendar value) {
        this.datumOdigravanja = value;
    }

    /**
     * Gets the value of the idIgre property.
     * 
     */
    public int getIdIgre() {
        return idIgre;
    }

    /**
     * Sets the value of the idIgre property.
     * 
     */
    public void setIdIgre(int value) {
        this.idIgre = value;
    }

    /**
     * Gets the value of the idKorisnika property.
     * 
     */
    public int getIdKorisnika() {
        return idKorisnika;
    }

    /**
     * Sets the value of the idKorisnika property.
     * 
     */
    public void setIdKorisnika(int value) {
        this.idKorisnika = value;
    }

    /**
     * Gets the value of the pobeda property.
     * 
     */
    public boolean isPobeda() {
        return pobeda;
    }

    /**
     * Sets the value of the pobeda property.
     * 
     */
    public void setPobeda(boolean value) {
        this.pobeda = value;
    }

}
