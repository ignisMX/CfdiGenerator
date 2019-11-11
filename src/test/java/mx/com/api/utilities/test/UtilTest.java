/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.utilities.test;


import mx.com.api.cfdi.Emisor;
import mx.com.api.cfdi.Concepto;
import mx.com.api.cfdi.Receptor;
import mx.com.api.cfdi.Traslado;
import mx.com.api.cfdi.Retencion;
import mx.com.api.cfdi.Comprobante;
import mx.com.api.cfdi.ResumenImpuestos;
import mx.com.api.cfdi.TrasladoDetallado;
import mx.com.api.cfdi.RetencionDetallado;

import mx.com.api.cfdi.util.Util;
import mx.com.api.cfdi.factory.Cfdi;

import java.util.Date;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import mx.com.api.cfdi.complemento.tfd.TimbreFiscalDigital;



import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ignis
 */
public class UtilTest {
    
    private String certificate = "MIIF+TCCA+GgAwIBAgIUMzAwMDEwMDAwMDAzMDAwMjM3MD"
            + "gwDQYJKoZIhvcNAQELBQAwggFmMSAwHgYDVQQDDBdBLkMuIDIgZGUgcHJ1ZWJhcyg"
            + "0MDk2KTEvMC0GA1UECgwmU2VydmljaW8gZGUgQWRtaW5pc3RyYWNpw7NuIFRyaWJ1"
            + "dGFyaWExODA2BgNVBAsML0FkbWluaXN0cmFjacOzbiBkZSBTZWd1cmlkYWQgZGUgb"
            + "GEgSW5mb3JtYWNpw7NuMSkwJwYJKoZIhvcNAQkBFhphc2lzbmV0QHBydWViYXMuc2"
            + "F0LmdvYi5teDEmMCQGA1UECQwdQXYuIEhpZGFsZ28gNzcsIENvbC4gR3VlcnJlcm8"
            + "xDjAMBgNVBBEMBTA2MzAwMQswCQYDVQQGEwJNWDEZMBcGA1UECAwQRGlzdHJpdG8g"
            + "RmVkZXJhbDESMBAGA1UEBwwJQ295b2Fjw6FuMRUwEwYDVQQtEwxTQVQ5NzA3MDFOT"
            + "jMxITAfBgkqhkiG9w0BCQIMElJlc3BvbnNhYmxlOiBBQ0RNQTAeFw0xNzA1MTgwMz"
            + "U0NTZaFw0yMTA1MTgwMzU0NTZaMIHlMSkwJwYDVQQDEyBBQ0NFTSBTRVJWSUNJT1M"
            + "gRU1QUkVTQVJJQUxFUyBTQzEpMCcGA1UEKRMgQUNDRU0gU0VSVklDSU9TIEVNUFJF"
            + "U0FSSUFMRVMgU0MxKTAnBgNVBAoTIEFDQ0VNIFNFUlZJQ0lPUyBFTVBSRVNBUklBT"
            + "EVTIFNDMSUwIwYDVQQtExxBQUEwMTAxMDFBQUEgLyBIRUdUNzYxMDAzNFMyMR4wHA"
            + "YDVQQFExUgLyBIRUdUNzYxMDAzTURGUk5OMDkxGzAZBgNVBAsUEkNTRDAxX0FBQTA"
            + "xMDEwMUFBQTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJdUcsHIEIgw"
            + "ivvAantGnYVIO3+7yTdD1tkKopbL+tKSjRFo1ErPdGJxP3gxT5O+ACIDQXN+HS9uM"
            + "WDYnaURalSIF9COFCdh/OH2Pn+UmkN4culr2DanKztVIO8idXM6c9aHn5hOo7hDxX"
            + "MC3uOuGV3FS4ObkxTV+9NsvOAV2lMe27SHrSB0DhuLurUbZwXm+/r4dtz3b2uLgBc"
            + "+Diy95PG+MIu7oNKM89aBNGcjTJw+9k+WzJiPd3ZpQgIedYBD+8QWxlYCgxhnta3k"
            + "9ylgXKYXCYk0k0qauvBJ1jSRVf5BjjIUbOstaQp59nkgHh45c9gnwJRV618NW0fMe"
            + "DzuKR0CAwEAAaMdMBswDAYDVR0TAQH/BAIwADALBgNVHQ8EBAMCBsAwDQYJKoZIhv"
            + "cNAQELBQADggIBABKj0DCNL1lh44y+OcWFrT2icnKF7WySOVihx0oR+HPrWKBMXxo"
            + "9KtrodnB1tgIx8f+Xjqyphhbw+juDSeDrb99PhC4+E6JeXOkdQcJt50Kyodl9URpC"
            + "VWNWjUb3F/ypa8oTcff/eMftQZT7MQ1Lqht+xm3QhVoxTIASce0jjsnBTGD2JQ4uT"
            + "3oCem8bmoMXV/fk9aJ3v0+ZIL42MpY4POGUa/iTaawklKRAL1Xj9IdIR06RK68RS6"
            + "xrGk6jwbDTEKxJpmZ3SPLtlsmPUTO1kraTPIo9FCmU/zZkWGpd8ZEAAFw+ZfI+bdX"
            + "BfvdDwaM2iMGTQZTTEgU5KKTIvkAnHo9O45SqSJwqV9NLfPAxCo5eRR2OGibd9jhH"
            + "e81zUsp5GdE1mZiSqJU82H3cu6BiE+D3YbZeZnjrNSxBgKTIf8w+KNYPM4aWnuUMl"
            + "0mLgtOxTUXi9MKnUccq3GZLA7bx7Zn211yPRqEjSAqybUMVIOho6aqzkfc3WLZ6Ln"
            + "GU+hyHuZUfPwbnClb7oFFz1PlvGOpNDsUb0qP42QCGBiTUseGugAzqOP6EYpVPC73"
            + "gFourmdBQgfayaEvi3xjNanFkPlW1XEYNrYJB4yNjphFrvWwTY86vL2o8gZN0Utmc"
            + "5fnoBTfM9r2zVKmEi6FUeJ1iaDaVNv47te9iS1ai4V4vBY8r";
    
