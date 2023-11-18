import random

class SubstitutionNgramCipher:
    def __init__(self) -> None:
        self._alphabets = ' abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789'
        self._ngramSize = 2
        self.fixed_length_key = len(self._alphabets)
        pass
# key = j1r5t78yEaB2CDFGHIJKLMN 3O4P6QS9UVWXZa0bcdefghjklmnopqrstuvwxyz
    def encrypt(self, message:str , key:str):
        ngramMap = self.__createNgramMap(key)
        decryptedMessage = ''
        for i in range(0, len(message), self._ngramSize):
            ngram  = message[i:i+self._ngramSize]
            if ngram in ngramMap:
                decryptedMessage += ngramMap[ngram]
            else:
                decryptedMessage += ngram
        return decryptedMessage
        pass
    
    def decrypt(self, ciphertext:str, key:str):
        ngramMap = self.__createNgramMap(key)
        plaintext = ''
        for i in range(0, len(ciphertext), self._ngramSize):
            ngram = ciphertext[i:i+self._ngramSize]
            if ngram in ngramMap:
                plaintext+= self.__getKeyNgram(ngram=ngram, ngramMap=ngramMap)
            else:
                plaintext+=ngram
        return plaintext
        pass
    
    def __createNgramMap(self, key:str) -> dict:
        ngramMap : dict = dict()
        for i, valueA in enumerate(self._alphabets):
            for j, valueB in enumerate(key):
                ngram = valueA + valueB
                ngramMap[ngram] = self._alphabets[j] + key[i]
        return ngramMap
    
    def __getKeyNgram(self,ngram:str, ngramMap:dict) -> str|None:
        for key in ngramMap:
            if ngramMap[key] == ngram:
                return key
        return ""
    
    def containingDuplicate(self, key:str)-> bool:
        hasDupl :bool=False
        for i,lett in enumerate(key):
            if lett in key[i+1:]:
                return True
        return False
    
    def createKey(self)->str:
        return ''.join(random.sample(self._alphabets, len(self._alphabets)))