package Temat10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class GridExample {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.enablePersistentHovering();
        options.ignoreZoomSettings();
        options.setCapability("version", "8");

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }



    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
