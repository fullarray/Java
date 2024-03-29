/*
	Create by Jonathan H. and fullarray
*/
import java.util.Base64;
/*import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;*/
import java.io.*;
import java.util.*;
import java.nio.*;

public class DESImplementation {
	/* Initial Permutation */
	static final int[] IP = {
		58, 50, 42, 34, 26, 18, 10, 2,
		60, 52, 44, 36, 28, 20, 12, 4,
		62, 54, 46, 38, 30, 22, 14, 6,
		64, 56, 48, 40, 32, 24, 16, 8,
		57, 49, 41, 33, 25, 17,  9, 1,
		59, 51, 43, 35, 27, 19, 11, 3,
		61, 53, 45, 37, 29, 21, 13, 5,
		63, 55, 47, 39, 31, 23, 15, 7
	};
	/* Inverse Initial Permutation */
	static final int[] IIP = {
		40, 8, 48, 16, 56, 24, 64, 32,
		39, 7, 47, 15, 55, 23, 63, 31,
		38, 6, 46, 14, 54, 22, 62, 30,
		37, 5, 45, 13, 53, 21, 61, 29,
		36, 4, 44, 12, 52, 20, 60, 28,
		35, 3, 43, 11, 51, 19, 59, 27,
		34, 2, 42, 10, 50, 18, 58, 26,
		33, 1, 41,  9, 49, 17, 57, 25
	};
	/* Expansion Permutation */
	static final int[] E = {
		32,  1,  2,  3,  4,  5,
		4,  5,  6,  7,  8,  9,
		8,  9, 10, 11, 12, 13,
		12, 13, 14, 15, 16, 17,
		16, 17, 18, 19, 20, 21,
		20, 21, 22, 23, 24, 25,
		24, 25, 26, 27, 28, 29,
		28, 29, 30, 31, 32,  1
	};
	/* Permutation Function */
	static final int[] P = {
		16,  7, 20, 21,
		29, 12, 28, 17,
		1, 15, 23, 26,
		5, 18, 31, 10,
		2,  8, 24, 14,
		32, 27,  3,  9,
		19, 13, 30,  6,
		22, 11,  4, 25
	};
	/* S-Boxes*/
	static final int[] S1 = {
		14,  4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7,
		 0, 15,  7,  4, 14,  2, 13,  1, 10,  6, 12, 11,  9,  5,  3,  8,
		 4,  1, 14,  8, 13,  6,  2, 11, 15, 12,  9,  7,  3, 10,  5,  0,
		15, 12,  8,  2,  4,  9,  1,  7,  5, 11,  3, 14, 10,  0,  6, 13
	};
	static final int[] S2 = {
		15,  1,  8, 14,  6, 11,  3,  4,  9,  7,  2, 13, 12,  0,  5, 10,
		 3, 13,  4,  7, 15,  2,  8, 14, 12,  0,  1, 10,  6,  9, 11,  5,
		 0, 14,  7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15,
		13,  8, 10,  1,  3, 15,  4,  2, 11,  6,  7, 12,  0,  5, 14,  9
	};
	static final int[] S3 = {
		10,  0,  9, 14,  6,  3, 15,  5,  1, 13, 12,  7, 11,  4,  2,  8,
		13,  7,  0,  9,  3,  4,  6, 10,  2,  8,  5, 14, 12, 11, 15,  1,
		13,  6,  4,  9,  8, 15,  3,  0, 11,  1,  2, 12,  5, 10, 14,  7,
		 1, 10, 13,  0,  6,  9,  8,  7,  4, 15, 14,  3, 11,  5,  2, 12
	};
	static final int[] S4 = {
		 7, 13, 14,  3,  0,  6,  9, 10,  1,  2,  8,  5, 11, 12,  4, 15,
		13,  8, 11,  5,  6, 15,  0,  3,  4,  7,  2, 12,  1, 10, 14,  9,
		10,  6,  9,  0, 12, 11,  7, 13, 15,  1,  3, 14,  5,  2,  8,  4,
		 3, 15,  0,  6, 10,  1, 13,  8,  9,  4,  5, 11, 12,  7,  2, 14
	};
	static final int[] S5 = {
		 2, 12,  4,  1,  7, 10, 11,  6,  8,  5,  3, 15, 13,  0, 14,  9,
		14, 11,  2, 12,  4,  7, 13,  1,  5,  0, 15, 10,  3,  9,  8,  6,
		 4,  2,  1, 11, 10, 13,  7,  8, 15,  9, 12,  5,  6,  3,  0, 14,
		11,  8, 12,  7,  1, 14,  2, 13,  6, 15,  0,  9, 10,  4,  5,  3
	};
	static final int[] S6 = {
		12,  1, 10, 15,  9,  2,  6,  8,  0, 13,  3,  4, 14,  7,  5, 11,
		10, 15,  4,  2,  7, 12,  9,  5,  6,  1, 13, 14,  0, 11,  3,  8,
		 9, 14, 15,  5,  2,  8, 12,  3,  7,  0,  4, 10,  1, 13, 11,  6,
		 4,  3,  2, 12,  9,  5, 15, 10, 11, 14,  1,  7,  6,  0,  8, 13
	};
	static final int[] S7 = {
		 4, 11,  2, 14, 15,  0,  8, 13,  3, 12,  9,  7,  5, 10,  6,  1,
		13,  0, 11,  7,  4,  9,  1, 10, 14,  3,  5, 12,  2, 15,  8,  6,
		 1,  4, 11, 13, 12,  3,  7, 14, 10, 15,  6,  8,  0,  5,  9,  2,
		 6, 11, 13,  8,  1,  4, 10,  7,  9,  5,  0, 15, 14,  2,  3, 12
	};
	static final int[] S8 = {
		13,  2,  8,  4,  6, 15, 11,  1, 10,  9,  3, 14,  5,  0, 12,  7,
		 1, 15, 13,  8, 10,  3,  7,  4, 12,  5,  6, 11,  0, 14,  9,  2,
		 7, 11,  4,  1,  9, 12, 14,  2,  0,  6, 10, 13, 15,  3,  5,  8,
		 2,  1, 14,  7,  4, 10,  8, 13, 15, 12,  9,  0,  3,  5,  6, 11
	};
	/* Permuted Choice One */
	static final int[] PC1 = {
		57, 49, 41, 33, 25, 17,  9,
		 1, 58, 50, 42, 34, 26, 18,
		10,  2, 59, 51, 43, 35, 27,
		19, 11,  3, 60, 52, 44, 36,
		63, 55, 47, 39, 31, 23, 15,
		 7, 62, 54, 46, 38, 30, 22,
		14,  6, 61, 53, 45, 37, 29,
		21, 13,  5, 28, 20, 12,  4
	};
	/* Permuted Choice Two */
	static final int[] PC2 = {
		14, 17, 11, 24,  1,  5,
		 3, 28, 15,  6, 21, 10,
		23, 19, 12,  4, 26,  8,
		16,  7, 27, 20, 13,  2,
		41, 52, 31, 37, 47, 55,
		30, 40, 51, 45, 33, 48,
		44, 49, 39, 56, 34, 53,
		46, 42, 50, 36, 29, 32
	};
	/* Schedule of Left Shifts */
	static final int[] SHIFTS = {
		1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
	};
	