    private String selloCFD = "kd+g7lL2tp13JacUYTKiRTW3uKmXp4awD9NmeAT7QS2GLyiid"
            + "5/WNG5cp1L6/Wh67UfNM2M14DFvw+IbiUYRwmS23TSHHF6p8mLBBHuV6QnNCoF97D"
            + "tB8Mkr4H61jU33UCkpKIYEt0CJC45eg/UHusb4Ksib24rx7PN2X/BrNi9fAqv7LSq"
            + "fEuQ5fumM9GFQiEccw3uq/KUgWU/V8IA8EUjZxqVxVfpqibxn3iPyIODud4RF7jbT"
            + "9GcHhZvNa9Rvlmblxv4sSp12Gopl9/cQ8qsSWmyrm0ouvOEXK0kyDyLwDczTI9dSi"
            + "Q10WBS5IvwNoi/DsApt3ZegUKj7l6Io2A==";
    
    private String selloSAT = "wUjdXqPm1I5AOBKtMjp627XZUh9n4SYvCjQ5GH+yhp+nziqpt"
            + "H1ySxsi4GXRNNXS2/47cFImb/uyQ8ElWnRP1YghqPQrw505VrJEX2hi+1ER+KIabK"
            + "ZaknMeh14B7onIiFtP2W/YasyH57yuyEC0Xr0gVExw5QEFv1nxhAvgn4o=";
    /**
     * Test of Serialize method, of class Util.
     * Should be able to convert Comprobante object to xml String
     */
    @Test
    public void testSerializeBaseInvoice() throws Exception{
        System.out.println("Serialize");
        String serie = "IN";
        String folio = "00001";
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = certificate;
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.createInstance(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);String rfc = "XAXX010101000";
        
        String nombre = "BestCompany S.A. de C.V.";
        String regimenFiscal = "601";
        Emisor issuer = Cfdi.createEmisor(rfc, regimenFiscal);
        issuer.setNombre(nombre);
        cfdi.setEmisor(issuer);
        
        String rfcReceiver = "XEXX010101000";
        String cfdiUse = "P01";
        String receiverName = "Receptor S.A de R.L.";
        Receptor receiver = Cfdi.createReceptor(rfcReceiver, cfdiUse);
        receiver.setNombre(receiverName);
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
        
        Concepto concepto = Cfdi.createConcepto(claveProdServ, cantidad, claveUnidad, descripcion, valorUnitario, importe);
        concepto.setUnidad(unidad);
        concepto.setNoIdentificacion(noIdentificacion);
        concepto.setDescuento(descuento);
        
        String impuesto = "002";
        String tipoFactor = "Tasa";
        BigDecimal base = new BigDecimal("568.97");
        BigDecimal importeImpuestoTraslado = new BigDecimal("91.03");
        BigDecimal tasaCuotaImpuestoTraslado = new BigDecimal("0.160000");
        TrasladoDetallado trasladoDetallado = Cfdi.createTrasladoConcepto(base, impuesto, tipoFactor);
        trasladoDetallado.setImporte(importeImpuestoTraslado);
        trasladoDetallado.setTasaOCuota(tasaCuotaImpuestoTraslado);
        concepto.getImpuestos().getTraslados().addTraslado(trasladoDetallado);
        
        BigDecimal retencionBase = new BigDecimal("10800.00");
        BigDecimal retencionTasaCuota = new BigDecimal("0.100000");
        BigDecimal retencionImporte = new BigDecimal("1080.00");
        String retencionImpuesto = "001";
        String retencionTipoFactor = "Tasa";
        
        RetencionDetallado retencion  = Cfdi.createRetencionConcepto(retencionImpuesto, retencionImporte, retencionBase, retencionTipoFactor, retencionTasaCuota);
        concepto.getImpuestos().getRetenciones().addRetencion(retencion);
        cfdi.getConceptos().addConcepto(concepto);
        
        BigDecimal totalTraslados = new BigDecimal("91.03");
        BigDecimal totalRetenciones = new BigDecimal("201.70");
        ResumenImpuestos resumenImpuestos = Cfdi.createResumenImpuestos(totalTraslados, totalRetenciones);
        
        BigDecimal importeResumenRetencion = new BigDecimal("201.70");
        Retencion resumenRetencion = new Retencion("001", importeResumenRetencion);
        resumenImpuestos.getRetenciones().addRetencion(resumenRetencion);
        
        BigDecimal importeResumenTraslado = new BigDecimal("201.70");
        BigDecimal tasaOCuotaResumenTraslado = new BigDecimal("0.160000");
        Traslado resumenTraslado = new Traslado("001", "Tasa", tasaOCuotaResumenTraslado, importeResumenTraslado);
        resumenImpuestos.getTraslados().addTraslado(resumenTraslado);
        
        cfdi.setImpuestos(resumenImpuestos);
        
        String result = Util.Serialize(cfdi);
        System.out.println(result);
        assertThat(result, not(emptyString()));
    }
        
