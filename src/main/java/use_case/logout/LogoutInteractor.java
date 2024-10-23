package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {

        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute(LogoutInputData logoutInputData) {
       
        final String username = userDataAccessObject.getCurrentUsername();
        userDataAccessObject.setCurrentUsername(null);

        final LogoutOutputData logoutOutputData = new LogoutOutputData(username, false);
        logoutPresenter.prepareSuccessView(logoutOutputData);

    }
}

