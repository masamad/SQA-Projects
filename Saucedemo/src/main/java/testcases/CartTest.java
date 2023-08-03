package testcases;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DriversSetup;

import static org.testng.Assert.assertEquals;

public class CartTest extends DriversSetup {

    LogInPage logInPage = new LogInPage();
    CartPage cartPage = new CartPage();
    ProductPage productPage = new ProductPage();

    @Test
    public void cartAddRemoveTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        cartPage.clickOnElement(cartPage.bikelightSauceLabsremove);
        Thread.sleep(3000);
        assertEquals(getDriver().getCurrentUrl(), cartPage.cartPageURL);
    }

    @Test
    public void cartTestShoppingContinue() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        Thread.sleep(3000);
        cartPage.clickOnElement(cartPage.shoppingContinue);
        Thread.sleep(3000);
        getDriver().get(productPage.prodcutPageURL);
        Thread.sleep(3000);
        assertEquals(getDriver().getCurrentUrl(),productPage.prodcutPageURL);

    }
}
