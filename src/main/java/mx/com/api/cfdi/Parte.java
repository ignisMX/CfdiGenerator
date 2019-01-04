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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ignis
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "informacionAduanera"
})
public class Parte {

    @XmlElement(name = "InformacionAduanera")
    protected List<InformacionAduanera> informacionAduanera;
    @XmlAttribute(name = "ClaveProdServ", required = true)
    protected String claveProdServ;
    @XmlAttribute(name = "NoIdentificacion")
    protected String noIdentificacion;
    @XmlAttribute(name = "Cantidad", required = true)
    protected BigDecimal cantidad;
    @XmlAttribute(name = "Unidad")
    protected String unidad;
    @XmlAttribute(name = "Descripcion", required = true)
    protected String descripcion;
    @XmlAttribute(name = "ValorUnitario")
    protected BigDecimal valorUnitario;
    @XmlAttribute(name = "Importe")
    protected BigDecimal importe;
    
    public List<InformacionAduanera> getInformacionAduanera() {
        if (informacionAduanera == null) {
            informacionAduanera = new ArrayList<InformacionAduanera>();
        }
        return this.informacionAduanera;
    }

    /**
     * Gets the value of the claveProdServ property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClaveProdServ() {
        return claveProdServ;
    }

    /**
     * Sets the value of the claveProdServ property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClaveProdServ(String value) {
        this.claveProdServ = value;
    }

    /**
     * Gets the value of the noIdentificacion property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    /**
     * Sets the value of the noIdentificacion property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNoIdentificacion(String value) {
        this.noIdentificacion = value;
    }

    /**
     * Gets the value of the cantidad property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     * Sets the value of the cantidad property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setCantidad(BigDecimal value) {
        this.cantidad = value;
    }

    /**
     * Gets the value of the unidad property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * Sets the value of the unidad property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setUnidad(String value) {
        this.unidad = value;
    }

    /**
     * Gets the value of the descripcion property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the valorUnitario property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Sets the value of the valorUnitario property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setValorUnitario(BigDecimal value) {
        this.valorUnitario = value;
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
