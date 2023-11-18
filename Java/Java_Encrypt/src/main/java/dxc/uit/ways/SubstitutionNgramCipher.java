package dxc.uit.ways;

import java.util.HashMap;
import java.util.Map;

public class SubstitutionNgramCipher {

    private static final String alphabet = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//    private static final int ngramSize = 2;
//    private static final Map<String, String> ngramMap = createNgramMap();

    public static String encrypt(String message, String key) {
    	int ngramSize = 2;
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
    	int ngramSize = 2;
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

}