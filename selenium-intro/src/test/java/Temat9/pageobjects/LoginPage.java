package Temat9.pageobjects;

import Temat9.drivermanager.DriverManager;
import Temat9.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(name = "signon")
    private WebElement signOnButton;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement messageLabel;

    @FindBy(css = "area[alt='Fish']")
    private WebElement btnFishImage;

    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        logger.info("Typed into User Name Field {}", username);
    }

    public void typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logger.info("Typed into Password Field {}", password);
    }

    public void clickOnLoginButton() {
        signOnButton.click();
        logger.info("Clicked on Login Button");
    }

    public String getWarningMessage() {
        WaitForElement.waitUntilElementIsVisible(messageLabel);
        String warningText = messageLabel.getText();
        logger.info("Returned warning message was: {}", warningText);
        return warningText;
    }

    public void clickOnFishImageButton() {
        btnFishImage.click();
    }
}
