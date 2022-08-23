package controllers;

import gateways.AccountLoginGateway;
import presenters.IUserLoginPresenter;
import usecases.UserManager;
import java.io.*;


/**
 * Controller that creates new user accounts.
 *
 * @author Brandon
 */
public class UserLoginSystem {
    /**
     * An instance of UserLoginPresenter to let user know what to do.
     */
    private final IUserLoginPresenter userLoginPresenter;
    /**
     * An instance of UserManager to create new account.
     */
    private final UserManager userManager;
    /**
     * An instance of AccountLoginGateway to check for valid input.
     */
    private final AccountLoginGateway accountLoginGateway;

    /**
     * An instance of ControllerInputValidator to check for valid input.
     */
    private final InputHandler inputHandler;

    /**
     * Initializes UserLoginSystem
     */
    public UserLoginSystem(IUserLoginPresenter ulp) throws IOException {
        this.userManager = new UserManager();
        this.userLoginPresenter = ulp;
        this.inputHandler = new InputHandler();
        this.accountLoginGateway = new AccountLoginGateway("./user_accounts.csv");
    }

    /**
     * Calls presenters to get username and password for new admin account.
     */
    public void run() {
        while (true) {
            String username = userLoginPresenter.createUserUsername();
            if (inputHandler.isExitStr(username))
                return;
            String password = userLoginPresenter.createUserPassword();
            if (inputHandler.isExitStr(password))
                return;
            if (!inputHandler.isValidUserPass(username, password))
                userLoginPresenter.isFaultyCredential();
            else {
                boolean userExists = accountLoginGateway.findByUsername(username);
                boolean validPassword = accountLoginGateway.validPassword(username,password);
                if (!userExists) {
                    userManager.createStandardAccount(username,password,accountLoginGateway.generateValidId());
                    userLoginPresenter.accountAdded();
                    userLoginPresenter.showMessage(userManager.toString());
                    boolean updated = accountLoginGateway.updateAccount(userManager.getUserAccount());
                    if(updated){
                        userLoginPresenter.showMessage("updated database");
                    }
                } else if(validPassword){
                    userManager.createStandardAccount(username, password, accountLoginGateway.getUserId(username));
                    userLoginPresenter.showMessage("Welcome back " + userManager.getUserName());
                    userLoginPresenter.showMessage("let's try logging in on a different account.");
                }else{
                    userLoginPresenter.showMessage("Uh-oh check your credentials!");
                    userLoginPresenter.invalidPassword();
                }

            }
        }
    }

}
