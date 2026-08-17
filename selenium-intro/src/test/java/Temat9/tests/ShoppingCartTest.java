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
        loginPage.clickOnFishImageButton();

        FishListPage fishListPage = new FishListPage();
        fishListPage.clickOnAngelfishId();

        AngelfishListPage angelfishListPage = new AngelfishListPage();
        angelfishListPage.clickOnAddToCartSmallAngelfish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckout();

        assertEquals(loginPage.getWarningMessage(), "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
