package pages;

import org.openqa.selenium.By;

public class CheckOutPage extends BasePage{
    public By checkout = By.id("checkout");
    public String checkOutpageURL = ("https://www.saucedemo.com/checkout-step-one.html");
    public By firstName = By.id("first-name");
    public By lastName = By.id("last-name");
    public By postalCode = By.id("postal-code");
    public By cancelBtn = By.id("cancel");
    public By continueBtn = By.id("continue");
    public By continueCancelBtn = By.id("cancel");

    public String checkOutPageFinishURL =("https://www.saucedemo.com/checkout-step-two.html");
    public By finishBtn = By.id("finish");
    public String checkOutPageCompleteURL =("https://www.saucedemo.com/checkout-complete.html");
    public By backHome = By.id("back-to-products");
}
