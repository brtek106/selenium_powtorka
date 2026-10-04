package Temat9.tests;

import Temat9.driver.manager.DriverUtils;
import Temat9.pageobjects.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static Temat9.navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PositiveLoginTests extends TestBase {

    @TmsLink("ID-2")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            " and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();

        loginPage
                .typeIntoUserNameField("j2eze")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .assertThatDogBannerIsDisplayed();
    }
}
