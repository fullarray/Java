import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DESShorterVersion {
  public static void main(String args[]) throws Exception {
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    SecretKey key = KeyGenerator.getInstance("DES").generateKey();

    // for CBC; must be 8 bytess
    byte[] initVector = new byte[] { 0x10, 0x10, 0x01, 0x04, 0x01, 0x01, 0x01, 0x02 };

    AlgorithmParameterSpec algParamSpec = new IvParameterSpec(initVector);
    Cipher m_encrypter = Cipher.getInstance("DES/CBC/PKCS5Padding");
    Cipher m_decrypter = Cipher.getInstance("DES/CBC/PKCS5Padding");

    m_encrypter.init(Cipher.ENCRYPT_MODE, key, algParamSpec);
    m_decrypter.init(Cipher.DECRYPT_MODE, key, algParamSpec);

    byte[] clearText = "www.herrj.com".getBytes();

    byte[] encryptedText = m_encrypter.doFinal(clearText);

    byte[] decryptedText = m_decrypter.doFinal(encryptedText);

    System.out.println(new String(clearText));
    System.out.println(new String(encryptedText));
    System.out.println(new String(decryptedText));

  }

}
