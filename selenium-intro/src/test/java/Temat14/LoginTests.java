package Temat14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://theinternet.przyklady.javastart.pl/login");
    }

    @Test
    public void loginUsingBadPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("password");
        loginPage.clickLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains("Your password is invalid!"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
