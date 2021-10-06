package main.com.zachdean;

import java.util.Scanner;

/**
 * <h1>Simple Caesar Cipher</h1>
 * produce single word encryption using a Caesar Cipher
 *
 * @author Zachariah Dean
 * @version 1.0
 * @since 2021-09-28
 */
public class EncryptionMachine {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Integer SHIFT = 3;

    /**
     * entry point
     *
     * @param args - no input args
     */
    public static void main(String[] args) {

        var in = new Scanner(System.in);

        printIntroduction();

        var key = getKey(in); // retain for future use
        var count = getWordCount(in);

        System.out.println();

        processWords(count, in);

        in.close();
        System.out.println("Fully Encrypted!");
    }

    /**
     * encrypts word using a Caesar Cipher
     *
     * @param word
     * @return ciphertext
     */
    public static String encryptWord(String word) {
        var sb = new StringBuilder(word.length());
        for (var c :
                word.toCharArray()) {
            sb.append(encryptCharacter(c));
        }
        return sb.toString();
    }

    /**
     * encrypt a single character
     *
     * @param c the character to encrypt
     * @return encrypted character
     */
    private static char encryptCharacter(char c) {
        var pos = (ALPHABET.indexOf(c) + SHIFT) % ALPHABET.length();
        return ALPHABET.charAt(pos);
    }

    /**
     * prints a quick summery for the program
     */
    private static void printIntroduction() {
        System.out.println("Welcome to the CSCI717 Encryption Machine ");
        System.out.println("when prompted, enter the key and words you would like to encrypt.");
        System.out.println("The program will encrypt the entry and print the results.");
        System.out.println();
    }

    /**
     * gets the key from an input stream
     *
     * @param scanner input stream scanner
     * @return plaintext key
     */
    private static String getKey(Scanner scanner) {
        System.out.print("Enter key: ");
        return scanner.next();
    }

    private static int getWordCount(Scanner scanner) {
        System.out.print("Enter number of words to encrypt: ");
        return Integer.parseInt(scanner.next());
    }

    /**
     * processes the whole message
     * @param wordCount the number of words in the message
     * @param scanner stdin
     */
    public static void processWords(int wordCount, Scanner scanner){
        for (int i = 0; i < wordCount; i++) {
            var word = getWord(scanner);
            printCipherText(word);
        }
    }

    /**
     * gets the word to encrypt from an input stream and validates entry
     *
     * @param scanner the input stream scanner
     * @return plaintext word
     */
    private static String getWord(Scanner scanner) {
        System.out.print("Enter word (all lower case, no special characters): ");
        return scanner.next();
    }

    /**
     * encrypts word and prints ciphertext
     *
     * @param word plaintext word
     */
    private static void printCipherText(String word) {
        System.out.println("Ciphertext: " + EncryptionMachine.encryptWord(word));
        System.out.println();
    }
}
