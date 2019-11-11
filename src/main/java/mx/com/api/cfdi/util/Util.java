/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.cfdi.util;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


import mx.com.api.cfdi.config.XSD;
import mx.com.api.cfdi.Comprobante;
import mx.com.api.cfdi.complemento.tfd.TimbreFiscalDigital;
/**
 *
 * @author ignis
 */
public class Util {
    
    public static String Serialize(Comprobante cfdi) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(Comprobante.class);
            Marshaller marshaller = context.createMarshaller();
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XSD.CFDI_SCHEMALOCATION);
            StringWriter sw = new StringWriter();
            marshaller.marshal(cfdi, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return xmlString;
    }
    
    public static String SerializeWithTFD(Comprobante cfdi){
        String xmlString = "";
        try{
            JAXBContext context = JAXBContext.newInstance(Comprobante.class, TimbreFiscalDigital.class);
            Marshaller marshaller = context.createMarshaller();
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XSD.CFDI_SCHEMALOCATION);
            StringWriter sw = new StringWriter();
            marshaller.marshal(cfdi, sw);
            xmlString = sw.toString();
        }catch(JAXBException e){
            e.printStackTrace();
        }
        
        return cleanCfdiXML(xmlString);
     }
    
    public static Comprobante Deserialize(String xml) {
        try {
            JAXBContext context = JAXBContext.newInstance(Comprobante.class, TimbreFiscalDigital.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            StringReader reader = new StringReader(xml);
            Comprobante cfdi = (Comprobante) unmarshaller.unmarshal(reader);
            
            return cfdi;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static String cleanCfdiXML(String xml){
        return xml.replaceFirst("xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\"", "");
    }
}
