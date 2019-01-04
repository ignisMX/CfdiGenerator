/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import mx.com.api.cfdi.Comprobante;
import mx.com.api.stamp.Cfdi;
import mx.com.api.cfdi.Concepto;
import mx.com.api.cfdi.Emisor;
import mx.com.api.cfdi.Receptor;
import mx.com.api.cfdi.RetencionDetallado;
import mx.com.api.cfdi.TrasladoDetallado;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author ignis
 */
public class CfdiTest {

    /**
     * Test of NewCfdi method, of class Cfdi.
     */
    @Test
    public void testBuildCfdi() throws Exception{
        System.out.println("BuildCfdi");
        String serie = "IN";
        String folio = "00001";
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = "";
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante result = Cfdi.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
        assertThat(result, hasProperty("serie", is(serie)));
        assertThat(result, hasProperty("folio", is(folio)));
        assertThat(result, hasProperty("fecha", is(fecha)));
        assertThat(result, hasProperty("noCertificado", is(numeroCertificado)));
        assertThat(result, hasProperty("certificado", is(certificado)));
        assertThat(result, hasProperty("moneda", is(moneda)));
        assertThat(result, hasProperty("tipoComprobante", is(tipoComprobante)));
        assertThat(result, hasProperty("lugarExpedicion", is(lugarExpedicion)));
        
    }
    
    /**
     * Test of NewCfdi method, of class Cfdi.
     */
    @Test
    public void testBuildCfdiWithEmisor() throws Exception{
        System.out.println("BuildCfdi With Emisor");
        String serie = "IN";
        String folio = "00001";
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = "";
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
        String rfc = "XAXX010101000";
        String nombre = "";
        String regimenFiscal = "";
        Emisor issuer = Cfdi.NewEmisor(rfc, regimenFiscal);
        issuer.setNombre(nombre);
        cfdi.setEmisor(issuer);
        
        
        assertThat(cfdi, hasProperty("serie", is(serie)));
        assertThat(cfdi, hasProperty("folio", is(folio)));
        assertThat(cfdi, hasProperty("fecha", is(fecha)));
        assertThat(cfdi, hasProperty("noCertificado", is(numeroCertificado)));
        assertThat(cfdi, hasProperty("certificado", is(certificado)));
        assertThat(cfdi, hasProperty("moneda", is(moneda)));
        assertThat(cfdi, hasProperty("tipoComprobante", is(tipoComprobante)));
        assertThat(cfdi, hasProperty("lugarExpedicion", is(lugarExpedicion)));
        
        assertThat(cfdi, hasProperty("emisor", notNullValue()));
        assertThat(issuer, hasProperty("rfc", is(rfc)));
        assertThat(issuer, hasProperty("nombre", is(nombre)));
        assertThat(issuer, hasProperty("regimenFiscal", is(regimenFiscal)));
        
    }
    