    /**
     * Should be able to convert xml string to Comprobante Object
     */
    @Test
    public void testDeserialize() throws Exception{
        System.out.println("Deserialize");
        String serie = "IN";
        String folio = "00001";
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = certificate;
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.createInstance(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
        String xmlString = Util.Serialize(cfdi);
        
        Comprobante result = Util.Deserialize(xmlString);
        assertEquals(result.getSerie(), cfdi.getSerie());
        assertEquals(result.getFolio(), cfdi.getFolio());
        assertEquals(result.getFecha(), cfdi.getFecha());
        assertEquals(result.getNoCertificado(), cfdi.getNoCertificado());
        assertEquals(result.getCertificado(), cfdi.getCertificado());
        assertEquals(result.getMoneda(), cfdi.getMoneda());
        assertEquals(result.getTipoComprobante(), cfdi.getTipoComprobante());
        assertEquals(result.getLugarExpedicion(), cfdi.getLugarExpedicion());
    }
    
    @Test
    public void testDeserializeWithTFD() throws Exception{
        
        System.out.println("Deserialize With TFD");
        String serie = "IN";
        String folio = "00001";
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = certificate;
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Comprobante cfdi = Cfdi.createInstance(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);String rfc = "XAXX010101000";
        
        String nombre = "BestCompany S.A. de C.V.";
        String regimenFiscal = "601";
        Emisor issuer = Cfdi.createEmisor(rfc, regimenFiscal);
        issuer.setNombre(nombre);
        cfdi.setEmisor(issuer);
        
        String rfcReceiver = "XEXX010101000";
        String cfdiUse = "P01";
        String receiverName = "Receptor S.A de R.L.";
        Receptor receiver = Cfdi.createReceptor(rfcReceiver, cfdiUse);
        receiver.setNombre(receiverName);
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
        
        Concepto concepto = Cfdi.createConcepto(claveProdServ, cantidad, claveUnidad, descripcion, valorUnitario, importe);
        concepto.setUnidad(unidad);
        concepto.setNoIdentificacion(noIdentificacion);
        concepto.setDescuento(descuento);
        
        String impuesto = "002";
        String tipoFactor = "Tasa";
        BigDecimal base = new BigDecimal("568.97");
        BigDecimal importeImpuestoTraslado = new BigDecimal("91.03");
        BigDecimal tasaCuotaImpuestoTraslado = new BigDecimal("0.160000");
        TrasladoDetallado trasladoDetallado = Cfdi.createTrasladoConcepto(base, impuesto, tipoFactor);
        trasladoDetallado.setImporte(importeImpuestoTraslado);
        trasladoDetallado.setTasaOCuota(tasaCuotaImpuestoTraslado);
        concepto.getImpuestos().getTraslados().addTraslado(trasladoDetallado);
        
        BigDecimal retencionBase = new BigDecimal("10800.00");
        BigDecimal retencionTasaCuota = new BigDecimal("0.100000");
        BigDecimal retencionImporte = new BigDecimal("1080.00");
        String retencionImpuesto = "001";
        String retencionTipoFactor = "Tasa";
        
        RetencionDetallado retencion  = Cfdi.createRetencionConcepto(retencionImpuesto, retencionImporte, retencionBase, retencionTipoFactor, retencionTasaCuota);
        concepto.getImpuestos().getRetenciones().addRetencion(retencion);
        cfdi.getConceptos().addConcepto(concepto);
        
        BigDecimal totalTraslados = new BigDecimal("91.03");
        BigDecimal totalRetenciones = new BigDecimal("201.70");
        ResumenImpuestos resumenImpuestos = Cfdi.createResumenImpuestos(totalTraslados, totalRetenciones);
        
        BigDecimal importeResumenRetencion = new BigDecimal("201.70");
        Retencion resumenRetencion = new Retencion("001", importeResumenRetencion);
        resumenImpuestos.getRetenciones().addRetencion(resumenRetencion);
        
        BigDecimal importeResumenTraslado = new BigDecimal("201.70");
        BigDecimal tasaOCuotaResumenTraslado = new BigDecimal("0.160000");
        Traslado resumenTraslado = new Traslado("001", "Tasa", tasaOCuotaResumenTraslado, importeResumenTraslado);
        resumenImpuestos.getTraslados().addTraslado(resumenTraslado);
        cfdi.setImpuestos(resumenImpuestos);
        
        
        XMLGregorianCalendar fechaTimbrado = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        TimbreFiscalDigital tfd = Cfdi.createTimbreFiscalDigital("342854F8-94D3-40CA-8797-B01FA0D42076", fechaTimbrado, 
                "AAA010101AAA", selloCFD, "20001000000100005761", selloSAT);
        
        cfdi.getComplemento().setTfd(tfd);
        String xmlString = Util.SerializeWithTFD(cfdi);
        System.out.println(xmlString);
        
        Comprobante result = Util.Deserialize(xmlString);
        assertEquals(result.getSerie(), cfdi.getSerie());
        assertEquals(result.getFolio(), cfdi.getFolio());
        assertEquals(result.getFecha(), cfdi.getFecha());
        assertEquals(result.getNoCertificado(), cfdi.getNoCertificado());
        assertEquals(result.getCertificado(), cfdi.getCertificado());
        assertEquals(result.getMoneda(), cfdi.getMoneda());
        assertEquals(result.getTipoComprobante(), cfdi.getTipoComprobante());
        assertEquals(result.getLugarExpedicion(), cfdi.getLugarExpedicion());
        assertEquals(result.getComplemento().getTfd().getUuid(), "342854F8-94D3-40CA-8797-B01FA0D42076");
        assertEquals(result.getComplemento().getTfd().getFechaTimbrado(), fechaTimbrado);
        assertEquals(result.getComplemento().getTfd().getRfcProvCertif(), "AAA010101AAA");
        assertEquals(result.getComplemento().getTfd().getSelloCFD(), selloCFD);
        assertEquals(result.getComplemento().getTfd().getNoCertificadoSAT(), "20001000000100005761");
        assertEquals(result.getComplemento().getTfd().getSelloSAT(), selloSAT);
    }
}
