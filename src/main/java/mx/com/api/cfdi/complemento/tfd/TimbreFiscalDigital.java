/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi.complemento.tfd;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.datatype.XMLGregorianCalendar;
import mx.com.api.cfdi.config.XSD;
/**
 *
 * @author ignis
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TimbreFiscalDigital")
public class TimbreFiscalDigital {
    
    @XmlAttribute(name = "Version", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String version;
    @XmlAttribute(name = "UUID", required = true)
    protected String uuid;
    @XmlAttribute(name = "FechaTimbrado", required = true)
    protected XMLGregorianCalendar fechaTimbrado;
    @XmlAttribute(name = "RfcProvCertif", required = true)
    protected String rfcProvCertif;
    @XmlAttribute(name = "Leyenda")
    protected String leyenda;
    @XmlAttribute(name = "SelloCFD", required = true)
    protected String selloCFD;
    @XmlAttribute(name = "NoCertificadoSAT", required = true)
    protected String noCertificadoSAT;
    @XmlAttribute(name = "SelloSAT", required = true)
    protected String selloSAT;
    @XmlAttribute(name = "xmlns:tfd", required = true)
    protected String prefix;
    @XmlAttribute(name = "xsi:schemaLocation", required = true)
    protected String schemaLocation;

    public TimbreFiscalDigital() {
        this.prefix = XSD.TFD_PREFIX;
        this.schemaLocation = XSD.TFD_SCHEMALOCATION;
    }

    public TimbreFiscalDigital(String uuid, XMLGregorianCalendar fechaTimbrado, String rfcProvCertif, String selloCFD, String noCertificadoSAT, String selloSAT) {
        this.uuid = uuid;
        this.fechaTimbrado = fechaTimbrado;
        this.rfcProvCertif = rfcProvCertif;
        this.selloCFD = selloCFD;
        this.noCertificadoSAT = noCertificadoSAT;
        this.selloSAT = selloSAT;
        this.prefix = XSD.TFD_PREFIX;
        this.schemaLocation = XSD.TFD_SCHEMALOCATION;
    }
    
    public String getVersion() {
        return version == null ? "1.1": version; 
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public XMLGregorianCalendar getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(XMLGregorianCalendar fechaTimbrado) {
        this.fechaTimbrado = fechaTimbrado;
    }

    public String getRfcProvCertif() {
        return rfcProvCertif;
    }

    public void setRfcProvCertif(String rfcProvCertif) {
        this.rfcProvCertif = rfcProvCertif;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public String getSelloCFD() {
        return selloCFD;
    }

    public void setSelloCFD(String selloCFD) {
        this.selloCFD = selloCFD;
    }

    public String getNoCertificadoSAT() {
        return noCertificadoSAT;
    }

    public void setNoCertificadoSAT(String noCertificadoSAT) {
        this.noCertificadoSAT = noCertificadoSAT;
    }

    public String getSelloSAT() {
        return selloSAT;
    }

    public void setSelloSAT(String selloSAT) {
        this.selloSAT = selloSAT;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }
    
}
