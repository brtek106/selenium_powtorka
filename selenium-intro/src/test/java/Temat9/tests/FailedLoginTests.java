package Temat9.tests;

import Temat9.driver.manager.DriverUtils;
import Temat9.pageobjects.LoginPage;
import Temat9.utils.testng.listeners.RetryAnalyzer;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Temat9.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class FailedLoginTests extends TestBase {

    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("IncorrectUsername")
                .typeIntoPasswordField("InvalidPassword")
                .clickOnLoginButton();
        loginPage.assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }
}
