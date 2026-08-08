import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest() {
        WebElement fileUploadButton = driver.findElement(By.id("file-upload"));
        fileUploadButton.sendKeys("C:\\Gry\\testfile.txt");

        driver.findElement(By.id("file-submit")).click();
        sleep();

        WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));

        assertEquals(uploadedFiles.getText(), "testfile.txt");
    }

    public void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
