import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/checkboxes");
        driver.manage().window().maximize();
    }

    @Test
    public void checkboxesTest() {
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(1)"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkboxes > input[type=checkbox]:nth-child(3)"));

        assertFalse(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());

        sleep();

        checkbox1.click();
        checkbox2.click();

        sleep();

        assertTrue(checkbox1.isSelected());
        assertFalse(checkbox2.isSelected());
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
