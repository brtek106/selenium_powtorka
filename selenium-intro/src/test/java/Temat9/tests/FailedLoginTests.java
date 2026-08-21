package Temat9.tests;

import Temat9.drivermanager.DriverUtils;
import Temat9.pageobjects.LandingPage;
import Temat9.pageobjects.LoginPage;
import org.testng.annotations.Test;

import static Temat9.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoPasswordField("IncorrectUsername")
                .typeIntoPasswordField("InvalidPassword")
                .clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }
}
