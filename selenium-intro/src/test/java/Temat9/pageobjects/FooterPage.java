package Temat9.pageobjects;

import Temat9.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static Temat9.generic.assertions.AssertWebElement.assertThat;

public class FooterPage extends BasePage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

    @Step("Assert that element dog banner is displayed")
    public FooterPage assertThatDogBannerIsDisplayed() {
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        assertThat(bannerAfterLoginLogo).isDisplayed();
        return this;
    }
}
