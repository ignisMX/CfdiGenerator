/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.utilities.test;

import mx.com.api.cfdi.Comprobante;
import mx.com.api.stamp.Cfdi;
import mx.com.api.utilities.Util;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


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
    

    /**
     * Test of Serialize method, of class Util.
     * Should be able to convert Comprobante object to xml String
     */
    @Test
    public void testSerialize() throws Exception{
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
        Cfdi instance = new Cfdi();
        Comprobante cfdi = instance.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
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
        Date today = new Date();
        XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        String numeroCertificado = "30001000000300023708";
        String certificado = certificate;
        String moneda = "MXN";
        String tipoComprobante = "I";
        String lugarExpedicion = "14139";
        Cfdi instance = new Cfdi();
        Comprobante cfdi = instance.NewCfdi(serie, folio, fecha, numeroCertificado, certificado, moneda, tipoComprobante, lugarExpedicion);
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
    
}
