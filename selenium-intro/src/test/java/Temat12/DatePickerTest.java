package Temat12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DatePickerTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void datePickerTest() {
        String dateInPast = "06/01/2015";

        DatePicker datePicker = new DatePicker(driver);
        datePicker.openDatePicker();
        datePicker.setDate(dateInPast);

        String selectedDate = datePicker.getSelectedDate();

        assertEquals(selectedDate, dateInPast);
    }

    @Test
    public void injectIntoDatePickerTest() {
        String dateInPast = "06/01/2015";
        String datePickerCssSelector = "#datepicker";

        WebElement datePicker = driver.findElement(By.cssSelector(datePickerCssSelector));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "$('%s').val('%s').change();";

        javascriptExecutor.executeScript(String.format(script, datePickerCssSelector, dateInPast));

        String selectedDate = datePicker.getAttribute("value");

        assertEquals(selectedDate, dateInPast);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
