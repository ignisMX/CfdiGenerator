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
public class ImpuestosDetallados extends Impuestos {
    @XmlAttribute(name = "TotalImpuestosRetenidos")
    protected BigDecimal totalImpuestosRetenidos;
    @XmlAttribute(name = "TotalImpuestosTrasladados")
    protected BigDecimal totalImpuestosTrasladados;

    public ImpuestosDetallados() {
    }
    
    public ImpuestosDetallados(BigDecimal totalImpuestosRetenidos, BigDecimal totalImpuestosTrasladados) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
    }

    /**
     * Gets the value of the totalImpuestosRetenidos property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    /**
     * Sets the value of the totalImpuestosRetenidos property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setTotalImpuestosRetenidos(BigDecimal value) {
        this.totalImpuestosRetenidos = value;
    }

    /**
     * Gets the value of the totalImpuestosTrasladados property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }

    /**
     * Sets the value of the totalImpuestosTrasladados property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setTotalImpuestosTrasladados(BigDecimal value) {
        this.totalImpuestosTrasladados = value;
    }

}