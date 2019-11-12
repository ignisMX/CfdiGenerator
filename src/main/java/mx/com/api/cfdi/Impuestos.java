/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ignis
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "traslados",
    "retenciones"
})
public class Impuestos {

    @XmlElement(name = "Traslados")
    protected Traslados traslados;
    @XmlElement(name = "Retenciones")
    protected Retenciones retenciones;

    public Impuestos() {
        this.traslados = new Traslados();
        this.retenciones = new Retenciones();
    }
    
    /**
     * Gets the value of the traslados property.
     *
     * @return possible object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados }
     *
     */
    public Traslados getTraslados() {
        return traslados;
    }

    /**
     * Sets the value of the traslados property.
     *
     * @param value allowed object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados }
     *
     */
    public void setTraslados(Traslados value) {
        this.traslados = value;
    }

    /**
     * Gets the value of the retenciones property.
     *
     * @return possible object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones }
     *
     */
    public Retenciones getRetenciones() {
        return retenciones;
    }

    /**
     * Sets the value of the retenciones property.
     *
     * @param value allowed object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones }
     *
     */
    public void setRetenciones(Retenciones value) {
        this.retenciones = value;
    }

}