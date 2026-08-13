import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class MyFirstTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void myFirstTest() {
        driver.findElement(By.cssSelector("#Content a")).click();
        driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']")).click();
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("admin");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin");

        driver.findElement(By.name("signon")).click();
        assertEquals(driver.findElement(By.cssSelector("#Content ul[class='messages'] li")).getText(), "Invalid username or password. Signon failed.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
