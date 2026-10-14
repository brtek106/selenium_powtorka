package Temat11;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotMaker {

    private WebDriver driver;

    public ScreenShotMaker(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("Screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
