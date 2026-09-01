package Temat9.driver.manager;

import Temat9.driver.BrowserFactory;
import Temat9.driver.BrowserType;
import Temat9.driver.listeners.WebDriverEventListenerRegistrar;
import org.openqa.selenium.WebDriver;

import static Temat9.configuration.TestRunProperties.getBrowserToRun;
import static Temat9.configuration.TestRunProperties.getIsRemoteRun;
import static Temat9.driver.BrowserType.CHROME;

public class DriverManager {

    //Dwie zmienne instancji klasy ThreadLocal przechowujące kolejno instancję obiektu WebDriver oraz BrowserType dla danego wątku
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setWebDriver(BrowserType browserType) {

        WebDriver browser = null;

        if (browserType == null) {

            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        } else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        browser = WebDriverEventListenerRegistrar.registerWebDriverEventListener(browser);

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }

    public static WebDriver getWebDriver() {

        if (webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver Instance was null! Please create instance of WebDriver using setWebDriver!");
        }

        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();

        if (!browserTypeThreadLocal.get().equals(CHROME)) {
            webDriverThreadLocal.get().quit();
        }

        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}