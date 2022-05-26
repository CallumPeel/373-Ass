package SupplementServices;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Handles user input from the console.
 * @author Callum Peel
 */
public class InputHandler implements Serializable {

    private static final Scanner kb = new Scanner(System.in);

    /**
     * Takes a question to be printed to the console, 
     * takes an input from the user and then returns the first char.
     * @param question
     * @return
     */
    public char getChar(String question) {
        String msg = "";
        while (msg.isEmpty()) {
            System.out.println(question);
            msg = kb.nextLine().toLowerCase();
        }
        return msg.charAt(0);
    }

    /**
     * Takes a question to be printed to the console,
     * returns a 'y' or 'n'
     * 
     * @param question
     * @return
     */
    public char getYorN(String question) {
        char answer = 'x';
        boolean validInput = false;
        while (!validInput) {
            answer = getChar(question);
            if (answer == 'y' || answer == 'n') {
                validInput = true;
            } else {
                System.out.println("Invalid input. Enter Y or N.\n");
                validInput = false;
            }
        }
        return Character.toLowerCase(answer);
    }

    /**
     * Takes a question to be printed to the console,
     * returns an int.
     *
     * @param question
     * @return
     */
    public int getInt(String question) {
        boolean inputValid = false;
        int input = 0;
        while (!inputValid) {
            try {
                System.out.println(question);
                input = Integer.parseInt(kb.nextLine());
                inputValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again...");
                inputValid = false;
            }
        }
        return input;
    }

    /**
     * Takes a question to be printed to the console,
     * returns a long
     *
     * @param question
     * @return
     */
    public long getLong(String question) {
        boolean inputValid = false;
        long input = 0;
        while (!inputValid) {
            try {
                System.out.println(question);
                input = Long.parseLong(kb.nextLine());
                inputValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again...");
                inputValid = false;
            }
        }
        return input;
    }

    /**
     * Takes a question to be printed to the console,
     * returns a double
     *
     * @param question
     * @return
     */
    public double getDouble(String question) {
        boolean inputValid = false;
        double input = 0;
        while (!inputValid) {
            try {
                System.out.println(question);
                input = Double.parseDouble(kb.nextLine());
                inputValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input, please try again...");
                inputValid = false;
            }
        }
        return input;
    }

    /**
     * Takes a question to be printed to the console,
     * returns a string
     *
     * @param question
     * @return
     */
    public String getString(String question) {
        String msg = "";
        while (msg.isEmpty()) {
            System.out.println(question);
            msg = kb.nextLine();
            if (msg.isEmpty()) {
                System.out.println("Please enter something.");
            }
        }
        return msg;
    }
}
