package Temat9.pageobjects;

import Temat9.waits.WaitForElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {

    @FindBy(css = "#MenuContent a[href*='signonForm']")
    private WebElement signOnLink;

    @Step("Click on Sign In Link")
    public LoginPage clickOnSignInLink() {
        WaitForElement.waitUntilElementIsClickable(signOnLink);
        signOnLink.click();
        log().info("Clicked on Sign On Link");
        return new LoginPage();
    }
}
