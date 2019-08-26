/*
	Created by Jonathan H.  and fullarray 2017 using open source technology.
*/

import java.io.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



public class DESImplementation4 extends JFrame {
	
	 JLabel labelUsername = new JLabel("Message: ");
	 JLabel labelKey = new JLabel("Key: ");
	 JLabel	labelCypher = new JLabel("Cypher: ");
	 JLabel labelPlain = new JLabel("Decrypted Message: ");
	 JLabel labelError = new JLabel("Error. Press Process button again.");
	 
	 JTextField textUsername = new JTextField(50);
	 JTextField textKey = new JTextField(7);
	 
	 JTextField textCypher = new JTextField(50);
	 
	 JTextField textPlain = new JTextField(50);
	 
	 JButton buttonLogin = new JButton("Process DES");
	 JButton buttonCancel = new JButton("Cancel");
	 	
	public DESImplementation4() {
		
		super("DES Algorithm Implementation by Jonathan"); // This is changed from turned in paper
		
		textCypher.setEnabled(false);
	    textPlain.setEnabled(false);
		labelError.setVisible(false);
				
		// create a new panel with GridBagLayout manager
		JPanel newPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add components to the panel
		constraints.gridx = 0;
		constraints.gridy = 0;		
		newPanel.add(labelUsername, constraints);

		constraints.gridx = 1;
		newPanel.add(textUsername, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;		
		newPanel.add(labelKey, constraints);
		
		constraints.gridx = 1;
		newPanel.add(textKey, constraints);
		
		constraints.gridx = 2;
		newPanel.add(labelError, constraints);
				
		constraints.gridx = 0;
		constraints.gridy = 2;		
		newPanel.add(labelCypher, constraints);
		
		
		constraints.gridx = 1;
		newPanel.add(textCypher, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		newPanel.add(labelPlain, constraints);
		
		constraints.gridx = 1;
		newPanel.add(textPlain, constraints);
		
		buttonLogin.addActionListener(new ButtonListener(){
 
            public void actionPerformed(ActionEvent e)
            {
				
				
                if (e.getActionCommand().equals("Process DES")) {
				  //System.out.println("Button1 has been clicked");
				  DESImplementation4 des = new DESImplementation4();		
					
					//Scanner in = new Scanner(System.in);
					String smessage, key_string;
					
					
					//System.out.printf("\n%5s \n","------Jonathan's DES Implementation--------");
					
					//System.out.println("\nWhat would you like to say in secret:");
					//smessage = in.nextLine();
					smessage = textUsername.getText();
					//System.out.println("\nPlease tell me your key: It's eigth characters long.");
					//key_string = in.nextLine();
					key_string = textKey.getText();
					
					if(textKey.getText().length() < 8 || textKey.getText().length() > 8){
						//key_string = textKey.getText();
						//System.out.println("uff!. I believe there are more or less than 8 characters.");
						//System.out.println("Please try again.");
						//JOptionPane.showMessageDialog(null,"ALERT MESSAGE","TITLE",JOptionPane.WARNING_MESSAGE);
						
						labelError.setVisible(!labelError.isVisible());
						revalidate();
						repaint();
						key_string = textKey.getText();
					}else{
					byte[] message = smessage.getBytes();
					//System.out.println("\nPlain text:");
					String s = new String(message);
					
					//System.out.printf("%5s \n","--------------");
					//System.out.println(s);
					
					
					String skey = key_string+"BBAFCDF1";
					byte[] key =  des.hexStringToByteArray(skey);
					
					byte[] cipher = des.crypt(message, key, "encrypt");
					//System.out.println("\nCipher Text:");
					//System.out.printf("%5s \n","--------------");
					String s3 = new String(cipher);
					textCypher.setText(s3);
					//System.out.println(s3);
					
					byte[] result = des.crypt(cipher, key, "decrypt");
					//System.out.println("\nDecrypted Text:");
					//System.out.printf("%5s \n","--------------");
					String s4 = new String(result);
					textPlain.setText(s4);
					//System.out.println(s4);
				  
						
					}
				}
            }
        });
		
		
		
		buttonCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				   dispose();
				}
		});
		
		
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonLogin, constraints);
		newPanel.add(buttonCancel, constraints);
		
		// set border for the panel	
		newPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Details"));
		
		// add the panel to this frame
		add(newPanel);
		
		pack();
		setLocationRelativeTo(null);
	}
	
	
	
	
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
	static final int[] SHIFTS = {
		1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1
	};
	
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

		public byte[] cryptText(byte[] message, byte[] key, String operation) {
		if (message.length != 8) {
			System.out.println("Message must be 64 bits");
			System.exit(1);
		}
		if (key.length != 8) {
			System.out.println("Key must be 64 bits");
			System.exit(1);
		}
		byte[] result = null;
		int blockSize = IP.length;
		byte[][] subKeys = getSubKeys(key);
		int noOfRounds = subKeys.length;
		message = permute(message, IP);
		byte[] leftHalf = getBits(message, 0, blockSize/2);
		byte[] rightHalf = getBits(message, blockSize/2, blockSize/2);
		for (int i = 0 ; i < noOfRounds ; i++) {
			byte[] temp = rightHalf;
			rightHalf = permute(rightHalf, E);
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
			rightHalf = sBox(rightHalf);
			rightHalf = permute(rightHalf, P);
			rightHalf = performXOR(rightHalf, leftHalf);
			leftHalf = temp;
		}
		byte[] concatHalves = concatBits(rightHalf, blockSize/2, leftHalf, blockSize/2);
		result = permute(concatHalves, IIP);
		return result;
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
	
	private byte[] getBits(byte[] input, int startPos, int length) {
		int noOfBytes = (length-1)/8 + 1;
		byte[] output = new byte[noOfBytes];
		for (int i = 0 ; i < length ; i++) {
			int value = getBitFromArray(input, startPos + i);
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
	
	
	
	public byte[] crypt(byte[] message, byte[] key, String operation) {
		if (message.length < 8) {
			System.out.println("Message must be atleast 64 bits");
			System.exit(1);
		}
		if (key.length != 8) {
			System.out.println("Key must be 64 bits");
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
			result = cryptText(block, key, operation);
			for (j = 0 ; j < 8 && k < cipher.length; j++, k++) {
				cipher[k] = result[j];
			}
		}
		return cipher;		
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
	

	
	private byte[] sBox(byte[] input) {		
		input = split(input,6);
		byte[] output = new byte[input.length/2];
		int leftHalf = 0;		
		for (int i = 0; i < input.length ; i++) {
			byte block = input[i];			
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
				
		// set look and feel to the system look and feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DESImplementation4().setVisible(true);
			}
		});
	}
}
