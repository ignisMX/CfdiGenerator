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
public class TrasladoDetallado extends Traslado {

    @XmlAttribute(name = "Base", required = true)
    protected BigDecimal base;

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

}