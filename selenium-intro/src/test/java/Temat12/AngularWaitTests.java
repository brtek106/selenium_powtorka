package Temat12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AngularWaitTests {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void angular1WaitTest() {
        driver.get("https://angularjs.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(waitForAngularToFinishProcessingRequests());
    }

    @Test
    public void angular2WaitTest() {
        driver.navigate().to("https://demos.creative-tim.com/paper-dashboard-angular/dashboard");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(waitForAngularIoToFinishProcessing());
    }

    @AfterMethod
    public void afterTest() {
        if (driver != null)
            driver.quit();
    }

    public static ExpectedCondition<Boolean> waitForAngularToFinishProcessingRequests() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                String result = executor.executeScript("" +
                        "if (window.angular == undefined) " +
                        "{return false} " +
                        "else{ " +
                        "var injector = window.angular.element('body').injector();" +
                        "return injector.get('$http').pendingRequests.length === 0" +
                        "}").toString();
                return Boolean.valueOf(result);
            }
        };
    }

    public static ExpectedCondition<Boolean> waitForAngularIoToFinishProcessing() {
        return new
                ExpectedCondition<Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        String result = ((JavascriptExecutor) driver).executeScript(
                                "try {\n" +
                                        "var angular = window.getAllAngularTestabilities();\n" + // Sprawdzamy czy Angular jest dostępny, jeśli Angular nie był by gotowy, zostanie rzucony wyjątek i kod zwróci fałsz
                                        "var isStableIndex = window.getAllAngularTestabilities().findIndex(x=>x.isStable());" + // Ponieważ obiekt Teststabilies jest tablicą, szukamy w nim indeksu metody isStable()
                                        "return angular[isStableIndex].isStable()" + // Pobieramy wartość z metody isStable()
                                        "} catch (err){\n" +
                                        "return false\n" + // Jeśli aplikacja nie jest gotowa, zostanie rzucony wyjątek, co jest równoznaczne z fałszem i brakiem gotowości / stabilności
                                        "}"
                        ).toString();
                        return Boolean.valueOf((result));
                    }
                };
    }
}
