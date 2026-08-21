package Temat9.tests;

import Temat9.drivermanager.DriverManager;
import Temat9.drivermanager.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static Temat9.navigation.ApplicationURLs.APPLICATION_URL;

public class TestBase {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
