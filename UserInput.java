/*
 * Copied class from another personal project i'm working on that handles user input in its own class
 * for any project I do, chatGPT helped me create it so I stop running into userinput Java bugs.
 */

import java.util.Scanner;

public class UserInput {

	static Scanner scanner = new Scanner(System.in);
	
	public static int menuChoice(){
		while(true) {
			try {
				System.out.println("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();
				return choice;
					
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a number!");
				scanner.nextLine();
			}
		}
	}
	
	public static int getInt(String message) {
		while(true) {
			try {
				System.out.println(message);
				int input = scanner.nextInt();
				scanner.nextLine();
				return input;
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a number!");
				scanner.nextLine();
			}
		}
	}

	public static double getDouble(String message) {
		while(true) {
			try {
				System.out.println(message);
				double input = scanner.nextDouble();
				scanner.nextLine();
				return input;
			} catch (Exception e) {
				System.out.println("Invalid input! Please enter a number!");
				scanner.nextLine();
			}
		}
	}
	
	public static String getString(String message) {
		System.out.println(message);
		String input = scanner.nextLine();
		return input.trim();
	}
	
	public static char getChar(String message) {
		while (true) {
			System.out.println(message);
			String input = scanner.nextLine().trim();
			if(!input.isEmpty()) {
				return input.charAt(0);
			}
			System.out.println("Please enter at least one character!");
		}
	}
	
	public static void pause() {
		System.out.println("Press enter to continue");
		scanner.nextLine();
		//UserInput.pause(); infinite pause don't ever do
	}
	
	public static int getIntInRange(String message, int min, int max) {
		while (true) {
			int value = getInt(message);
			if (value < min || value > max) {
				System.out.println("Please enter a number between " + min + " and " + max + ".");
			} else {
				return value;
			}
		}
	}
}
