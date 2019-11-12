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
public class Traslado {

    @XmlAttribute(name = "Impuesto", required = true)
    protected String impuesto;
    @XmlAttribute(name = "TipoFactor", required = true)
    protected String tipoFactor;
    @XmlAttribute(name = "TasaOCuota", required = true)
    protected BigDecimal tasaOCuota;
    @XmlAttribute(name = "Importe", required = true)
    protected BigDecimal importe;

    public Traslado() {
    }

    public Traslado(String impuesto, String tipoFactor, BigDecimal tasaOCuota, BigDecimal importe) {
        this.impuesto = impuesto;
        this.tipoFactor = tipoFactor;
        this.tasaOCuota = tasaOCuota;
        this.importe = importe;
    }

    /**
     * Gets the value of the impuesto property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getImpuesto() {
        return impuesto;
    }

    /**
     * Sets the value of the impuesto property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setImpuesto(String value) {
        this.impuesto = value;
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

    /**
     * Gets the value of the importe property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getImporte() {
        return importe;
    }

    /**
     * Sets the value of the importe property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setImporte(BigDecimal value) {
        this.importe = value;
    }

}
