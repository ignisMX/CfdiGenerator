/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
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
public class ResumenImpuestos {
    
    @XmlAttribute(name = "TotalImpuestosRetenidos")
    protected BigDecimal totalImpuestosRetenidos;
    
    @XmlAttribute(name = "TotalImpuestosTrasladados")
    protected BigDecimal totalImpuestosTrasladados;
    
    @XmlElement(name = "Traslados")
    protected ResumenTraslados traslados;
    
    @XmlElement(name = "Retenciones")
    protected ResumenRetenciones retenciones;

    public ResumenImpuestos() {
        this.traslados = new ResumenTraslados();
        this.retenciones = new ResumenRetenciones();
    }
    
    public ResumenImpuestos(BigDecimal totalImpuestosRetenidos, BigDecimal totalImpuestosTrasladados) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
        this.traslados = new ResumenTraslados();
        this.retenciones = new ResumenRetenciones();
    }

    public BigDecimal getTotalImpuestosRetenidos() {
        return totalImpuestosRetenidos;
    }

    public void setTotalImpuestosRetenidos(BigDecimal totalImpuestosRetenidos) {
        this.totalImpuestosRetenidos = totalImpuestosRetenidos;
    }

    public BigDecimal getTotalImpuestosTrasladados() {
        return totalImpuestosTrasladados;
    }

    public void setTotalImpuestosTrasladados(BigDecimal totalImpuestosTrasladados) {
        this.totalImpuestosTrasladados = totalImpuestosTrasladados;
    }

    public ResumenTraslados getTraslados() {
        return traslados;
    }

    public void setTraslados(ResumenTraslados traslados) {
        this.traslados = traslados;
    }

    public ResumenRetenciones getRetenciones() {
        return retenciones;
    }

    public void setRetenciones(ResumenRetenciones retenciones) {
        this.retenciones = retenciones;
    }
    
}
