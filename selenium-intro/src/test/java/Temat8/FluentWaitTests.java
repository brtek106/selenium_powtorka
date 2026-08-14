package Temat8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FluentWaitTests extends BaseTest {

    @Test
    public void fluentWaitTest() {
        WebElement helloWorldMessage = driver.findElement(By.cssSelector("#finish h4"));
        assertFalse(helloWorldMessage.isDisplayed());

        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait
                .pollingEvery(Duration.ofMillis(250))
                .withTimeout(Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(helloWorldMessage));

        assertTrue(helloWorldMessage.isDisplayed());
    }
}
