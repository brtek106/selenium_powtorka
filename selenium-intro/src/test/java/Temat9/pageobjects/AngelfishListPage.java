package Temat9.pageobjects;

import Temat9.drivermanager.DriverManager;
import Temat9.waits.WaitForElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelfishListPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement smallAngelfishAddToCartButton;

    public AngelfishListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public ShoppingCartPage clickOnAddToCartSmallAngelfish() {
        WaitForElement.waitUntilElementIsVisible(smallAngelfishAddToCartButton);
        smallAngelfishAddToCartButton.click();
        logger.info("Clicked small angelfish add to cart");
        return new ShoppingCartPage();
    }
}
