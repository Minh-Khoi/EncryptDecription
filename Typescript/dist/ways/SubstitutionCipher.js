"use strict";
var _a;
Object.defineProperty(exports, "__esModule", { value: true });
exports.SubstitutionCipher = void 0;
class SubstitutionCipher {
    static encrypt(message, key) {
        let ciphertext = '';
        for (let char_ of message) {
            if (this.ALPHABETS_DIGITS.includes(char_)) {
                let index = this.ALPHABETS_DIGITS.indexOf(char_);
                let newCharFrKey = key.charAt(index);
                ciphertext += newCharFrKey;
            }
            else {
                ciphertext += char_;
            }
        }
        return ciphertext;
    }
    static decrypt(ciphertext, key) {
        let plaintext = "";
        for (let char_ of ciphertext) {
            if (key.includes(char_)) {
                let index = key.indexOf(char_);
                let newCharFrKey = this.ALPHABETS_DIGITS.charAt(index);
                plaintext += newCharFrKey;
            }
            else {
                plaintext += char_;
            }
        }
        return plaintext;
    }
}
exports.SubstitutionCipher = SubstitutionCipher;
_a = SubstitutionCipher;
SubstitutionCipher.alphabet = "abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz".toUpperCase();
SubstitutionCipher.digits = '1234567890';
SubstitutionCipher.ALPHABETS_DIGITS = _a.alphabet + _a.digits;
