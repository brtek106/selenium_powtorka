package Temat9.pageobjects;

import Temat9.driver.manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

}
