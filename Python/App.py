from ways.SubstitutionCipher import SubstitutionCipher

key = 'j1r5t78yEaB2CDFGHIJKLMN3O4P6QS9UVWXZa0bcdefghjklmnopqrstuvwxyz'

plaintext = 'Enter a message To Encrypt: '
ciphertext = SubstitutionCipher().encrypt_message(plaintext, key)
print('Encrypted message:', ciphertext)

decrypted_message = SubstitutionCipher().decrypt_message(ciphertext, key)
print('Decrypted message:', decrypted_message)