package testcases;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DriversSetup;

import static org.testng.Assert.assertEquals;

public class CheckOutTest extends DriversSetup {
    LogInPage logInPage = new LogInPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    @Test
    public void checkOutTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        checkOutPage.clickOnElement(checkOutPage.checkout);
        getDriver().get(checkOutPage.checkOutpageURL);
        Thread.sleep(3000);
        assertEquals(getDriver().getCurrentUrl(),checkOutPage.checkOutpageURL);
    }

    @Test
    public void checkOutCancelTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        Thread.sleep(3000);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        Thread.sleep(3000);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        Thread.sleep(3000);
        checkOutPage.clickOnElement(checkOutPage.checkout);
        getDriver().get(checkOutPage.checkOutpageURL);
        Thread.sleep(3000);
        checkOutPage.clickOnElement(checkOutPage.cancelBtn);
        getDriver().get(cartPage.cartPageURL);
        assertEquals(getDriver().getCurrentUrl(),cartPage.cartPageURL);
    }

    @Test
    public void checkOutContinueTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        checkOutPage.clickOnElement(checkOutPage.checkout);
        getDriver().get(checkOutPage.checkOutpageURL);
        checkOutPage.writeOnByLoctor(checkOutPage.firstName, "ABC");
        checkOutPage.writeOnByLoctor(checkOutPage.lastName, "abc");
        checkOutPage.writeOnByLoctor(checkOutPage.postalCode, "123");
        checkOutPage.clickOnElement(checkOutPage.continueBtn);
        Thread.sleep(3000);
        assertEquals(getDriver().getCurrentUrl(),checkOutPage.continueBtn);
    }

    @Test
    public void checkOutContinueCancelTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        checkOutPage.clickOnElement(checkOutPage.checkout);
        getDriver().get(checkOutPage.checkOutpageURL);
        checkOutPage.writeOnByLoctor(checkOutPage.firstName, "ABC");
        checkOutPage.writeOnByLoctor(checkOutPage.lastName, "abc");
        checkOutPage.writeOnByLoctor(checkOutPage.postalCode, "123");
        checkOutPage.clickOnElement(checkOutPage.continueBtn);
        Thread.sleep(3000);
        checkOutPage.clickOnElement(checkOutPage.continueCancelBtn);
        getDriver().get(productPage.prodcutPageURL);
        Thread.sleep(3000);
        assertEquals(getDriver().getCurrentUrl(),productPage.prodcutPageURL);
    }

    @Test
    public void checkOutContinueFinishTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        checkOutPage.clickOnElement(checkOutPage.checkout);
        getDriver().get(checkOutPage.checkOutpageURL);
        checkOutPage.writeOnByLoctor(checkOutPage.firstName, "ABC");
        checkOutPage.writeOnByLoctor(checkOutPage.lastName, "abc");
        checkOutPage.writeOnByLoctor(checkOutPage.postalCode, "123");
        checkOutPage.clickOnElement(checkOutPage.continueBtn);
        Thread.sleep(3000);
        checkOutPage.clickOnElement(checkOutPage.finishBtn);
        getDriver().get(checkOutPage.checkOutPageCompleteURL);
        Thread.sleep(3000);
        assertEquals(getDriver().getCurrentUrl(),checkOutPage.checkOutPageCompleteURL);
    }

    @Test
    public void checkOutContinueFinishBackHomeTest() {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        cartPage.clickOnElement(cartPage.cartLinkForShopping);
        checkOutPage.clickOnElement(checkOutPage.checkout);
        getDriver().get(checkOutPage.checkOutpageURL);
        checkOutPage.writeOnByLoctor(checkOutPage.firstName, "ABC");
        assertEquals(getDriver().findElement(checkOutPage.firstName).getAttribute("value"),"ABC");
        checkOutPage.writeOnByLoctor(checkOutPage.lastName, "abc");
        assertEquals(getDriver().findElement(checkOutPage.lastName).getAttribute("value"),"abc");
        checkOutPage.writeOnByLoctor(checkOutPage.postalCode, "123");
        assertEquals(getDriver().findElement(checkOutPage.postalCode).getAttribute("value"),"123");
        checkOutPage.clickOnElement(checkOutPage.continueBtn);
        checkOutPage.clickOnElement(checkOutPage.finishBtn);
        getDriver().get(checkOutPage.checkOutPageCompleteURL);
        checkOutPage.clickOnElement(checkOutPage.backHome);
        getDriver().get(productPage.prodcutPageURL);


    }
}
