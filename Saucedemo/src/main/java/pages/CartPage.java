package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    public String cartPageURL = ("https://www.saucedemo.com/cart.html");
    public By cartLinkForShopping = By.className("shopping_cart_link");
    public By bikelightSauceLabsremove = By.id("remove-sauce-labs-bike-light");
    public By shoppingContinue = By.id("continue-shopping");
}
