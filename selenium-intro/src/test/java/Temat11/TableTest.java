package Temat11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TableTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://theinternet.przyklady.javastart.pl/tables");
    }

    @Test
    public void traversingTable1() {
        Table table = new Table(driver, By.id("table1"));

        int numberOfRows = table.getNumberOfRows();
        int numberOfColumns = table.getNumberOfColumns();

        int expectedNumberOfRows = 4;
        int expectedNumberOfColumns = 6;

        assertEquals(numberOfRows, expectedNumberOfRows);
        assertEquals(numberOfColumns, expectedNumberOfColumns);

        int firstRowIndex = 0;
        int lastRowIndex = numberOfRows - 1;

        WebElement lastNameFirstRow = table.getLastNameForRow(firstRowIndex);
        WebElement lastNameLastRow = table.getLastNameForRow(lastRowIndex);

        assertEquals(lastNameFirstRow.getText(), "Smith");
        assertEquals(lastNameLastRow.getText(), "Conway");

        WebElement webSiteFirstRow = table.getWebSiteForRow(firstRowIndex);
        WebElement webSiteLastRow = table.getWebSiteForRow(lastRowIndex);

        assertEquals(webSiteFirstRow.getText(), "http://www.jsmith.com");
        assertEquals(webSiteLastRow.getText(), "http://www.timconway.com");
    }

    @Test
    public void traversingTable2() {
        Table table = new Table(driver, By.id("table2"));

        int numberOfRows = table.getNumberOfRows();
        int numberOfColumns = table.getNumberOfColumns();

        int expectedNumberOfRows = 4;
        int expectedNumberOfColumns = 6;

        assertEquals(numberOfRows, expectedNumberOfRows);
        assertEquals(numberOfColumns, expectedNumberOfColumns);

        int firstRowIndex = 0;
        int lastRowIndex = numberOfRows - 1;

        WebElement lastNameFirstRow = table.getLastNameForRow(firstRowIndex);
        WebElement lastNameLastRow = table.getLastNameForRow(lastRowIndex);

        assertEquals(lastNameFirstRow.getText(), "Smith");
        assertEquals(lastNameLastRow.getText(), "Conway");

        WebElement webSiteFirstRow = table.getWebSiteForRow(firstRowIndex);
        WebElement webSiteLastRow = table.getWebSiteForRow(lastRowIndex);

        assertEquals(webSiteFirstRow.getText(), "http://www.jsmith.com");
        assertEquals(webSiteLastRow.getText(), "http://www.timconway.com");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
