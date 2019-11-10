/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAccessorType;

import mx.com.api.cfdi.complemento.tfd.TimbreFiscalDigital;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tfd"
})
public class Complemento {

    @XmlAnyElement(lax = true)
    protected TimbreFiscalDigital tfd;

    public TimbreFiscalDigital getTfd() {
        return tfd;
    }

    public void setTfd(TimbreFiscalDigital tfd) {
        this.tfd = tfd;
    }
}
