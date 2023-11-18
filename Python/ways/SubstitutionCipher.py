
class SubstitutionCipher:

    def __init__(self) -> None:
        self.__alphabets= 'abcdefghijklmnopqrstuvwxyz'+"abcdefghijklmnopqrstuvwxyz".upper()
        self.__digits = "1234567890"
        self.alphabets_digits = self.__alphabets + self.__digits
        self.fixed_length_key = len(self.alphabets_digits)
        pass

    def encrypt_message(self,plaintext:str, key:str):
        ciphertext = ''
        for char in plaintext:
            if char in self.alphabets_digits:
                index = self.alphabets_digits.index(char)
                newCharFromKey = key[index]
                ciphertext += newCharFromKey
            else:
                ciphertext += char
        return ciphertext

    def decrypt_message(self,ciphertext:str, key:str):
        plaintext = ''
        for char in ciphertext:
            if char in key:
                index = key.index(char)
                newCharFromKey = self.alphabets_digits[index]
                plaintext += newCharFromKey
            else:
                plaintext += char
        return plaintext
    