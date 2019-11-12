/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi;

import java.math.BigDecimal;
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
public class RetencionDetallado extends Retencion {

    @XmlAttribute(name = "Base", required = true)
    protected BigDecimal base;
    @XmlAttribute(name = "TipoFactor", required = true)
    protected String tipoFactor;
    @XmlAttribute(name = "TasaOCuota", required = true)
    protected BigDecimal tasaOCuota;

    public RetencionDetallado() {
    }
    
    public RetencionDetallado(String impuesto, BigDecimal importe, BigDecimal base, String tipoFactor, BigDecimal tasaOCuota) {
        super(impuesto, importe);
        this.base = base;
        this.tipoFactor = tipoFactor;
        this.tasaOCuota = tasaOCuota;
    }

    /**
     * Gets the value of the base property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getBase() {
        return base;
    }

    /**
     * Sets the value of the base property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setBase(BigDecimal value) {
        this.base = value;
    }

    /**
     * Gets the value of the tipoFactor property.
     *
     * @return possible object is {@link CTipoFactor }
     *
     */
    public String getTipoFactor() {
        return tipoFactor;
    }

    /**
     * Sets the value of the tipoFactor property.
     *
     * @param value allowed object is {@link CTipoFactor }
     *
     */
    public void setTipoFactor(String value) {
        this.tipoFactor = value;
    }

    /**
     * Gets the value of the tasaOCuota property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getTasaOCuota() {
        return tasaOCuota;
    }

    /**
     * Sets the value of the tasaOCuota property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setTasaOCuota(BigDecimal value) {
        this.tasaOCuota = value;
    }

}
