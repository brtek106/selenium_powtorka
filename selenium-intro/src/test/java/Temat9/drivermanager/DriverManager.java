package Temat9.drivermanager;

import org.openqa.selenium.WebDriver;

import static Temat9.configuration.TestRunProperties.getBrowserToRun;
import static Temat9.configuration.TestRunProperties.getIsRemoteRun;
import static Temat9.drivermanager.BrowserType.CHROME;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        //Sprawdzenie czy wartość zmiennej WebDrivera dla danego wątku jest nullem
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser());
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
     webDriverThreadLocal.get().close();
     if (!getBrowserToRun().equals(CHROME)) {
         webDriverThreadLocal.get().quit();
     }
     webDriverThreadLocal.remove();
    }
}
