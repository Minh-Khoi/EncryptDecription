import random

class Vigenere :
    def __init__(self) -> None:
        self.alphabet = ' abcdefghijklmnopqrstuvwxyz'+'abcdefghijklmnopqrstuvwxyz'.upper() + "0123456789"
        pass
    
    def generate_key(self,d:int):
        """Generates a random key of the specified length."""
        
        key = ''
        for _ in range(0,d):
            key += random.choice(self.alphabet)
        return key

    def encrypt_vigenere(self,plaintext:str, key:str):
        """Encrypts the plaintext using the Vigenère cipher with the given key."""
        alphabet_size = len(self.alphabet)
        ciphertext = ''
        for i, char in enumerate(plaintext):
            if not char.isalpha() and not char.isdigit() and not char == " ":
                ciphertext += char
                continue
            key_char = key[i % len(key)]
            key_index = self.alphabet.index(key_char)
            plain_index = self.alphabet.index(char)
            ciphertext += self.alphabet[(plain_index + key_index) % alphabet_size]
        return ciphertext

    def decrypt_vigenere(self,ciphertext:str, key:str):
        """Decrypts the ciphertext using the Vigenère cipher with the given key."""
        alphabet_size = len(self.alphabet)
        plaintext = ''
        for i, char in enumerate(ciphertext):
            # if char == " ":
            #     print(i)
            if not char.isalpha() and not char.isdigit() and not char == " ":
                plaintext += char
                continue
            key_char = key[i % len(key)]
            key_index = self.alphabet.index(key_char)
            cipher_index = self.alphabet.index(char)
            plaintext += self.alphabet[(cipher_index - key_index) % alphabet_size]
        return plaintext