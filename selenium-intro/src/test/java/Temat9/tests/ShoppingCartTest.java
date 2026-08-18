package Temat9.tests;

import Temat9.pageobjects.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTest extends TestBase {

    @Test
    public void asNotLoggedInUserIShallNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        LoginPage loginPage = new LoginPage();
        loginPage
                .clickOnFishImageButton()
                .clickOnAngelfishId()
                .clickOnAddToCartSmallAngelfish()
                .clickOnProceedToCheckout();

        assertEquals(loginPage.getWarningMessage(), "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
