package Temat11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ListingTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://przyklady.javastart.pl/jpetstore/actions/Catalog.action");
    }

    @Test
    public void listingGoodExampleTest() {
        List<String> listOfHrefAttributes = new LinkedList<String>();
        listOfHrefAttributes.add("FISH");
        listOfHrefAttributes.add("DOGS");
        listOfHrefAttributes.add("REPTILES");
        listOfHrefAttributes.add("CATS");
        listOfHrefAttributes.add("BIRDS");

        listOfHrefAttributes.sort(String::compareToIgnoreCase);

        List<WebElement> leftNavigationLinksList = driver.findElements(By.xpath("//*[@id='SidebarContent']/a"));
        List<WebElement> topNavigationLinksList = driver.findElements(By.xpath("//*[@id='QuickLinks']/a"));
        List<WebElement> bottomNavigationLinksList = driver.findElements(By.xpath("//*[@id='MainImageContent']//area"));

        assertThatListIsCorrect(leftNavigationLinksList, listOfHrefAttributes);
        assertThatListIsCorrect(topNavigationLinksList, listOfHrefAttributes);
        assertThatListIsCorrect(bottomNavigationLinksList, listOfHrefAttributes);
    }

    private void assertThatListIsCorrect(List<WebElement> actualListOfWebElements, List<String> expectedListOfStrings) {
        List<String> listOfHrefAttributes = new LinkedList<>();

        for (WebElement leftNavigationLink : actualListOfWebElements) {
            assertTrue(leftNavigationLink.isDisplayed());
            String hrefCategory = leftNavigationLink.getAttribute("href").split("&categoryId=")[1];
            listOfHrefAttributes.add(hrefCategory);
        }
        listOfHrefAttributes.sort(String::compareToIgnoreCase);
        assertEquals(actualListOfWebElements.size(), expectedListOfStrings.size());
        assertEquals(Arrays.toString(listOfHrefAttributes.toArray()), Arrays.toString(expectedListOfStrings.toArray()));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
