package dxc.uit.ways;

import java.util.HashMap;
import java.util.Random;

public class Vigenere {
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
    private static final HashMap<Character, Integer> charToIndexMap;
    private static final HashMap<Integer, Character> indexToCharMap;

    static {
        charToIndexMap = new HashMap<>();
        indexToCharMap = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++) {
            charToIndexMap.put(alphabet.charAt(i), i);
            indexToCharMap.put(i, alphabet.charAt(i));
        }
    }

    public static String generateKey(int length) {
        StringBuilder key = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            key.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return key.toString();
    }

    public static String encrypt(String message, String key) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i % key.length());
            if (!alphabet.contains(Character.toString(messageChar))){
            	ciphertext.append(messageChar);
            	continue;
            }
            int messageIndex = charToIndexMap.get(messageChar);
            int keyIndex = charToIndexMap.get(keyChar);

            int ciphertextIndex = (messageIndex + keyIndex) % alphabet.length();
            char ciphertextChar = indexToCharMap.get(ciphertextIndex);

            ciphertext.append(ciphertextChar);
        }

        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i % key.length());
            if (!alphabet.contains(Character.toString(ciphertextChar))){
            	plaintext.append(ciphertextChar);
            	continue;
            }
            int ciphertextIndex = charToIndexMap.get(ciphertextChar);
            int keyIndex = charToIndexMap.get(keyChar);

            int plaintextIndex = (ciphertextIndex - keyIndex+alphabet.length()) % alphabet.length();
            char plaintextChar = indexToCharMap.get(plaintextIndex);

            plaintext.append(plaintextChar);
        }

        return plaintext.toString();
    }


}
