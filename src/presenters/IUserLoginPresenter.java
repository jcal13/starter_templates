package presenters;

public interface IUserLoginPresenter {
    String createUserUsername();

    /**
     * Presenter for creating a password
     */
    String createUserPassword();

    /**
     * Faulty credential
     */
    default void isFaultyCredential() {
        showMessage("The characters in that username and password are illegal.");
    }

    /**
     * Faulty credential
     */
    default void invalidPassword() {
        showMessage("Invalid user password for this account.");
    }

    /**
     * Faulty credential
     */
    default void accountAdded() {
        showMessage("You have added a new user account.");
    }

    /**
     * shows various messages
     */
    void showMessage(String message);
}
