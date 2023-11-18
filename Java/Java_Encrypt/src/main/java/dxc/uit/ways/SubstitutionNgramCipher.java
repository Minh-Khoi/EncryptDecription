package dxc.uit.ways;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SubstitutionNgramCipher {

    public static final String alphabet = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ngramSize = 2;
	public static final int FIX_KEY_LENGTH = alphabet.length();

    public static String encrypt(String message, String key) {
    	Map<String, String> ngramMap = createNgramMap(key);
    	
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length() - ngramSize + 1; i+=ngramSize) {
            String ngram = message.substring(i, i + ngramSize);
            if (ngramMap.containsKey(ngram)) {
                encryptedMessage.append(ngramMap.get(ngram));
            } else {
                encryptedMessage.append(ngram);
            }
        }
        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, String key) {
    	Map<String, String> ngramMap = createNgramMap(key);
    	
        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length() - ngramSize + 1; i+=ngramSize) {
            String ngram = encryptedMessage.substring(i, i + ngramSize);
            if (ngramMap.containsValue(ngram)) {
                decryptedMessage.append(getKeyForNgram(ngram, ngramMap));
            } else {
                decryptedMessage.append(ngram);
            }
        }
        return decryptedMessage.toString();
    }

    private static Map<String, String> createNgramMap(String key) {
        Map<String, String> ngramMap = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                String ngram = alphabet.substring(i, i + 1) + key.substring(j, j + 1);
                ngramMap.put(ngram, alphabet.substring(j, j + 1) + key.substring(i, i + 1));
            }
        }
        return ngramMap;
    }

    private static String getKeyForNgram(String ngram, Map<String, String>  ngramMap) {
        for (String key : ngramMap.keySet()) {
            if (ngramMap.get(key).equals(ngram)) {
                return key;
            }
        }
        return null;
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
    	String originalString = alphabet;
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
        System.out.println(shuffledString);
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