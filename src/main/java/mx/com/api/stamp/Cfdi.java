/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.stamp;

import java.math.BigDecimal;
import mx.com.api.cfdi.*;
import javax.xml.datatype.XMLGregorianCalendar;
/**
 *
 * @author ignis
 */

public class Cfdi {
    public Cfdi(){}
    
    public static Comprobante NewCfdi(String serie, String folio,XMLGregorianCalendar fecha, 
            String numeroCertificado, String certificado, String moneda, String tipoComprobante,
            String lugarExpedicion){
        
        Comprobante cfdi = new Comprobante();
        cfdi.setSerie(serie);
        cfdi.setFolio(folio);
        cfdi.setFecha(fecha);
        cfdi.setNoCertificado(numeroCertificado);
        cfdi.setCertificado(certificado);
        cfdi.setMoneda(moneda);
        cfdi.setTipoComprobante(tipoComprobante);
        cfdi.setLugarExpedicion(lugarExpedicion);
        
        return cfdi;
    }
    
    public static Emisor NewEmisor(String rfc, String regimenFiscal){
        return new Emisor(rfc, regimenFiscal);
    }
    
    public static Receptor NewReceptor(String rfc, String usoCFDI){
        return new Receptor(rfc, usoCFDI);
    }
    
    public static Concepto NewConcepto(String claveProdServ, BigDecimal cantidad, String claveUnidad, 
            String descripcion, BigDecimal valorUnitario, BigDecimal importe){
        return new Concepto(claveProdServ, cantidad, claveUnidad, descripcion, valorUnitario, importe);
    }
    
    public static TrasladoDetallado NewTrasladoConcepto(BigDecimal base, String impuesto, String tipoFactor) {
        TrasladoDetallado transfferDetail = new TrasladoDetallado();
        transfferDetail.setBase(base);
        transfferDetail.setImpuesto(impuesto);
        transfferDetail.setTipoFactor(tipoFactor);
        return transfferDetail;
    }
    
    public static RetencionDetallado NewRetencionConcepto( String impuesto, BigDecimal importe, BigDecimal base,String tipoFactor, BigDecimal TasaCuota) {
        RetencionDetallado withHoldingDetail = new RetencionDetallado(impuesto, importe, base, tipoFactor, TasaCuota);
        return withHoldingDetail;
    }
}
