package controllers;


/**
 * Handler that contains helper methods for verifying input.
 */
public class InputHandler {

    /**
     * Check if a string is the program standard exit string (-1).
     *
     * @param input Input string
     * @return Whether given string is the program standard exit string (-1)
     */
    public boolean isExitStr(String input) {

        return input.equals("-1");

    }

    /**
     * Check if a string is valid for storing in a CSV file (does not include commas).
     *
     * @param input Input string
     * @return Whether the given string is valid for storing in a CSV file
     */
    public boolean isValidCSVStr(String input) {
        return !input.isEmpty() && !input.contains(",");
    }

    /**
     * Determines if an account can be created with the given username and password.
     *
     * @param username Username of the new account
     * @param password Password of the new account
     * @return Whether an account can be created
     */
    public boolean isValidUserPass(String username, String password) {
        return isValidCSVStr(username) && isValidCSVStr(password) &&
                username.matches("^[a-zA-Z0-9_]*$") && password.matches("^[ -~]*$");
    }
}
