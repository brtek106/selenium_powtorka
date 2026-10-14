package Temat11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ScreenShotMakerTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
    }

    @Test
    public void screenshotMakerTest() {
        ScreenShotMaker shotMaker = new ScreenShotMaker(driver);
        shotMaker.takeScreenshot("GoogleBeforeTypingQueryPage");
        WebElement searchField = driver.findElement(By.cssSelector("textarea[name='q']"));
        searchField.sendKeys("Kurs Selenium");
        shotMaker.takeScreenshot("GoogleAfterTypingQueryPage");
        searchField.submit();
        shotMaker.takeScreenshot("GoogleSearchResultsPage");

        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Kurs Selenium"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
