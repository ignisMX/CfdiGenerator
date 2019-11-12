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
    "retencion"
})
public class Retenciones {

    @XmlElement(name = "Retencion", required = true)
    protected List<RetencionDetallado> retencion;

    public Retenciones() {
        this.retencion = new ArrayList<RetencionDetallado>();
    }
    
    public List<RetencionDetallado> getRetencion() {
        return this.retencion;
    }
    
    public void addRetencion(RetencionDetallado retencion){
        if(this.retencion != null){
            this.retencion.add(retencion);
        }
    }

}
