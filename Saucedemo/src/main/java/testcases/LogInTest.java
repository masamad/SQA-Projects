package testcases;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProductPage;
import utilities.DataSet;
import utilities.DriversSetup;
import static org.testng.Assert.assertEquals;

public class LogInTest extends DriversSetup {
    LogInPage logInPage = new LogInPage();
    ProductPage productPage = new ProductPage();

    @Test(description = "Test Description for TestNG")
    @Description("Test Description From Allure")
    public void loginTest(){
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        logInPage.takeScreenShot("LogIn with Valid Credentials");
        assertEquals(getDriver().getCurrentUrl(), productPage.prodcutPageURL);
    }

    @Test(description = "Test Description for TestNG")
    @Description("Test Description From Allure")
    public void userNameTest(){
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_use");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauce");
        logInPage.clickOnElement(logInPage.loginButton);
        logInPage.takeScreenShot("Unsuccessful LogIn");
        assertEquals(logInPage.getElementText(logInPage.errorMsgLocator), logInPage.errorMsg);
    }

    @Test(description = "Test Description for TestNG")
    @Description("Test Description From Allure")
    public void passwordTest(){
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, "standard_user");
        logInPage.writeOnByLoctor(logInPage.passwordInputField,"secret_sauc");
        logInPage.clickOnElement(logInPage.loginButton);
        logInPage.takeScreenShot("Unsuccessful LogIn");
        assertEquals(logInPage.getElementText(logInPage.errorMsgLocator), logInPage.errorMsg);
    }

    @Test(description = "Test Description for TestNG", dataProvider = "credentials", dataProviderClass = DataSet.class)
    @Description("Test Description From Allure")
    public void userNamePasswordTest(String userName, String password) throws InterruptedException {
        getDriver().get(logInPage.logInPageURL);
        logInPage.writeOnByLoctor(logInPage.userInputField, userName);
        logInPage.writeOnByLoctor(logInPage.passwordInputField, password);
        logInPage.clickOnElement(logInPage.loginButton);
        logInPage.takeScreenShot("Unsuccessful LogIn");
        assertEquals(logInPage.getElementText(logInPage.errorMsgLocator), logInPage.errorMsg);
    }


}
