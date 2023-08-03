package pages;

import io.qameta.allure.internal.shadowed.jackson.core.async.ByteBufferFeeder;
import org.openqa.selenium.By;

public class ProductPage extends BasePage{

    public String productPageTitle = "secret_sauce";
    public String prodcutPageURL = "https://www.saucedemo.com/inventory.html";
    public By filter = By.className("product_sort_container");
    public By backPackAddToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    public By backpackRemoveToCartBtn = By.id("remove-sauce-labs-backpack");
    public By lightBikeAddToCartBtn = By.id("add-to-cart-sauce-labs-bike-light");

    public By shoppingCartLink = By.className("shopping_cart_link");
}
