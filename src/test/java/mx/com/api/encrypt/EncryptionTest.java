/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.encrypt;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.PrivateKey;
import javax.security.cert.X509Certificate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 *
 * @author ignis
 */

public class EncryptionTest {
    
    private static final String CER_PATH = "src/test/resources/CSD_Escuela_Kemper_Urgate_EKU9003173C9_20190617_131753s.cer";
    private static final String KEY_PATH = "src/test/resources/CSD_Escuela_Kemper_Urgate_EKU9003173C9_20190617_131753.key";
    
    /**
    * Should be able to read certificate CSD. 
    */
    @Test
    public void testReadCertificate() throws Exception{
        InputStream file = new FileInputStream(CER_PATH);
        X509Certificate certificate = Encryption.readCertificate(file);
        assertNotNull(certificate);
    }
    
    /**
     * Should be able to read certificate CSD and convert to String base64.
     */
    @Test
    public void testReadCertificateAsString() throws Exception{
        InputStream file = new FileInputStream(CER_PATH);
        X509Certificate certificate = Encryption.readCertificate(file);
        String seal = Encryption.toBase64(certificate.getEncoded());
        assertThat(seal, not(emptyString()));
    }
    
    /**
     * Should be able to read private key.
     */
    @Test
    public void testReadPrivateKey() throws Exception{
        InputStream file = new FileInputStream(KEY_PATH);
        PrivateKey key = Encryption.readPrivateKey(file, "12345678a");
        assertNotNull(key);
    }
    
    /**
     *  Should be able to read private key and convert to String base64. 
     */
    @Test
    public void testReadPrivateKeyAsString() throws Exception{
        InputStream file = new FileInputStream(KEY_PATH);
        PrivateKey key = Encryption.readPrivateKey(file, "12345678a");
        String keyString = Encryption.toBase64(key.getEncoded());
        assertThat(keyString, not(emptyString()));
    }
}
