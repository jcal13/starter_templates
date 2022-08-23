package presenters;

import javax.swing.*;

public class GuiUserLoginPresenter implements IUserLoginPresenter {

    /**
     * presenter for creating a username
     */
    public String createUserUsername() {
        String result = JOptionPane.showInputDialog(null, "Enter your desired username or -1 to exit:");
        if (result == null) {
            return "-1";
        }
        return result;
    }

    /**
     * Presenter for creating a password
     */
    public String createUserPassword() {
        String result = JOptionPane.showInputDialog(null, "Enter your password or -1 to exit:");
        if (result == null)
        {
            return "-1";
        }
        return result;
    }

    /**
     * shows various messages
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
