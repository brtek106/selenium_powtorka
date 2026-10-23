package Temat12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFrameTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://theinternet.przyklady.javastart.pl/nested_frames");
    }

    @Test
    public void iFrameTest() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftFrameBody = driver.findElement((By.xpath("//body")));
        assertEquals(leftFrameBody.getText(), "LEFT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        WebElement bottomFrameBody = driver.findElement(By.xpath("//body"));
        assertEquals(bottomFrameBody.getText(), "BOTTOM");
    }

    @AfterMethod
    public void afterTest() {
        if (driver != null)
            driver.quit();
    }
}