	public DESImplementation() {		
	}
	
	private byte[] performXOR(byte[] one, byte[] two) {
		byte[] result = new byte[one.length];
		for (int i = 0 ; i < one.length ; i++) {
			result[i] = (byte) (one[i] ^ two[i]);
		}
		return result;
	}
	
	private byte[] permute(byte[] input, int[] mapping) {
		int byteCount = 1 + (mapping.length - 1) / 8;
		byte[] output = new byte[byteCount];
		int pos;
		
		for (int i = 0 ; i < mapping.length ; i++) {
			pos = mapping[i] - 1;
			int value = getBitFromArray(input, pos);
			setBitInArray(output, i, value);
		}		
		return output;
	}	

	private int getBitFromArray(byte[] array, int pos) {
		int value;
		int bytePos = pos / 8;
		int bitPos = pos % 8;		
		value = (array[bytePos] >> (8 - (bitPos + 1))) & 0x0001;		
		/* eg: right shift selected byte 5 times to get 3rd bit 
		 * (bitPos = 2) at rightmost position and 
		 * then AND with 0x0001*/
		return value;
	}
	
	private void setBitInArray(byte[] input, int pos, int value) {
		int bytePos = pos / 8;
		int bitPos = pos % 8;		
		byte old = input[bytePos];
		old = (byte) (((0xFF7F >> bitPos) & old) & 0x00FF);
		byte newByte = (byte) ((value << (8 - (bitPos + 1))) | old);
	    input[bytePos] = newByte;
	}
	
