package testcases;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DriversSetup;

import static org.testng.Assert.assertEquals;

public class ProductTest extends DriversSetup {

    ProductPage productPage = new ProductPage();
    LogInPage logInPage = new LogInPage();
    CartPage cartPage = new CartPage();
    LogInTest logInTest = new LogInTest();

    @Test
    public void fakeDataCreateTest(){
        System.out.println(productPage.emailGenerate());
        System.out.println(productPage.firstNameGenerate());
        System.out.println(productPage.lastNameGenerate());
    }

    @Test
    public void productFilterTest() throws InterruptedException {
        logInTest.loginTest();
        Thread.sleep(3000);
        productPage.selectItemByIndex(productPage.getElement(productPage.filter), 2);
    }

    @Test
    public void productAddTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.backPackAddToCartBtn);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        Thread.sleep(3000);
        assertEquals(getDriver().getCurrentUrl(), productPage.prodcutPageURL);
    }

    @Test
    public void productRemoveTest() throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        productPage.clickOnElement(productPage.backPackAddToCartBtn);
        productPage.clickOnElement(productPage.lightBikeAddToCartBtn);
        productPage.clickOnElement(productPage.backpackRemoveToCartBtn);
        assertEquals(getDriver().getCurrentUrl(), productPage.prodcutPageURL);
    }


}
