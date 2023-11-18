

export class SubstitutionCipher{
    private static alphabet : string ="abcdefghijklmnopqrstuvwxyz"+"abcdefghijklmnopqrstuvwxyz ".toUpperCase();
    private static digits : string = '1234567890';
    public static ALPHABETS_DIGITS = this.alphabet+this.digits;

    public static encrypt(message : string, key:string) :string {
        let ciphertext  = '';
        for(let char_ of message){
            if(this.ALPHABETS_DIGITS.includes(char_)){
                let index = this.ALPHABETS_DIGITS.indexOf(char_)
                let newCharFrKey = key.charAt(index)
                ciphertext += newCharFrKey;
            } else {
                ciphertext+=char_;
            }
        }
        return ciphertext;
    } 

    public static decrypt(ciphertext : string, key:string) : string {
        let plaintext = "";
        for(let char_ of ciphertext){
            if (key.includes(char_)){
                let index = key.indexOf(char_);
                let newCharFrKey = this.ALPHABETS_DIGITS.charAt(index);
                plaintext += newCharFrKey;
            } else {
                plaintext += char_;
            }
        }
        return plaintext;
    }
    
}