	private byte[] hexStringToByteArray(String string) {
		int length = string.length();
		int n = (int)Math.ceil((length + 1) / 2);
		byte[] result = new byte[n];		
		for (int i = length - 1; i >= 0 ; i -= 2) {	
			if (i == 0) {
				result[i / 2] = (byte) ((Character.digit('0', 16) << 4)
						+ Character.digit(string.charAt(i), 16));
			} else {
				result[i / 2] = (byte) ((Character.digit(string.charAt(i - 1), 16) << 4)
					+ Character.digit(string.charAt(i), 16));
			}
		}
		return result;
	}
	
	private void printBytes(byte[] input) {		
		String str ="";
		//byte[] bytes = input.getBytes();
		//String s = new String(bytes);
		
		for (int i = 0 ; i < input.length; i++) {
			//System.out.print(byteToBits(input[i]) + " ");
			str = byteToBits(input[i]);
			
			System.out.print(binaryToInt(str) + " ");
		}
		
		System.out.println();
	}
	
	public static String bytesToAlphabeticString(byte[] bytes) {
		CharBuffer cb = ByteBuffer.wrap(bytes).asCharBuffer();
		return cb.toString();
	}
	
	public static int binaryToInt(String binary)
	{
		return Integer.parseInt(binary,2);
	}
	
