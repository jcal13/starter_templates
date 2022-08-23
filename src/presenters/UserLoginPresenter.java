package presenters;

import java.util.Scanner;

/**
 * Console presenter for letting an admin create an account.
 *
 * @author Brandon
 */
public class UserLoginPresenter implements IUserLoginPresenter {
    /**
     * presenter for creating a username
     */
    public String createUserUsername() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your desired username:");
        System.out.println("Enter \"-1\" to exit.");
        return input.nextLine();
    }

    /**
     * Presenter for creating a password
     */
    public String createUserPassword() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your desired password:");
        System.out.println("Enter \"-1\" to exit.");
        return input.nextLine();
    }

    /**
     * Faulty credential
     */
    public void isFaultyCredential() {
        System.out.println("The characters in that username and password are illegal.");
    }

    /**
     * Faulty credential
     */
    public void invalidPassword() {
        System.out.println("Invalid user password for this account.");
    }

    /**
     * Faulty credential
     */
    public void accountAdded() {
        System.out.println("You have added a new user account.");
    }

    /**
     * shows various messages
     */
    public void showMessage(String message) {
        System.out.println(message);
    }
}