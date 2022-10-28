package ciphers;

import java.util.Scanner;

// one of the simplest and most widely known encryption techniques.
// It is a type of substitution cipher in which each letter in the plain text
// is replaced by a letter some fixed number of positions down the alphabet.

// Encrypt text by shifting every Latin char by add number shift for ASCII
// Example : A + 1 -> B

public class CaesarCipher {

	public static void main(String[] args) {
		askForInput();
	}
	
	private static void askForInput() {
		Scanner sc = new Scanner(System.in);
		int shift = 0;
		System.out.println("Please enter the message your message: ");
		String message = sc.nextLine();
		System.out.println("(E)ncode or (D)ecode or (B)ruteforce?");
		char choice = sc.next().charAt(0);
		switch (choice) {
			case 'e':
			case 'E':
				System.out.println("Please enter the shift number: ");
				shift = sc.nextInt() % 26;
				System.out.println("Encoded message is \n ");
				break;
			case 'd':
			case 'D':
				System.out.println("Please enter the shift number: ");
				shift = sc.nextInt() % 26;
				System.out.println("Encoded message is \n ");
				break;
			case 'b':
			case 'B':
				
				break;
			default: 
				System.out.println("Invalid input...");
		}
		
	}
	
	private static String encode(String message, int shift) {
		StringBuilder encoded = new StringBuilder();
		
		shift %= 26;
		final int length = message.length();
		
		for(int i=0; i < length ; i++) {
			// Using chars to shift characters because ascii is in-order latin alphabet
			
			char current = message.charAt(i);
			if(isCapitalLatinLetter(current)) {
				current += shift;
				encoded.append((char) (current > 'Z' ? current - 26 : current));
			} else if (isSmallLatinLetter(current)) {
				current += shift;
				encoded.append((char) (current > 'z' ? current - 26 : current));

			} else {
				encoded.append(current);
			}
			//encoded.append((char)(current > 'Z' ? current - 26 : current));
		}
		return encoded.toString(); 
	}
	
	private static boolean isSmallLatinLetter(char c) {
		return c >= 'a' && c <= 'z';
	}
	
	private static boolean isCapitalLatinLetter(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
}
