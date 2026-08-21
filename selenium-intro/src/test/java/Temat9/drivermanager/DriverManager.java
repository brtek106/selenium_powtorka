package Temat9.drivermanager;

import Temat9.configuration.LocalWebDriverProperties;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = BrowserFactory.getBrowser(LocalWebDriverProperties.getLocalBrowser());
        }
        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!LocalWebDriverProperties.getLocalBrowser().equals(BrowserType.CHROME)) {
            driver.quit();
        }
        driver = null;
    }
}
