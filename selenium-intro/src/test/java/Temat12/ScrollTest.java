package Temat12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ScrollTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://theinternet.przyklady.javastart.pl/large");
    }

    @Test
    public void scrollUsingJavaScriptTest() {
        WebElement lastElementInTheTable = driver.findElement(By.xpath("//*[@id=\"large-table\"]/tbody/tr[50]/td[50]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElementInTheTable);

        sleep();
        assertEquals(lastElementInTheTable.getText(), "50.50");
    }

    @Test
    public void scrollUsingMoveToElementTest() {
        WebElement lastElementInTheTable = driver.findElement(By.xpath("//*[@id=\"large-table\"]/tbody/tr[50]/td[50]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(lastElementInTheTable).perform();

        sleep();
        assertEquals(lastElementInTheTable.getText(), "50.50");
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterMethod
    public void afterTest() {
        if (driver != null)
            driver.quit();
    }
}
