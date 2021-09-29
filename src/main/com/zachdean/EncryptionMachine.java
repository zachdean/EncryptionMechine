package main.com.zachdean;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * <h1>Simple Caesar Cipher</h1>
 * produce single word encryption for a Caesar Cipher
 *
 * @author  Zachariah Dean
 * @version 1.0
 * @since   2020-09-28
 */
public class EncryptionMachine {

    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Integer SHIFT = 3;
    private static final String ENTER_WORD_TEXT = "Enter word (all lower case, no special characters): ";

    /**
     * entry point
     * @param args - no input args
     */
    public static void main(String[] args) {
        var in = new Scanner(System.in);

        printIntroduction();

        var key = getKey(in);
        var word = getWord(in);

        printCipherText(word);

        in.close();
    }

    /**
     * validates that input is a valid entry
     * @param word
     * @return is the word valid
     */
    public static boolean isWordValid(String word) {
        var pattern = Pattern.compile("[a-z]+");
        var m = pattern.matcher(word);
        return m.matches();
    }

    /**
     * encrypts word using a Caesar Cipher
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
        System.out.println("Introduction: when prompted, enter the key and word you would like to encrypt.");
        System.out.println("The program will encrypt the entry and print the results.");
        System.out.println();
    }

    /**
     * gets the key from an input stream
     * @param scanner input stream scanner
     * @return plaintext key
     */
    private static String getKey(Scanner scanner)
    {
        System.out.print("Enter key: ");
        return scanner.next();
    }

    /**
     * gets the word to encrypt from an input stream and validates entry
     * @param scanner the input stream scanner
     * @return plaintext word
     */
    private static String getWord(Scanner scanner) {
        System.out.print(ENTER_WORD_TEXT);
        var word = scanner.next();

        while (!isWordValid(word)) {
            System.out.println("Invalid Entry!");
            System.out.print(ENTER_WORD_TEXT);
            word = scanner.next();
        }
        return word;
    }

    /**
     * encrypts word and prints ciphertext
     * @param word plaintext word
     */
    private static void printCipherText(String word) {
        System.out.println("Ciphertext:");
        System.out.print(EncryptionMachine.encryptWord(word));
    }
}
