package Temat9.tests;

import Temat9.configuration.ConfigurationProperties;
import Temat9.configuration.PropertiesLoader;
import Temat9.drivermanager.BrowserType;
import Temat9.drivermanager.DriverManager;
import Temat9.drivermanager.DriverUtils;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import java.util.Properties;

import static Temat9.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeClass() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader.getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting up browser to: {browserType} and navigating to Home Page")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
