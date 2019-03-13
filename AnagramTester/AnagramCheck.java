/**
 * Q1: Anagram Tester
 * Write a function that checks if two words are anagrams.
 */
import java.util.Arrays;
import java.util.Scanner;

/**
 * AnagramCheck class to validate that two strings are anagram or not.
 * 
 * @author Faisal Khan
 */
public class AnagramCheck {

	static int NO_OF_CHARS = 256;

	/**
	 * Method to two check two given words are anagram or not
	 * 
	 * @param word1 first word
	 * @param word2 second words
	 * @return true if words are anagram else false
	 */
	static boolean is_anagram(String word1, String word2) {

		char[] string1 = word1.toLowerCase().toCharArray();
		char[] string2 = word2.toLowerCase().toCharArray();

		// Create a count array and initialize all values as 0
		int count[] = new int[NO_OF_CHARS];
		Arrays.fill(count, 0);
		int i;

		// For each character in input strings, increment count in the corresponding
		// count array
		for (i = 0; i < string1.length && i < string2.length; i++) {
			count[string1[i]]++;
			count[string2[i]]--;
		}

		// Return false if both strings are not equal length
		if (string1.length != string2.length)
			return false;

		// return false if there are any non zero value
		for (i = 0; i < NO_OF_CHARS; i++)
			if (count[i] != 0)
				return false;

		return true;
	}

	/**
	 * Main Method to get two random words from user using command line. Here user
	 * will enter two string and will get result expected result. To Quit program
	 * user needs to enter '0' or by pressing any key he can retry with new strings
	 * or words
	 * 
	 * @param args StringArray not in use
	 */
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter First String");
			String firstString = scanner.nextLine(); // getting first word from user
			System.out.println("Enter Second String");
			String secondString = scanner.nextLine(); // getting first word from user
			if (is_anagram(firstString, secondString))
				System.out.println("Strings are anagrams"); // if both words are anagrams
			else
				System.out.println("Strings are not anagrams"); // if both words are not anagrams
			System.out.println("Press Q to try again or any key to Quit ");
			char continueCheck = scanner.nextLine().charAt(0);

			// if entered word is 'Q' to retry else quit the loop and close the scanner
			if (continueCheck != 'Q') {
				scanner.close();
				break;
			}
		}
	}
}
