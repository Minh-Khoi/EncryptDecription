from ways.SubstitutionCipher import SubstitutionCipher
from ways.SubstitutionNgramCipher import SubstitutionNgramCipher


# key = 'j1r5t78yEaB2CDFGHIJKLMN3O4P6QS9UVWXZa0bcdefghjklmnopqrstuvwxyz'

# plaintext = 'Enter a message To Encrypt: '
# ciphertext = SubstitutionCipher().encrypt_message(plaintext, key)
# print('Encrypted message:', ciphertext)

# decrypted_message = SubstitutionCipher().decrypt_message(ciphertext, key)
# print('Decrypted message:', decrypted_message)

cipher = SubstitutionNgramCipher()
# key = 'GYlj3yV5bMeNLRc0hTziSH9vW2JdqakZtgXPE f7oDAUrw61IFpCsuBKQn4xm8O'
key = cipher.createKey()
if(cipher.containingDuplicate(key=key)):
    print('The key cannot contain duplicate character')
elif(len(key) != cipher.fixed_length_key):
    print("the key length must be {}".format(cipher.fixed_length_key))
else:
    plaintext = 'Enter a message To Encrypt: '
    print("enscrypt with key: {}".format(key))
    if (len(plaintext) % 2 ==1):
        plaintext += " "
        
    ciphertext = cipher.encrypt(plaintext, key)
    print('Encrypted message:', ciphertext)

    decrypted_message = cipher.decrypt(ciphertext, key)
    print('Decrypted message:', decrypted_message)