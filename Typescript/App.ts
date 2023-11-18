import { SubstitutionCipher } from "./ways/SubstitutionCipher";

let key = 'j1r5t78yEaB2CDFGHIJKLMN3O4P6QS9UVWXZa0bcdefghjklmnopqrstuvwxyz';

let plaintext = 'Enter a message To Encrypt: '

let ciphertext = SubstitutionCipher.encrypt(plaintext, key)
console.log('Encrypted message:', ciphertext)

let decrypted_message = SubstitutionCipher.decrypt(ciphertext, key)
console.log('Decrypted message:', decrypted_message)