    /**
     * Test of NewCfdi method, of class Cfdi.
     */
    @Test
    public void testBuildCfdiWithReceptor() throws Exception{
        System.out.println("BuildCfdi With Receptor");
        String serie = "IN";
        String folio = "00001";
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = "";
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
        String rfc = "XAXX010101000";
        String nombre = "";
        String regimenFiscal = "";
        Emisor issuer = Cfdi.NewEmisor(rfc, regimenFiscal);
        issuer.setNombre(nombre);
        cfdi.setEmisor(issuer);
        String rfcReceiver = "XEXX010101000";
        String cfdiUse = "G01";
        String receiverName = "Nombre del receptor";
        String fiscalResidence = "CA";
        String tributalNumber = "AAZO1808";
        Receptor receiver = Cfdi.NewReceptor(rfcReceiver, cfdiUse);
        receiver.setNombre(receiverName);
        receiver.setResidenciaFiscal(fiscalResidence);
        receiver.setNumRegIdTrib(tributalNumber);
        cfdi.setReceptor(receiver);
        
        assertThat(cfdi, hasProperty("serie", is(serie)));
        assertThat(cfdi, hasProperty("folio", is(folio)));
        assertThat(cfdi, hasProperty("fecha", is(fecha)));
        assertThat(cfdi, hasProperty("noCertificado", is(numeroCertificado)));
        assertThat(cfdi, hasProperty("certificado", is(certificado)));
        assertThat(cfdi, hasProperty("moneda", is(moneda)));
        assertThat(cfdi, hasProperty("tipoComprobante", is(tipoComprobante)));
        assertThat(cfdi, hasProperty("lugarExpedicion", is(lugarExpedicion)));
        
        assertThat(cfdi, hasProperty("emisor", notNullValue()));
        assertThat(issuer, hasProperty("rfc", is(rfc)));
        assertThat(issuer, hasProperty("nombre", is(nombre)));
        assertThat(issuer, hasProperty("regimenFiscal", is(regimenFiscal)));
        
        assertThat(cfdi, hasProperty("receptor", notNullValue()));
        assertThat(receiver, hasProperty("rfc", is(rfcReceiver)));
        assertThat(receiver, hasProperty("usoCFDI", is(cfdiUse)));
        assertThat(receiver, hasProperty("nombre", is(receiverName)));
        assertThat(receiver, hasProperty("residenciaFiscal", is(fiscalResidence)));
        assertThat(receiver, hasProperty("numRegIdTrib", is(tributalNumber)));
    }
    
