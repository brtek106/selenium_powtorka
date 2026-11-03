package Temat14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class ParametersFromTestNgXmlTests {

    protected WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://duckduckgo.com/");
    }

    @Parameters({"queryToSearch", "expectedTitle"})
    @Test
    public void parametersExampleTest(@Optional("JavaStart") String queryToSearch,
                                      @Optional("JavaStart at DuckDuckGo") String expectedTitle) {
        WebElement searchField = driver.findElement(By.cssSelector("#searchbox_homepage > div > textarea"));

        searchField.sendKeys(queryToSearch);
        searchField.submit();

        assertTrue(driver.getTitle().equals(expectedTitle));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
