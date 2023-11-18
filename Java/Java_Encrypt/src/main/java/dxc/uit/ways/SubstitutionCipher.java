package dxc.uit.ways;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SubstitutionCipher { 
	public static final char[] ALPHABET_DIGITS = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	public static final int FIX_KEY_LENGTH = ALPHABET_DIGITS.length;
	
    public static String encrypt(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char character_ : message.toCharArray()) {
            int index = new String(ALPHABET_DIGITS).indexOf(character_);
            if (index != -1) {
            	Character newCharFrKey = key.charAt(index);
//            	Character newChar = (Character.isUpperCase(character_)) ? Character.toUpperCase(newCharFrKey) : Character.toLowerCase(newCharFrKey) ;
                encryptedMessage.append(newCharFrKey);
            } else {
                encryptedMessage.append(character_);
            }
        }
        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, String key) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char character_ : encryptedMessage.toCharArray()) {
            int index = key.indexOf( character_);
            if (index != -1) {
            	Character newCharFrKey = ALPHABET_DIGITS[index];
//            	Character newChar = (Character.isUpperCase(character_)) ? Character.toUpperCase(newCharFrKey) : Character.toLowerCase(newCharFrKey) ;
                decryptedMessage.append(newCharFrKey);
            } else {
                decryptedMessage.append(character_);
            }
        }
        return decryptedMessage.toString();
    }
    
    public static boolean containingDuplicate(String str) {
    	boolean hasDuplicate = false;
    	for (int i = 0; i < str.length(); i++) {
    	    for (int j = i + 1; j < str.length(); j++) {
    	        if (str.charAt(i) == str.charAt(j)) {
    	            hasDuplicate = true;
    	            break;
    	        }
    	    }
    	    if (hasDuplicate) {
    	        break;
    	    }
    	}
    	return hasDuplicate;
	}
    

    public static String generateKey() {
    	String originalString = new String(ALPHABET_DIGITS);
        List<Character> characters = new ArrayList<>();
        for (char character : originalString.toCharArray()) {
            characters.add(character);
        }
        
        Collections.shuffle(characters, new Random());
        StringBuilder shuffledStringBuilder = new StringBuilder();
        for (char character : characters) {
            shuffledStringBuilder.append(character);
        }

        String shuffledString = shuffledStringBuilder.toString();
        while (shuffledString.length() != 63 || hasDuplicates(shuffledString)) {
            Collections.shuffle(characters, new Random());
            shuffledStringBuilder = new StringBuilder();
            for (char character : characters) {
                shuffledStringBuilder.append(character);
            }
            shuffledString = shuffledStringBuilder.toString();
        }
        return shuffledString;
    }

    private static boolean hasDuplicates(String string) {
        Set<Character> characters = new HashSet<>();
        for (char character : string.toCharArray()) {
            if (characters.contains(character)) {
                return true;
            }
            characters.add(character);
        }
        return false;
    }
}
