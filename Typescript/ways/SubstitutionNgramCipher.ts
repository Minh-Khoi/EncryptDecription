
class SubstitutionNgramCipher{

    public generateKey(str: string): string {
        const characters: string[] = [];
        const shuffledCharacters: string[] = [];

        for (let i = 0; i < str.length; i++) {
            characters.push(str[i]);
        }

        while (shuffledCharacters.length < str.length) {
            const randomIndex = Math.floor(Math.random() * characters.length);
            const char = characters[randomIndex];

            if (!shuffledCharacters.includes(char)) {
            shuffledCharacters.push(char);
            characters.splice(randomIndex, 1);
            }
        }

        return shuffledCharacters.join('');
    }
}