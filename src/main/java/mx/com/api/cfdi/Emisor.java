/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ignis
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Emisor {

    @XmlAttribute(name = "Rfc", required = true)
    protected String rfc;
    @XmlAttribute(name = "Nombre")
    protected String nombre;
    @XmlAttribute(name = "RegimenFiscal", required = true)
    protected String regimenFiscal;
    
    public Emisor() {
    }
    
    public Emisor(String rfc, String regimenFiscal) {
        this.rfc = rfc;
        this.regimenFiscal = regimenFiscal;
    }
    
    /**
     * Gets the value of the rfc property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Sets the value of the rfc property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRfc(String value) {
        this.rfc = value;
    }

    /**
     * Gets the value of the nombre property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the regimenFiscal property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    /**
     * Sets the value of the regimenFiscal property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setRegimenFiscal(String value) {
        this.regimenFiscal = value;
    }

}
