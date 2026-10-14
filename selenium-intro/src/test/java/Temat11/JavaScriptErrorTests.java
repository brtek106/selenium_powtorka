package Temat11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Level;

import static org.testng.Assert.*;

public class JavaScriptErrorTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/javascript_error");
    }

    @Test
    public void javaScriptErrorInConsoleTest() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        assertFalse(isErrorPresent(logEntries, "TypeError"), "JavaScript error should not be present on the page!");
    }

    private boolean isErrorPresent(LogEntries logEntries, String errorName) {
        boolean errorPresent = false;

        for (LogEntry logEntry : logEntries) {
            if (logEntry.getMessage().contains(errorName)) {
                System.out.println("There was an error on the page: " + logEntry.toString());
                errorPresent = true;
                continue;
            }
            System.out.println("Log Entry does not contain TypeError");
        }
        return errorPresent;
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
