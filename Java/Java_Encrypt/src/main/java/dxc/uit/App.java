package dxc.uit;

import dxc.uit.ways.SubstitutionCipher;
import dxc.uit.ways.SubstitutionNgramCipher;
import dxc.uit.ways.Vigenere;

/**
 * Hello world!
 * 
 */
public class App 
{
	public static void main(String[] args) {
//		// Substitution Cipher
//		String key = "RL4uDOPzyQwmCtT6UJrh3sgWIc0MX79nAYHdk pxjaGK15Blq8foSeFZVbEiNv2";
//        String message = "Nguy3n Ngoc Hanh chau";
//
//        if (key.length() != SubstitutionCipher.FIX_KEY_LENGTH) {
//            System.out.println("The key must be " +SubstitutionCipher.FIX_KEY_LENGTH + " long");
//        } else if (SubstitutionCipher.containingDuplicate(key)) {
//            System.out.println("The key cannot contain duplicate character");
//        } else {
//            String encryptedMessage = SubstitutionCipher.encrypt(message,key);
//            System.out.println("Encrypted message: " + encryptedMessage);
//            String decryptedMessage = SubstitutionCipher.decrypt(encryptedMessage,key);
//            System.out.println("Decrypted message: " + decryptedMessage);
//        }

//		// Substitution Ngram Cipher 
//		String message = "Enter a message To Encrypt: ";
////		String key = "GYlj3yV5bMeNLRc0hTziSH9vW2JdqakZtgXPEf7 oDAUrw61IFpCsuBKQn4xm8O";
//		String key = SubstitutionNgramCipher.generateKey();
//		if(SubstitutionNgramCipher.containingDuplicate(key)) {
//			System.out.println("The key cannot contain duplicate character");
//		} else if (key.length() != SubstitutionNgramCipher.FIX_KEY_LENGTH) {
//			System.out.println("The key must be " +SubstitutionNgramCipher.FIX_KEY_LENGTH + " long");
//		} else {
//			System.out.println("Encrypt and decrypt message with key = "+key);
//			if(message.length()%2 ==1) {
//				message += " ";
//			}
//	        String encryptedMessage = SubstitutionNgramCipher.encrypt(message,key);
//	        System.out.println("Encrypted message: " + encryptedMessage);
//	        String decryptedMessage = SubstitutionNgramCipher.decrypt(encryptedMessage, key);
//	        System.out.println("Decrypted message: " + decryptedMessage);
//		}
		
		
		String message = "This is a secret message123!";
        String key = Vigenere.generateKey(message.length());
        String ciphertext = Vigenere.encrypt(message, key);
        String decryptedText = Vigenere.decrypt(ciphertext, key);

        System.out.println("Message: " + message);
        System.out.println("Key: " + key);
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decrypted text: " + decryptedText);
    }
}
