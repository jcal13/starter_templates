package usecases;

import entities.User;

/**
 * Manager that creates a user or retrieves a user
 *
 * @author Brandon
 */
public class UserManager {

    /**
     * The current account being edited.
     */
    private User currUser;

    /**
     * Constructs an instance of AccountManager and stores accountGateway.
     */
    public UserManager() {
    }

    /**
     * Creates a new standard trading account using username and password by determining if characters used are valid.
     *
     * @param username Username of the new account
     * @param password Password of the new account
     * @param accountId account id for user
     */
    public void createStandardAccount(String username, String password,int accountId) {
        this.currUser = new User(username,password,accountId);
    }

    /**
     * Returns user account
     *
     * @return user account
     */
    public User getUserAccount() { return this.currUser;}

    /**
     * Creates a string representation of this Account.
     *
     * @return A string representation of this Account object
     */
    @Override
    public String toString() {
        return this.currUser.toString();
    }

    public String getUserName() {
        return this.currUser.toString();
    }
}
