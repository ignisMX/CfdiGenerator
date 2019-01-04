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
    "concepto"
})
public class Conceptos {

    @XmlElement(name = "Concepto", required = true)
    protected List<Concepto> concepto;

    public Conceptos() {
        this.concepto = new ArrayList<Concepto>();
    }
    
    public List<Concepto> getConcepto() {
        if(concepto == null){
            concepto = new ArrayList<Concepto>();
        }
        return this.concepto;
    }
    
    public void setConcepto(List<Concepto> concepto){
        this.concepto = concepto;
    }
    
    public void addConcepto(Concepto concepto)
    {
        this.concepto.add(concepto);
    }

}
