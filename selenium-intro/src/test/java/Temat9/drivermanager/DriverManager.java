package Temat9.drivermanager;

import org.openqa.selenium.WebDriver;

import static Temat9.configuration.TestRunProperties.getBrowserToRun;
import static Temat9.configuration.TestRunProperties.getIsRemoteRun;
import static Temat9.drivermanager.BrowserType.CHROME;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!getBrowserToRun().equals(CHROME)) {
            driver.quit();
        }
        driver = null;
    }
}
