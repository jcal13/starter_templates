package entities;

public class User {
    /**
     * Unique identifier of this account (cannot be changed).
     */
    private final int accountID;

    /**
     * Username of this account (cannot be changed).
     */
    private final String username;

    /**
     * Password of this account.
     */
    private final String password;

    /**
     * Creates a new account with the given username, password
     *
     * @param username    Username of this account
     * @param password    Password for this account
     * @param accountID   Unique identifier of this account
     */
    public User(String username, String password, int accountID) {
        this.username = username;
        this.password = password;
        this.accountID = accountID;
    }
    /**
     * Get the accountID of this account.
     *
     * @return Unique identifier of the account
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * Gets the username of the account.
     *
     * @return Username of the account
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of this account.
     *
     * @return Password of the account
     */
    public String getPassword() {
        return password;
    }

    /**
     * Creates a string representation of this Account.
     *
     * @return A string representation of this Account object
     */
    @Override
    public String toString() {
        return this.username;
    }
}
