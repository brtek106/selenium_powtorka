import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement user1 = driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > img"));
        WebElement user2 = driver.findElement(By.cssSelector("#content > div > div:nth-child(4) > img"));
        WebElement user3 = driver.findElement(By.cssSelector("#content > div > div:nth-child(5) > img"));


        Actions actions = new Actions(driver);
        actions.moveToElement(user1).perform();

        sleep();

        WebElement user1Text = driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5"));
        WebElement user2Text = driver.findElement(By.cssSelector("#content > div > div:nth-child(4) > div > h5"));
        WebElement user3Text = driver.findElement(By.cssSelector("#content > div > div:nth-child(5) > div > h5"));

        assertEquals(user1Text.getText(), "name: user1");
        assertEquals(user2Text.getText(), "");
        assertEquals(user3Text.getText(), "");

        sleep();

        actions.moveToElement(user2).perform();
        sleep();
        assertEquals(user1Text.getText(), "");
        assertEquals(user2Text.getText(), "name: user2");
        assertEquals(user3Text.getText(), "");

        sleep();

        actions.moveToElement(user3).perform();
        sleep();
        assertEquals(user1Text.getText(), "");
        assertEquals(user2Text.getText(), "");
        assertEquals(user3Text.getText(), "name: user3");


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
