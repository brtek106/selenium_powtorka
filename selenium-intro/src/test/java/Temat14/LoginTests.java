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


    @Test(dataProvider = "testData")
    public void asUserLoginUsingIncorrectCredentials(String username, String password, String expectedWarning) {
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

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"", "", "Your username is invalid!"},
                {"tomsmith", "password", "Your password is invalid!"},
                {"incorrectlogin", "SuperSecretPassword!", "Your username is invalid!"}
        };
    }
}
