/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.encrypt;


import java.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Signature;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.security.cert.X509Certificate;
import javax.security.cert.CertificateException;
import org.apache.commons.ssl.PKCS8Key;

/**
 *
 * @author ignis
 */
public class Encryption {

    public static X509Certificate readCertificate(InputStream certificate) {
        X509Certificate cert = null;
        try {
            byte[] bytesArray = new byte[(int) certificate.available()];
            certificate.read(bytesArray);
            certificate.close();
            cert = readCertificate(bytesArray);
        } catch (IOException error) {
            error.printStackTrace();
        }

        return cert;
    }

    public static X509Certificate readCertificate(byte[] bytes) {

        X509Certificate cert = null;
        try {
            cert = X509Certificate.getInstance(bytes);
        } catch (CertificateException error) {
            error.printStackTrace();
        }
        return cert;
    }

    public static String toBase64(byte[] bytes) {
        String data = null;
        try {
            data = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return data;
    }

    public static PrivateKey readPrivateKey(InputStream key, String password) throws Exception {
        PrivateKey privateKey = null;
        try {
            PKCS8Key pkcs8 = new PKCS8Key(key, password.toCharArray());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(pkcs8.getDecryptedBytes());
            privateKey = keyFactory.generatePrivate(spec);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return privateKey;
    }

    public static String signSHA256RSA(String chain, PrivateKey privateKey) {
        String chainEncrypted = null;
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(chain.getBytes("UTF-8"));
            byte[] encrypted = signature.sign();
            chainEncrypted = toBase64(encrypted);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | SignatureException error) {
            error.printStackTrace();
        }
        return chainEncrypted;
    }
}
