package Temat9.tests;

import Temat9.pageobjects.LandingPage;
import Temat9.pageobjects.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {

    @Test
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        LandingPage landingPage = new LandingPage();
        landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoPasswordField("IncorrectUsername")
                .typeIntoPasswordField("InvalidPassword")
                .clickOnLoginButton();

        LoginPage loginPage = new LoginPage();
        String warningMessage = loginPage.getWarningMessage();

        assertEquals(warningMessage, "Invalid username or password. Signon failed.");
    }
}
