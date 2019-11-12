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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ignis
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "impuestos",
    "informacionAduanera",
    "cuentaPredial",
    "complementoConcepto",
    "parte"
})

public class Concepto {

    @XmlElement(name = "Impuestos")
    protected Impuestos impuestos;
    @XmlElement(name = "InformacionAduanera")
    protected List<InformacionAduanera> informacionAduanera;
    @XmlElement(name = "CuentaPredial")
    protected CuentaPredial cuentaPredial;
    @XmlElement(name = "ComplementoConcepto")
    protected ComplementoConcepto complementoConcepto;
    @XmlElement(name = "Parte")
    protected List<Parte> parte;
    @XmlAttribute(name = "ClaveProdServ", required = true)
    protected String claveProdServ;
    @XmlAttribute(name = "NoIdentificacion")
    protected String noIdentificacion;
    @XmlAttribute(name = "Cantidad", required = true)
    protected BigDecimal cantidad;
    @XmlAttribute(name = "ClaveUnidad", required = true)
    protected String claveUnidad;
    @XmlAttribute(name = "Unidad")
    protected String unidad;
    @XmlAttribute(name = "Descripcion", required = true)
    protected String descripcion;
    @XmlAttribute(name = "ValorUnitario", required = true)
    protected BigDecimal valorUnitario;
    @XmlAttribute(name = "Importe", required = true)
    protected BigDecimal importe;
    @XmlAttribute(name = "Descuento")
    protected BigDecimal descuento;

    public Concepto() {
    }

    public Concepto(String claveProdServ, BigDecimal cantidad, String claveUnidad, 
            String descripcion, BigDecimal valorUnitario, BigDecimal importe) {
        this.claveProdServ = claveProdServ;
        this.cantidad = cantidad;
        this.claveUnidad = claveUnidad;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
        this.impuestos = new Impuestos();
    }
    
    
    /**
     * Gets the value of the impuestos property.
     *
     * @return possible object is
             *     {@link Comprobante.Conceptos.Concepto.Impuestos }
     *
     */
    public Impuestos getImpuestos() {
        return impuestos;
    }

    /**
     * Sets the value of the impuestos property.
     *
     * @param value allowed object is
             *     {@link Comprobante.Conceptos.Concepto.Impuestos }
     *
     */
    public void setImpuestos(Impuestos value) {
        this.impuestos = value;
    }
    
    public List<InformacionAduanera> getInformacionAduanera() {
        if (informacionAduanera == null) {
            informacionAduanera = new ArrayList<InformacionAduanera>();
        }
        return this.informacionAduanera;
    }

    /**
     * Gets the value of the cuentaPredial property.
     *
     * @return possible object is
             *     {@link Comprobante.Conceptos.Concepto.CuentaPredial }
     *
     */
    public CuentaPredial getCuentaPredial() {
        return cuentaPredial;
    }

    /**
     * Sets the value of the cuentaPredial property.
     *
     * @param value allowed object is
             *     {@link Comprobante.Conceptos.Concepto.CuentaPredial }
     *
     */
    public void setCuentaPredial(CuentaPredial value) {
        this.cuentaPredial = value;
    }

    /**
     * Gets the value of the complementoConcepto property.
     *
     * @return possible object is
             *     {@link Comprobante.Conceptos.Concepto.ComplementoConcepto }
     *
     */
    public ComplementoConcepto getComplementoConcepto() {
        return complementoConcepto;
    }

    /**
     * Sets the value of the complementoConcepto property.
     *
     * @param value allowed object is
             *     {@link Comprobante.Conceptos.Concepto.ComplementoConcepto }
     *
     */
    public void setComplementoConcepto(ComplementoConcepto value) {
        this.complementoConcepto = value;
    }

    public List<Parte> getParte() {
        if (parte == null) {
            parte = new ArrayList<Parte>();
        }
        return this.parte;
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
     * Gets the value of the claveUnidad property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getClaveUnidad() {
        return claveUnidad;
    }

    /**
     * Sets the value of the claveUnidad property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setClaveUnidad(String value) {
        this.claveUnidad = value;
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

    /**
     * Gets the value of the descuento property.
     *
     * @return possible object is {@link BigDecimal }
     *
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Sets the value of the descuento property.
     *
     * @param value allowed object is {@link BigDecimal }
     *
     */
    public void setDescuento(BigDecimal value) {
        this.descuento = value;
    }

}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "any"
})
class ComplementoConcepto {

    @XmlAnyElement(lax = true)
    protected List<Object> any;

    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
class CuentaPredial {

    @XmlAttribute(name = "Numero", required = true)
    protected String numero;

    /**
     * Gets the value of the numero property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the value of the numero property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNumero(String value) {
        this.numero = value;
    }

}