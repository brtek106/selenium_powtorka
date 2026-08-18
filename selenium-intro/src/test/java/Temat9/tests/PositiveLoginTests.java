package Temat9.tests;

import Temat9.pageobjects.LandingPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        LandingPage landingPage = new LandingPage();
        boolean isLogoAfterLoginDisplayed = landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();

        assertTrue(isLogoAfterLoginDisplayed);

    }
}
