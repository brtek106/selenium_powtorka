package Temat9.pageobjects;

import Temat9.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {

    @FindBy(css = "#Content a")
    private WebElement enterStoreLink;

    @Step("Click on Enter Store Link")
    public TopMenuPage clickOnEnterStoreLink() {
        WaitForElement.waitUntilElementIsClickable(enterStoreLink);
        enterStoreLink.click();
        log().info("Clicked on Enter Store Link");
        return new TopMenuPage();
    }
}
