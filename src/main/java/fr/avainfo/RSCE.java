package fr.avainfo;

/**
 * ReversedCodedSaltEncryption Class
 */
public abstract class RSCE {

    /**
     * Default Constructor
     */
    public RSCE() {
    }

    /**
     * Function to encrypt text
     *
     * @param inputText Text to encrypt
     * @param code      Code used to encrypt
     * @return Encrypted text
     */
    public static String encrypt(String inputText, String code) {
        int counter = 0;
        StringBuilder text = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            if (c > 33 + 9 && c < 126) {
                text.append(Character.toString(c + Integer.parseInt(String.valueOf(code.toCharArray()[counter++]))));
                if (counter + 1 > code.length()) counter = 0;
            }
        }
        inputText = text.toString();
        text = new StringBuilder();
        counter = 1;
        for (char c : inputText.toCharArray())
            text.append(c).append(inputText.toCharArray()[inputText.length() - counter++]);
        return text.toString();
    }

    /**
     * Function to decrypt text
     *
     * @param inputText Text to decrypt
     * @param code      Code used to encrypt
     * @return Decrypted text
     */
    public static String decrypt(String inputText, String code) {
        int counter = -2;
        StringBuilder text = new StringBuilder();
        while ((counter += 2) < inputText.length()) text.append(inputText.toCharArray()[counter]);
        counter++;
        while ((counter -= 2) > 0) text.append(inputText.toCharArray()[counter]);
        inputText = text.toString();
        text = new StringBuilder();
        counter = 0;
        for (char c : inputText.substring(0, inputText.length() >> 1).toCharArray()) {
            if (c > 33 + 9 && c < 126) {
                text.append(Character.toString(c - Integer.parseInt(String.valueOf(code.toCharArray()[counter++]))));
                if (counter + 1 > code.length()) counter = 0;
            }
        }
        return text.toString();
    }
}
