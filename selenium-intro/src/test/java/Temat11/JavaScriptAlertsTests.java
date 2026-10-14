package Temat11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavaScriptAlertsTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/javascript_alerts");
    }

    @Test
    public void javaScriptAlertTest() {
        WebElement jsAlertButton = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
        jsAlertButton.click();
        driver.switchTo().alert().accept();

        WebElement message = driver.findElement(By.cssSelector("p[id='result']"));
        assertEquals(message.getText(), "You successfuly clicked an alert");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
