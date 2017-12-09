/*
 *  Implementation Author: fullarray
 *  Description: This program was built using the following Java version:	
 *               java version "1.8.0_141"
 *	             Java(TM) SE Runtime Environment (build 1.8.0_141-b15)
 *	             Java HotSpot(TM) 64-Bit Server VM (build 25.141-b15, mixed mode)
 *
 */

import java.math.*;
import java.util.*;
import java.lang.String;
import java.security.*;
import java.io.*;

public class elGamaImplementation
{
		
    public static void main(String[] args) throws IOException
    {
        BigInteger privateKey;
        Random sc = new SecureRandom();
        
		// Get key size from user.
		System.out.print("Enter your key size: E.g. 64. 128, 256, etc.\n");
	    int keySize = elGamaImplementation.GetInt();
		while(keySize != 64 && keySize != 128 && keySize != 256){
			System.out.println("Please enter a correct bit size. For example: 64, 128, 256.");
			System.out.println("Try again.\n");
			System.out.print("Enter your key size: E.g. 64. 128, 256, etc.\n");
	        keySize = elGamaImplementation.GetInt();
		}
		
		
		// For this example, private key is created randomly
		privateKey = new BigInteger(keySize,sc);
        System.out.println("Generated private key: \n" + privateKey +"\n");
		
		//ElGama 
		ProcessAlgorithm(keySize, sc, privateKey);
		
    }
	
	public static void ProcessAlgorithm(int keySize, Random rand, BigInteger privateKey ) throws IOException{
		
		//Variables
		BigInteger alpha, beta, c; 
		 
		/* 
		 *  Based on key bit size, define a large prime number 
		 *  as well as generate public key.
         */
		alpha = BigInteger.probablePrime(keySize, rand);
        beta = new BigInteger(keySize, rand);
        c = beta.modPow(privateKey, alpha);
        System.out.println("alpha: \n" + alpha );
        System.out.println("beta: \n" + beta );
        System.out.println("c: \n" + c +"\n");
		
		
        // Get plain text
        System.out.print("Enter plain text message: E.g. 2345245245425 \n");
        String s = elGamaImplementation.GetString();
		
		 // Process encryption
        BigInteger x = new BigInteger(s);
        BigInteger r = new BigInteger(keySize, rand);
        BigInteger EC = x.multiply(c.modPow(r, alpha)).mod(alpha);
        BigInteger brmodp = beta.modPow(r, alpha);
        System.out.println("Plaintext: \n" + x + "\n\n");
		
		System.out.println("Initializing keys and encrypting.");
		System.out.println("-----------------------");
        System.out.println("r Value: \n" + r);
        System.out.println("EC Value: \n" + EC);
        System.out.println("Encrypted: \n" + brmodp +"\n\n");
        
        // Process decryption
        BigInteger crmodp = brmodp.modPow(privateKey, alpha);
        BigInteger d = crmodp.modInverse(alpha);
        BigInteger ad = d.multiply(EC).mod(alpha);
		
		System.out.println("Calculating new keys and performing decryption. ");
		System.out.println("-----------------------");
        System.out.println("d Value: \n" + crmodp);
        System.out.println("Ad Value: \n" + d);
        System.out.println("Original plain text Message: \n" + ad + "\n");
	}
	
	 public static String GetString() throws IOException {
      BufferedReader stringIn = new BufferedReader (new InputStreamReader(System.in));
      return  stringIn.readLine();
     }

     public  static  int  GetInt( ) throws IOException {
       String aux = GetString();
       return Integer.parseInt(aux);
    }
}