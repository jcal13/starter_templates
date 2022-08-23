import controllers.UserLoginSystem;
import presenters.GuiUserLoginPresenter;
import presenters.IUserLoginPresenter;
import presenters.UserLoginPresenter;

import java.io.IOException;

/**
 * Contains the main method that starts the program.
 *
 * @author Brandon
 */
public class Main {
    /**
     * Calls the run method of MainController to start the program.
     *
     * @param args Commandline arguments
     */
    public static void main(String[] args) throws IOException {

        // toggle this to change between cmdline and GUI
        boolean useGui = true;
        IUserLoginPresenter ulp;
        if (useGui)
            ulp = new GuiUserLoginPresenter();
        else {
            ulp = new UserLoginPresenter();
        }

        UserLoginSystem userLoginSystem = new UserLoginSystem(ulp);
        userLoginSystem.run();
    }
}