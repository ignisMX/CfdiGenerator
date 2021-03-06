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
    "traslado"
})
public class ResumenTraslados {
    
    @XmlElement(name = "Traslado", required = true)
    protected List<Traslado> traslado;

    public ResumenTraslados() {
        this.traslado = new ArrayList<Traslado>();
    }

    public List<Traslado> getTraslado() {
        return traslado;
    }

    public void setTraslado(List<Traslado> traslado) {
        this.traslado = traslado;
    }
    
    public void addTraslado(Traslado traslado){
        if(this.traslado != null){
            this.traslado.add(traslado);
        }
    }
}
