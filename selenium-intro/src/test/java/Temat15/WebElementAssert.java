package Temat15;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    private WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement actual) {
        return new WebElementAssert(actual);
    }

    public WebElementAssert hasText(String expectedText) {
        isNotNull();

        String actualText = actual.getText();
        if (!actualText.equals(expectedText)) {
            failWithMessage("Expected text to be <%s> but was <%s>", expectedText, actualText);
        }
        return this;
    }

    public WebElementAssert hasAttribute(String attributeName, String expectedValue) {
        isNotNull();

        String actualValue = actual.getAttribute(attributeName);
        if (!actualValue.equals(expectedValue)) {
            failWithMessage("Expected attribute <%s> to be <%s> but was <%s>", attributeName, expectedValue, actualValue);
        }
        return this;
    }

    public WebElementAssert isDisplayed() {
        isNotNull();

        if(!actual.isDisplayed()) {
            failWithMessage("Expected element to be displayed");
        }
        return this;
    }

    public WebElementAssert isEnabled() {
        isNotNull();

        if(!actual.isEnabled()) {
            failWithMessage("Expected element to be enabled");
        }
        return this;
    }

    public WebElementAssert isButton() {
        isNotNull();

        if(!(actual.getTagName().equalsIgnoreCase("button") || actual.getAttribute("type").equalsIgnoreCase("button"))) {
            failWithMessage("Expected element to be button!");
        }
        return this;
    }

    public WebElementAssert isLink() {
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("a")) {
            failWithMessage("Expected element to be link!");
        }
        return this;
    }
}
