package Temat14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class FactoryExampleTest {

    private WebDriver driver;
    private String query;
    private String expectedTitle;

    public FactoryExampleTest(String query, String expectedTitle) {
        this.query = query;
        this.expectedTitle = expectedTitle;
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.duckduckgo.com");
    }

    @Test
    public void factoryExampleTest() {
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys(query);
        searchField.submit();

        assertTrue(("Page title does not equals expected title"), driver.getTitle().equals(expectedTitle));
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    @Factory
    public static Object[] factoryMethod() {
        FactoryExampleTest firstTestToExecute = new FactoryExampleTest("Coffee", "Coffee at DuckDuckGo");
        FactoryExampleTest secondTestToExecute = new FactoryExampleTest("Java", "Java at DuckDuckGo");
        FactoryExampleTest thirdTestToExecute = new FactoryExampleTest("Selenium", "Selenium at DuckDuckGo");
        return new Object[] {
                firstTestToExecute,
                secondTestToExecute,
                thirdTestToExecute};
    }
}
