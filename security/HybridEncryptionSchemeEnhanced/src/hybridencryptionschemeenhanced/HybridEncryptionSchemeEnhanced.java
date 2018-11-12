/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/***
  * Bouncy castle needs to be downloaded first and imported like below.
**/
package hybridencryptionschemeenhanced;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 *
 * @author swb
 */
public class HybridEncryptionSchemeEnhanced {

    /**
     * @param args the command line arguments
     */

    // declaring asymmetric algorithms
    public static String asymmetricKeyAlgorithm = "RSA" ;
    public static String asymmetricAlgorithm = "RSA/NONE/OAEPWithSHA1AndMGF1Padding" ;
    public static int asymmetricKeyAlgorithmStrength = 1024;
    public static String signAlgorithm = "SHA1WithRSAEncryption" ;
  
    // declaring symmetric algorithms
    public static String symmetricKeyAlgorithm = "RIJNDAEL" ;
    public static String symmetricAlgorithm = "RIJNDAEL" ;
    public static int symmetricAlgorithmStrength = 128 ;
        
    //Helper class to encrypt message using symmetric algorithm
    public static byte[] encrypt(byte[] toEncrypt, SecretKey key) throws GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(symmetricAlgorithm) ;
        cipher.init(Cipher.ENCRYPT_MODE, key) ;
        byte[] result = cipher.doFinal(toEncrypt) ;
        return result ;
    }
    
    //Helper class to encrypt message using asymmetric algorithm
    public static byte[] encrypt(byte[] toEncrypt, PublicKey key) throws GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(asymmetricAlgorithm) ;
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] result = cipher.doFinal(toEncrypt);
        return result ;
    }
    
    //Helper class to decrypt message using symmetric algorithm
    public static byte[] decrypt(byte[] toDecrypt, SecretKey key) throws GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());
        Cipher deCipher = Cipher.getInstance(symmetricAlgorithm) ;
        deCipher.init(Cipher.DECRYPT_MODE, key) ;
        byte[] result = deCipher.doFinal(toDecrypt) ;
        return result ;
    }
    
    //Helper class to decrypt message using asymmetric algorithm
    public static byte[] decrypt(byte[] toDecrypt, PrivateKey key) throws GeneralSecurityException {
        Security.addProvider(new BouncyCastleProvider());
        Cipher deCipher = Cipher.getInstance(asymmetricAlgorithm) ;
        deCipher.init(Cipher.DECRYPT_MODE, key) ;
        byte[] result = deCipher.doFinal(toDecrypt) ;
        return result ;
    }
    
}
