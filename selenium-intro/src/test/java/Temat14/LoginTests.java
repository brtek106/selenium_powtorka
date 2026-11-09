package Temat14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTests {

    private WebDriver driver;
    private IncorrectLoginTestData incorrectLoginTestData;

    public LoginTests(IncorrectLoginTestData incorrectLoginTestData) {
        this.incorrectLoginTestData = incorrectLoginTestData;
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://theinternet.przyklady.javastart.pl/login");
    }

    @Test
    public void incorrectLoginDataTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(incorrectLoginTestData.getUsername());
        loginPage.enterPassword(incorrectLoginTestData.getPassword());
        loginPage.clickLoginButton();
        String warningMessage = loginPage.getWarningMessage();

        assertTrue(warningMessage.contains(incorrectLoginTestData.getExpectedMessage()));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @Factory
    public static Object[] testData() {
        LoginTests firstTestToExecute = new LoginTests(new IncorrectLoginTestData("", "", "Your username is invalid!"));
        LoginTests secondTestToExecute = new LoginTests(new IncorrectLoginTestData("tomsmith", "password", "Your password is invalid!"));
        LoginTests thirdTestToExecute = new LoginTests(new IncorrectLoginTestData("badlogin", "SuperSecretPassword!", "Your username is invalid!"));
        return new Object[]{firstTestToExecute, secondTestToExecute, thirdTestToExecute};
    }
}
