package Temat12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://theinternet.przyklady.javastart.pl/iframe");
    }

    @Test
    public void iframeTestNameOrId() {
        driver.switchTo().frame("mce_0_ifr");

        WebElement editableContentField = driver.findElement(By.id("tinymce"));
        editableContentField.clear();
        editableContentField.sendKeys("JavaStart");

        driver.switchTo().defaultContent();

        WebElement boldButton = driver.findElement(By.cssSelector("[aria-label='Bold'] button"));
        boldButton.click();
    }

    @Test
    public void iframeTestIndex() {
        driver.switchTo().frame(0);

        WebElement editableContentField = driver.findElement(By.id("tinymce"));
        editableContentField.clear();
        editableContentField.sendKeys("JavaStart");
    }

    @Test
    public void iframeTestWebElement() {
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement editableContentField = driver.findElement(By.id("tinymce"));
        editableContentField.clear();
        editableContentField.sendKeys("JavaStart");
    }

    @AfterMethod
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
