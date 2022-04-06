package SupplimentServices;

import java.util.Scanner;

/**
 *
 * @author callu
 */
public class InputHandler {

    private static final Scanner kb = new Scanner(System.in);

    /**
     *
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
