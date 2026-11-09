package Temat14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://theinternet.przyklady.javastart.pl/login");
    }

    @Parameters({"username", "password", "expectedWarning"})
    @Test
    public void asUserLoginUsingIncorrectCredentials(@Optional("tomsmith") String username,
                                      @Optional("password") String password,
                                      @Optional("Your password is invalid!") String expectedWarning) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains(expectedWarning));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
