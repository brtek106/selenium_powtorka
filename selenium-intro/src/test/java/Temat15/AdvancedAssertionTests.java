package Temat15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AdvancedAssertionTests {

    private WebDriver driver;

    @Test
    public void testMethod() {
        int actualNumber = 42;
        assertThat(actualNumber).isEqualTo(42);

        String actualString = "Hello World";
        assertThat(actualString).startsWith("Hello");

        List<String> actualList = Arrays.asList("apple", "banana", "orange");
        assertThat(actualList).contains("banana");

        boolean actualValue = true;
        assertThat(actualValue).isTrue();

        boolean anotherValue = false;
        assertThat(anotherValue).isFalse();

        assertThat(actualNumber).isNotEqualTo(0);

        Throwable thrown = catchThrowable(() -> {
            throw new IllegalArgumentException("Invalid argument");
        });

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Invalid argument");

        assertThat(actualList).hasSize(3);

        assertThat(actualList).allMatch(element -> Character.isLowerCase(element.charAt(0)));

        assertThat(actualList).containsOnlyOnce("banana", "orange");
    }

    @Test
    void customAssertionsTest() {
        WebElement element = driver.findElement(By.id("element-id"));

        WebElementAssert.assertThat(element).hasText("JavaStart").hasAttribute("class", "heading");
        WebElementAssert.assertThat(element).isDisplayed().isEnabled().isLink();
    }
}
