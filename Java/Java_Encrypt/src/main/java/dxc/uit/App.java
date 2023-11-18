package dxc.uit;

import dxc.uit.ways.SubstitutionCipher;
import dxc.uit.ways.SubstitutionNgramCipher;

/**
 * Hello world!
 * 
 */
public class App 
{
	public static void main(String[] args) {
//		// Substitution Cipher
//		String key = "RL4uDOPzyQwmCtT6UJrh3sgWIc0MX79nAYHdkpxjaGK15Blq8foSeFZVbEiNv2";
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

		// Substitution Ngram Cipher 
		String message = "Minh Khoi Vi Dai ! ahhh !i! 123";
		String key = "RL4uDOPzyQwmCtT6UJrh3sgWIc0MX79nAYHdkpxjaGK15Blq8foSeFZV bEiNv2";
		
		if(message.length()%2 ==1) {
			message += " ";
		}
        String encryptedMessage = SubstitutionNgramCipher.encrypt(message,key);
        System.out.println("Encrypted message: " + encryptedMessage);
        String decryptedMessage = SubstitutionNgramCipher.decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
		
		
    }
}
