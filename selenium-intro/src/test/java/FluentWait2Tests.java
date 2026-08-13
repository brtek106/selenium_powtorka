import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FluentWait2Tests extends BaseTest {

    @Test
    public void fluentWaitWithExceptionTest() {
        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();


        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        WebElement helloWorldText = wait
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));

        assertTrue(helloWorldText.isDisplayed());
        assertEquals(helloWorldText.getText(), "Hello World!");
    }
}
