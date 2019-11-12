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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ignis
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cfdiRelacionado"
})
public class CfdiRelacionados {

    @XmlElement(name = "CfdiRelacionado", required = true)
    protected List<CfdiRelacionado> cfdiRelacionado;
    @XmlAttribute(name = "TipoRelacion", required = true)
    protected String tipoRelacion;

    public List<CfdiRelacionado> getCfdiRelacionado() {
        if (cfdiRelacionado == null) {
            cfdiRelacionado = new ArrayList<CfdiRelacionado>();
        }
        return this.cfdiRelacionado;
    }

    /**
     * Gets the value of the tipoRelacion property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getTipoRelacion() {
        return tipoRelacion;
    }

    /**
     * Sets the value of the tipoRelacion property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTipoRelacion(String value) {
        this.tipoRelacion = value;
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
class CfdiRelacionado {

    @XmlAttribute(name = "UUID", required = true)
    protected String uuid;

    /**
     * Gets the value of the uuid property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

}
