package Temat11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.logging.Level;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;

public class LogExampleTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {

        //Ustawiamy potrzebny poziom logowania browser na INFO, analogicznie jak wyżej
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.INFO);
        chromeOptions.setCapability(ChromeOptions.LOGGING_PREFS, loggingPreferences);
        chromeOptions.merge(chromeOptions);

        driver = new ChromeDriver(chromeOptions);

        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void browserLogExampleTest() {
        WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        enterStoreLink.click();

        WebElement signOnLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signOnLink.click();

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("NotExistingLogin");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("NotProperPassword");

        WebElement signOnButton = driver.findElement(By.name("signon"));
        signOnButton.click();

        WebElement messageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));
        assertEquals("Invalid username or password. Signon failed.", messageLabel.getText());

        System.out.println("================== Logi przeglądarki (JavaScript Console) =======================");

        //Pobieramy logi z poziomu browser
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : browserLogs) {

            //Wyświetlamy wpis z rejestu logów
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());

            //Sprawdzamy czy wpis nie jest zakwalifikowany jako SEVERE, czyli błąd
            assertFalse(entry.getLevel().equals(Level.SEVERE));
        }
        System.out.println("=======================================================");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}