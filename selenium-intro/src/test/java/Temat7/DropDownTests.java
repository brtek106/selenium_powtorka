package Temat7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/dropdown");
    }

    @Test
    public void dropDownTest() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);

        assertEquals(select.getFirstSelectedOption().getText(), "Please select an option");

        select.selectByValue("1");
        sleep();
        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");

        select.selectByValue("2");
        sleep();
        assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
        sleep();
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
