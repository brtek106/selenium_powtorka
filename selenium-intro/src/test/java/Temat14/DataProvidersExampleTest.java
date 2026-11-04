package Temat14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataProvidersExampleTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "myLocalDataProvider")
    public void localDataProviderTest(String query, String expectedTitle) {

        driver.navigate().to("https://duckduckgo.com");
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).submit();

        String pageTitle = driver.getTitle();

        assertEquals(pageTitle, expectedTitle);
    }

    @AfterClass
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    @DataProvider(name = "myLocalDataProvider")
    public Object[][] queriesTestData() {
        Object[][] testDataArray = {
                {"JavaStart", "JavaStart at DuckDuckGo"},
                {"Selenium", "Selenium at DuckDuckGo"},
                {"TestNG", "TestNG at DuckDuckGo"}
        };
        return testDataArray;
    }
}