	public static String bytesToHex(byte[] in) {
		final StringBuilder builder = new StringBuilder();
		for(byte b : in) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
	
	
	public String experiment(String message){
		//String text = "This is an example é";
		
		//String originalString ="";
		/*try {
			byte[] byteText = text.getBytes("UTF-8");
			originalString = new String(byteText , "UTF-8");
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return originalString;
		
		
		try{
			byte[] dec = Base64.getEncoder().encode(text.getBytes());
			byte[] decs = Base64.getDecoder().decode(dec);
			
			String some = new String(decs, "ASCII");
			originalString = some;
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}

		// Decode using utf-8
		return originalString;*/
		
		//String s = "0110100001100101011011000110110001101111";
		//String str = "";

		 //Check to make sure that the message is all 1s and 0s.
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) != '1' && message.charAt(i) != '0') {
				return null;
			}
		}

		//If the message does not have a length that is a multiple of 8, we can't decrypt it
		if(message.length() % 8 != 0) {
			return null;
		}

		//Splits the string into 8 bit segments with spaces in between
		String returnString = "";
		String decrypt = "";
		for(int i = 0; i < message.length() - 7; i += 8) {
			decrypt += message.substring(i, i + 8) + " ";
		}

		//Creates a string array with bytes that represent each of the characters in the message
		String[] bytes = decrypt.split(" ");
		for(int i = 0; i < bytes.length; i++) {
			//Decrypts each character and adds it to the string to get the original message
			returnString += (char)Integer.parseInt(bytes[i], 2);
		}

		return returnString;
		
	}
	
	public static String int2str( String t ) { 
		/*
		String input = t;
		String output = "";
		for(int i = 0; i <= input.length() - 8; i+=8)
		{
			int k = Integer.parseInt(input.substring(i, i+8), 2);
			output += (char) k;
		}   
		return output;*/
		
		
		StringBuilder sb = new StringBuilder();
	    StringBuilder temp = new StringBuilder();
	  
	  //49204c6f7665204a617661 split into two characters 49, 20, 4c...
	  for( int i=0; i<t.length()-1; i+=2 ){
		  
	      //grab the hex in pairs
	      String output = t.substring(i, (i + 2));
	      //convert hex to decimal
	      int decimal = Integer.parseInt(output, 16);
	      //convert the decimal to character
	      sb.append((char)decimal);
		  
	      temp.append(decimal);
	  }
	  System.out.println("Decimal : " + temp.toString());
	  
	  return sb.toString();	
	} 
	
	private String byteToBits(byte b) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0 ; i < 8 ; i++)
			buffer.append((int)(b >> (8-(i+1)) & 0x0001));
		    
		return buffer.toString();
	}

	private byte[] getBits(byte[] input, int startPos, int length) {
		int noOfBytes = (length-1)/8 + 1;
		byte[] output = new byte[noOfBytes];
		for (int i = 0 ; i < length ; i++) {
			int value = getBitFromArray(input, startPos + i);
			setBitInArray(output, i, value);
		}
		return output;
	}	
	
	private byte[] rotateLeft(byte[] input, int step, int length) {		
		int noOfBytes = (length - 1) / 8 + 1;
		byte[] output = new byte[noOfBytes];
		for (int i = 0 ; i < length ; i++) {
			int value = getBitFromArray(input, (i + step) % length);
			setBitInArray(output, i, value);
		}
		return output;
	}
	
	private byte[] concatBits(byte[] one, int oneLength, 
			byte[] two, int twoLength) {
		int noOfBytes = (oneLength + twoLength - 1) / 8 + 1;
		byte[] output = new byte[noOfBytes];
		int i = 0, j = 0;
		for (; i < oneLength ; i++) {
			int value = getBitFromArray(one, i);
			setBitInArray(output, j, value);
			j++;
		}		
		for (i = 0 ; i < twoLength ; i++) {
			int value = getBitFromArray(two, i);
			setBitInArray(output, j, value);
			j++;
		}
		return output;
	}
	
	private byte[][] getSubKeys(byte[] masterKey) {
		int noOfSubKeys = SHIFTS.length;
		int keySize = PC1.length;
		byte[] key = permute(masterKey, PC1);
		byte[][] subKeys = new byte[noOfSubKeys][keySize];
		byte[] leftHalf = getBits(key, 0, keySize/2);
		byte[] rightHalf = getBits(key, keySize/2, keySize/2);
		for (int i = 0 ; i < noOfSubKeys ; i++) {
			leftHalf = rotateLeft(leftHalf, SHIFTS[i], keySize/2);
			rightHalf = rotateLeft(rightHalf, SHIFTS[i], keySize/2);
			byte[] subKey = concatBits(leftHalf, keySize/2, rightHalf, keySize/2);
			subKeys[i] = permute(subKey, PC2); 
		}
		return subKeys;
	}
	
	public byte[] crypt(byte[] message, byte[] key, String operation) {
		if (message.length < 8) {
			System.out.println("Message should be atleast 64 bits");
			System.exit(1);
		}
		if (key.length != 8) {
			System.out.println("Key should be 64 bits");
			System.exit(1);
		}
		int length = message.length;
		int n = (length + 7)/8 * 8;
		byte[] cipher = new byte[n];
		if (length == 8) {
			return cryptText(message, key, operation);
		}
		int i = 0;
		int k = 0;
		while (i < length) {
			byte[] block = new byte[8];
			byte[] result = new byte[8];
			int j = 0;
			for (; j < 8 && i < length; j++, i++) {
				block[j] = message[i];
			}
			while (j < 8) {
				block[j++] = 0x00;
			}
			System.out.println("BLOCK: ");
			printBytes(block);			
			result = cryptText(block, key, operation);
			System.out.println("RESULT: ");
			printBytes(result);
			for (j = 0 ; j < 8 && k < cipher.length; j++, k++) {
				cipher[k] = result[j];
			}
		}
		return cipher;		
	}
	
	public byte[] cryptText(byte[] message, byte[] key, String operation) {
		if (message.length != 8) {
			System.out.println("Message should be 64 bits");
			System.exit(1);
		}
		if (key.length != 8) {
			System.out.println("Key should be 64 bits");
			System.exit(1);
		}
		byte[] result = null;
		int blockSize = IP.length;
		byte[][] subKeys = getSubKeys(key);
		int noOfRounds = subKeys.length;
		/**
		 * Initial Permutation
		 */
		message = permute(message, IP);
		/**
		 * Split message into two halves
		 */
		byte[] leftHalf = getBits(message, 0, blockSize/2);
		byte[] rightHalf = getBits(message, blockSize/2, blockSize/2);
		for (int i = 0 ; i < noOfRounds ; i++) {
			byte[] temp = rightHalf;
			/**
			 * Expansion
			 */
			rightHalf = permute(rightHalf, E);
			/**
			 * XOR rightHalf with roundKey
			 */
			byte[] roundKey = null;
			if (operation.equalsIgnoreCase("encrypt")) {
				roundKey = subKeys[i];
			} else if (operation.equalsIgnoreCase("decrypt")) {
				roundKey = subKeys[noOfRounds - i - 1];
			} else {
				System.out.println("Unsupported operation");
				System.exit(0);
			}
			rightHalf = performXOR(rightHalf, roundKey);
			/**
			 * S-Box
			 */
			rightHalf = sBox(rightHalf);
			/**
			 * Permutation
			 */
			rightHalf = permute(rightHalf, P);
			/**
			 * XOR rightHalf with leftHalf
			 */
			rightHalf = performXOR(rightHalf, leftHalf);
			/**
			 * L(i) = R(i-1)
			 */
			leftHalf = temp;
		}
		/**
		 * 32 bit swap
		 */
		byte[] concatHalves = concatBits(rightHalf, blockSize/2, leftHalf, blockSize/2);
		/**
		 * Inverse Initial Permutation
		 */
		result = permute(concatHalves, IIP);
		return result;
	}
	
	private byte[] sBox(byte[] input) {		
		/**
		 * Split input to 6-bit blocks
		 */
		input = split(input,6);
		byte[] output = new byte[input.length/2];
		int leftHalf = 0;		
		for (int i = 0; i < input.length ; i++) {
			byte block = input[i];			
			/**
			 * row - first and last bits
			 * column - 4 bits in the middle
			 */
			int row = 2 * (block >> 7 & 0x0001) + (block >> 2 & 0x0001);
			int col = block >> 3 & 0x000F;
			int[] selectedSBox = getSBox(i);
			int rightHalf = selectedSBox[16 * row + col];
			if (i % 2 == 0) {
				leftHalf = rightHalf;
			} else {
				output[i/2] = (byte) (16 * leftHalf + rightHalf);
				leftHalf = 0;
			}
		}
		return output;
	}

	private int[] getSBox(int i) {
		switch (i) {
			case 0: return S1;
			case 1: return S2;
			case 2: return S3;
			case 3: return S4;
			case 4: return S5;
			case 5: return S6;
			case 6: return S7;
			case 7: return S8;	
			default: return null;			
		}
	}

	private byte[] split(byte[] input, int length) {
		int noOfBytes = (8 * input.length - 1) / length + 1;
		byte[] output = new byte[noOfBytes];
		for (int i = 0 ; i < noOfBytes ; i++) {
			for (int j = 0; j < length ; j++) {
				int value = getBitFromArray(input, length * i + j);				
				setBitInArray(output, 8 * i + j, value);
			}
		}
		return output;
	}

	public static void main(String[] args){
		DESImplementation des = new DESImplementation();		
		
		Scanner in = new Scanner(System.in);
		String smessage, key_string;
				
		System.out.println("Enter your message:");
		smessage = in.nextLine();
		//smessage = "Hello world";
		//byte[] message = des.hexStringToByteArray("123456789ABCDEF");
		//byte[] message = des.hexStringToByteArray(smessage);
		byte[] message = smessage.getBytes();
		System.out.println("Plain text:");
		   String s = new String(message);
		    System.out.println(s);
		//String s = new String(message);
		//String s = Base64.getEncoder().encodeToString(message);
		
		
		des.printBytes(message);
		//int decimal = Integer.parseInt(des.printBytes(message), 2);
		//String s = Integer.toString(des.printBytes(message), 16);
		//System.out.println(s +" \n");
		
		
		System.out.println("Enter your key: It's eigth characters long.");
		key_string = in.nextLine();
		while(key_string.length() != 8){
			System.out.println("Woah!. You entered more or less than 8 characters.");
			System.out.println("Please try again.");
			key_string = in.nextLine();
		}
		String skey = key_string+"BBAFCDF1";
		System.out.println(skey);
		//byte[] key =  des.hexStringToByteArray("133457799BBCDFF1");
		byte[] key =  des.hexStringToByteArray(skey);
		//byte[] key =  skey.getBytes();
		//byte[] key =  Base64.getEncoder().encode(skey.getBytes());
		System.out.println("Key:");
		String s2 = new String(key, "UTF-8");
		System.out.println(s2);
		//des.printBytes(key);
		
		byte[] cipher = des.crypt(message, key, "encrypt");
		System.out.println("Cipher Text:");
		String s3 = new String(cipher);
		System.out.println(s3);
		//des.printBytes(cipher);
		
		byte[] result = des.crypt(cipher, key, "decrypt");
		System.out.println("Decrypted Text:");
		String s4 = new String(result);
		System.out.println(s4);
		//des.printBytes(result);
	}
		
}
