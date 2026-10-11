package Temat11;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest {
    private WebDriver driver = new ChromeDriver();

    @Test
    public void screenshotTest() {
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File("Screenshots/selenium_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
