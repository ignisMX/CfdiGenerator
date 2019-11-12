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
public class Receptor {

    @XmlAttribute(name = "Rfc", required = true)
    protected String rfc;
    @XmlAttribute(name = "Nombre")
    protected String nombre;
    @XmlAttribute(name = "ResidenciaFiscal")
    protected String residenciaFiscal;
    @XmlAttribute(name = "NumRegIdTrib")
    protected String numRegIdTrib;
    @XmlAttribute(name = "UsoCFDI", required = true)
    protected String usoCFDI;
    
    public Receptor() {
    }
    
    public Receptor(String rfc, String usoCFDI) {
        this.rfc = rfc;
        this.usoCFDI = usoCFDI;
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
     * Gets the value of the residenciaFiscal property.
     *
     * @return possible object is {@link CPais }
     *
     */
    public String getResidenciaFiscal() {
        return residenciaFiscal;
    }

    /**
     * Sets the value of the residenciaFiscal property.
     *
     * @param value allowed object is {@link CPais }
     *
     */
    public void setResidenciaFiscal(String value) {
        this.residenciaFiscal = value;
    }

    /**
     * Gets the value of the numRegIdTrib property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNumRegIdTrib() {
        return numRegIdTrib;
    }

    /**
     * Sets the value of the numRegIdTrib property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumRegIdTrib(String value) {
        this.numRegIdTrib = value;
    }

    /**
     * Gets the value of the usoCFDI property.
     *
     * @return possible object is {@link CUsoCFDI }
     *
     */
    public String getUsoCFDI() {
        return usoCFDI;
    }

    /**
     * Sets the value of the usoCFDI property.
     *
     * @param value allowed object is {@link CUsoCFDI }
     *
     */
    public void setUsoCFDI(String value) {
        this.usoCFDI = value;
    }

}
