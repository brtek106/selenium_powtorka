package Temat9.tests;

import Temat9.drivermanager.DriverUtils;
import Temat9.pageobjects.LandingPage;
import Temat9.pageobjects.LoginPage;
import org.testng.annotations.Test;

import static Temat9.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();

        boolean isLogoAfterLoginDisplayed = loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isLogoAfterLoginDisplayed);

    }
}