    /**
     * Test of NewCfdi method, of class Cfdi.
     */
    @Test
    public void testBuildCfdiWithConceptos() throws Exception{
        System.out.println("BuildCfdi With Conceptos");
        String serie = "IN";
        String folio = "00001";
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = "";
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
        String rfc = "XAXX010101000";
        String nombre = "";
        String regimenFiscal = "";
        
        Emisor issuer = Cfdi.NewEmisor(rfc, regimenFiscal);
        issuer.setNombre(nombre);
        cfdi.setEmisor(issuer);
        String rfcReceiver = "XEXX010101000";
        String cfdiUse = "G01";
        String receiverName = "Nombre del receptor";
        String fiscalResidence = "CA";
        String tributalNumber = "AAZO1808";
        
        Receptor receiver = Cfdi.NewReceptor(rfcReceiver, cfdiUse);
        receiver.setNombre(receiverName);
        receiver.setResidenciaFiscal(fiscalResidence);
        receiver.setNumRegIdTrib(tributalNumber);
        cfdi.setReceptor(receiver);
        
        String claveProdServ = "81161501";
        String unidad = "pieza";
        String claveUnidad = "H87"; 
        String descripcion = "Descripcion de un producto";
        String noIdentificacion = "HPV201";
        BigDecimal descuento = new BigDecimal(5);
        BigDecimal cantidad = new BigDecimal(15.0);
        BigDecimal valorUnitario = new BigDecimal(2);
        BigDecimal importe = new BigDecimal(30);
        
        Concepto concepto = Cfdi.NewConcepto(claveProdServ, cantidad, claveUnidad, descripcion, valorUnitario, importe);
        concepto.setUnidad(unidad);
        concepto.setNoIdentificacion(noIdentificacion);
        concepto.setDescuento(descuento);
        cfdi.getConceptos().addConcepto(concepto);
        
        assertThat(cfdi, hasProperty("serie", is(serie)));
        assertThat(cfdi, hasProperty("folio", is(folio)));
        assertThat(cfdi, hasProperty("fecha", is(fecha)));
        assertThat(cfdi, hasProperty("noCertificado", is(numeroCertificado)));
        assertThat(cfdi, hasProperty("certificado", is(certificado)));
        assertThat(cfdi, hasProperty("moneda", is(moneda)));
        assertThat(cfdi, hasProperty("tipoComprobante", is(tipoComprobante)));
        assertThat(cfdi, hasProperty("lugarExpedicion", is(lugarExpedicion)));
        
        assertThat(cfdi, hasProperty("emisor", notNullValue()));
        assertThat(issuer, hasProperty("rfc", is(rfc)));
        assertThat(issuer, hasProperty("nombre", is(nombre)));
        assertThat(issuer, hasProperty("regimenFiscal", is(regimenFiscal)));
        
        assertThat(cfdi, hasProperty("receptor", notNullValue()));
        assertThat(receiver, hasProperty("rfc", is(rfcReceiver)));
        assertThat(receiver, hasProperty("usoCFDI", is(cfdiUse)));
        assertThat(receiver, hasProperty("nombre", is(receiverName)));
        assertThat(receiver, hasProperty("residenciaFiscal", is(fiscalResidence)));
        assertThat(receiver, hasProperty("numRegIdTrib", is(tributalNumber)));
        
        assertThat(cfdi, hasProperty("conceptos", notNullValue()));
        assertTrue(cfdi.getConceptos().getConcepto().size() > 0);
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("claveProdServ", is(claveProdServ)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("cantidad", is(cantidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("claveUnidad", is(claveUnidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("descripcion", is(descripcion)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("valorUnitario", is(valorUnitario)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("importe", is(importe)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("unidad", is(unidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("noIdentificacion", is(noIdentificacion)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("descuento", is(descuento)));
    }
    
    /**
     * Test of NewCfdi method, of class Cfdi.
     */
    @Test
    public void testBuildCfdiWithConceptosAndImpuestos() throws Exception{
        System.out.println("BuildCfdi With Conceptos And Impuestos");
        String serie = "IN";
        String folio = "00001";
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = "";
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
        String rfc = "XAXX010101000";
        String nombre = "";
        String regimenFiscal = "";
        
        Emisor issuer = Cfdi.NewEmisor(rfc, regimenFiscal);
        issuer.setNombre(nombre);
        cfdi.setEmisor(issuer);
        String rfcReceiver = "XEXX010101000";
        String cfdiUse = "G01";
        String receiverName = "Nombre del receptor";
        String fiscalResidence = "CA";
        String tributalNumber = "AAZO1808";
        
        Receptor receiver = Cfdi.NewReceptor(rfcReceiver, cfdiUse);
        receiver.setNombre(receiverName);
        receiver.setResidenciaFiscal(fiscalResidence);
        receiver.setNumRegIdTrib(tributalNumber);
        cfdi.setReceptor(receiver);
        
        String claveProdServ = "81161501";
        String unidad = "pieza";
        String claveUnidad = "H87"; 
        String descripcion = "Descripcion de un producto";
        String noIdentificacion = "HPV201";
        BigDecimal descuento = new BigDecimal(5);
        BigDecimal cantidad = new BigDecimal(15.0);
        BigDecimal valorUnitario = new BigDecimal(2);
        BigDecimal importe = new BigDecimal(30);
        
        Concepto concepto = Cfdi.NewConcepto(claveProdServ, cantidad, claveUnidad, descripcion, valorUnitario, importe);
        concepto.setUnidad(unidad);
        concepto.setNoIdentificacion(noIdentificacion);
        concepto.setDescuento(descuento);
        cfdi.getConceptos().addConcepto(concepto);
        
        String impuesto = "IVA";
        String tipoFactor = "Tasa";
        BigDecimal base = new BigDecimal(30);
        TrasladoDetallado trasladoDetallado = Cfdi.NewTrasladoConcepto(base, impuesto, tipoFactor);
        
        cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().add(trasladoDetallado);
        
        BigDecimal retencionBase = new BigDecimal(30);
        BigDecimal retencionTasaCuota = new BigDecimal(0.16000);
        BigDecimal retencionImporte = new BigDecimal(130);
        String retencionImpuesto = "";
        String retencionTipoFactor = "";
        
        RetencionDetallado retencion  = Cfdi.NewRetencionConcepto(retencionImpuesto, retencionImporte, retencionBase, retencionTipoFactor, retencionTasaCuota);
        
        cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().addRetencion(retencion);
        
        assertThat(cfdi, hasProperty("serie", is(serie)));
        assertThat(cfdi, hasProperty("folio", is(folio)));
        assertThat(cfdi, hasProperty("fecha", is(fecha)));
        assertThat(cfdi, hasProperty("noCertificado", is(numeroCertificado)));
        assertThat(cfdi, hasProperty("certificado", is(certificado)));
        assertThat(cfdi, hasProperty("moneda", is(moneda)));
        assertThat(cfdi, hasProperty("tipoComprobante", is(tipoComprobante)));
        assertThat(cfdi, hasProperty("lugarExpedicion", is(lugarExpedicion)));
        
        assertThat(cfdi, hasProperty("emisor", notNullValue()));
        assertThat(issuer, hasProperty("rfc", is(rfc)));
        assertThat(issuer, hasProperty("nombre", is(nombre)));
        assertThat(issuer, hasProperty("regimenFiscal", is(regimenFiscal)));
        
        assertThat(cfdi, hasProperty("receptor", notNullValue()));
        assertThat(receiver, hasProperty("rfc", is(rfcReceiver)));
        assertThat(receiver, hasProperty("usoCFDI", is(cfdiUse)));
        assertThat(receiver, hasProperty("nombre", is(receiverName)));
        assertThat(receiver, hasProperty("residenciaFiscal", is(fiscalResidence)));
        assertThat(receiver, hasProperty("numRegIdTrib", is(tributalNumber)));
        
        assertThat(cfdi, hasProperty("conceptos", notNullValue()));
        assertTrue(cfdi.getConceptos().getConcepto().size() > 0);
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("claveProdServ", is(claveProdServ)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("cantidad", is(cantidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("claveUnidad", is(claveUnidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("descripcion", is(descripcion)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("valorUnitario", is(valorUnitario)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("importe", is(importe)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("unidad", is(unidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("noIdentificacion", is(noIdentificacion)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("descuento", is(descuento)));
        
        assertThat(cfdi, hasProperty("impuestos", notNullValue()));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos(), hasProperty("traslados", notNullValue()));
        assertTrue(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().size() > 0);
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().get(0), hasProperty("base", is(base)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().get(0), hasProperty("impuesto", is(impuesto)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().get(0), hasProperty("tipoFactor", is(tipoFactor)));
        
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos(), hasProperty("retenciones", notNullValue()));
        assertTrue(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().size() > 0);
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("base", is(retencionBase)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("impuesto", is(retencionImpuesto)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("tipoFactor", is(retencionTipoFactor)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("importe", is(retencionImporte)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("tasaOCuota", is(retencionTasaCuota)));
    }
    
    /**
     * Test of NewCfdi method, of class Cfdi.
     */
    @Test
    public void testBuildCfdiWithImpuestos() throws Exception{
        System.out.println("BuildCfdi With Impuestos");
        String serie = "IN";
        String folio = "00001";
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = "";
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
        String rfc = "XAXX010101000";
        String nombre = "";
        String regimenFiscal = "";
        
        Emisor issuer = Cfdi.NewEmisor(rfc, regimenFiscal);
        issuer.setNombre(nombre);
        cfdi.setEmisor(issuer);
        String rfcReceiver = "XEXX010101000";
        String cfdiUse = "G01";
        String receiverName = "Nombre del receptor";
        String fiscalResidence = "CA";
        String tributalNumber = "AAZO1808";
        
        Receptor receiver = Cfdi.NewReceptor(rfcReceiver, cfdiUse);
        receiver.setNombre(receiverName);
        receiver.setResidenciaFiscal(fiscalResidence);
        receiver.setNumRegIdTrib(tributalNumber);
        cfdi.setReceptor(receiver);
        
        String claveProdServ = "81161501";
        String unidad = "pieza";
        String claveUnidad = "H87"; 
        String descripcion = "Descripcion de un producto";
        String noIdentificacion = "HPV201";
        BigDecimal descuento = new BigDecimal(5);
        BigDecimal cantidad = new BigDecimal(15.0);
        BigDecimal valorUnitario = new BigDecimal(2);
        BigDecimal importe = new BigDecimal(30);
        
        Concepto concepto = Cfdi.NewConcepto(claveProdServ, cantidad, claveUnidad, descripcion, valorUnitario, importe);
        concepto.setUnidad(unidad);
        concepto.setNoIdentificacion(noIdentificacion);
        concepto.setDescuento(descuento);
        cfdi.getConceptos().addConcepto(concepto);
        
        String impuesto = "IVA";
        String tipoFactor = "Tasa";
        BigDecimal base = new BigDecimal(30);
        TrasladoDetallado trasladoDetallado = Cfdi.NewTrasladoConcepto(base, impuesto, tipoFactor);
        
        cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().addTraslado(trasladoDetallado);
        
        BigDecimal retencionBase = new BigDecimal(30);
        BigDecimal retencionTasaCuota = new BigDecimal(0.16000);
        BigDecimal retencionImporte = new BigDecimal(130);;
        String retencionImpuesto = "";
        String retencionTipoFactor = "";
        
        RetencionDetallado retencion  = Cfdi.NewRetencionConcepto(retencionImpuesto, retencionImporte, retencionBase, retencionTipoFactor, retencionTasaCuota);
        
        cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().addRetencion(retencion);
        
        assertThat(cfdi, hasProperty("serie", is(serie)));
        assertThat(cfdi, hasProperty("folio", is(folio)));
        assertThat(cfdi, hasProperty("fecha", is(fecha)));
        assertThat(cfdi, hasProperty("noCertificado", is(numeroCertificado)));
        assertThat(cfdi, hasProperty("certificado", is(certificado)));
        assertThat(cfdi, hasProperty("moneda", is(moneda)));
        assertThat(cfdi, hasProperty("tipoComprobante", is(tipoComprobante)));
        assertThat(cfdi, hasProperty("lugarExpedicion", is(lugarExpedicion)));
        
        assertThat(cfdi, hasProperty("emisor", notNullValue()));
        assertThat(issuer, hasProperty("rfc", is(rfc)));
        assertThat(issuer, hasProperty("nombre", is(nombre)));
        assertThat(issuer, hasProperty("regimenFiscal", is(regimenFiscal)));
        
        assertThat(cfdi, hasProperty("receptor", notNullValue()));
        assertThat(receiver, hasProperty("rfc", is(rfcReceiver)));
        assertThat(receiver, hasProperty("usoCFDI", is(cfdiUse)));
        assertThat(receiver, hasProperty("nombre", is(receiverName)));
        assertThat(receiver, hasProperty("residenciaFiscal", is(fiscalResidence)));
        assertThat(receiver, hasProperty("numRegIdTrib", is(tributalNumber)));
        
        assertThat(cfdi, hasProperty("conceptos", notNullValue()));
        assertTrue(cfdi.getConceptos().getConcepto().size() > 0);
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("claveProdServ", is(claveProdServ)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("cantidad", is(cantidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("claveUnidad", is(claveUnidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("descripcion", is(descripcion)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("valorUnitario", is(valorUnitario)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("importe", is(importe)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("unidad", is(unidad)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("noIdentificacion", is(noIdentificacion)));
        assertThat(cfdi.getConceptos().getConcepto().get(0), hasProperty("descuento", is(descuento)));
        
        assertThat(cfdi, hasProperty("impuestos", notNullValue()));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos(), hasProperty("traslados", notNullValue()));
        assertTrue(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().size() > 0);
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().get(0), hasProperty("base", is(base)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().get(0), hasProperty("impuesto", is(impuesto)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getTraslados().getTraslado().get(0), hasProperty("tipoFactor", is(tipoFactor)));
        
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos(), hasProperty("retenciones", notNullValue()));
        assertTrue(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().size() > 0);
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("base", is(retencionBase)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("impuesto", is(retencionImpuesto)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("tipoFactor", is(retencionTipoFactor)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("importe", is(retencionImporte)));
        assertThat(cfdi.getConceptos().getConcepto().get(0).getImpuestos().getRetenciones().getRetencion().get(0), hasProperty("tasaOCuota", is(retencionTasaCuota)));
    }
    
    
}
