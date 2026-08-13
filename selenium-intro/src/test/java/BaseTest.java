import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;
    public String baseUrl = "https://theinternet.przyklady.javastart.pl/dynamic_loading/2";

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
