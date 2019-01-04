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
public class InformacionAduanera {

    @XmlAttribute(name = "NumeroPedimento", required = true)
    protected String numeroPedimento;

    /**
     * Gets the value of the numeroPedimento property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNumeroPedimento() {
        return numeroPedimento;
    }

    /**
     * Sets the value of the numeroPedimento property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumeroPedimento(String value) {
        this.numeroPedimento = value;
    }

}
