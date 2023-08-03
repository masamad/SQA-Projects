package pages;

import org.openqa.selenium.By;

public class LogInPage extends BasePage{
    public String logInPageURL = "https://www.saucedemo.com/";
    public By userInputField = By.id("user-name");
    public By passwordInputField = By.id("password");
    public By loginButton = By.id("login-button");
    public By userName = By.id("login_credentials");
    public By password = By.className("login_password");
    public String errorMsg = "Epic sadface: Username and password do not match any user in this service";
    public By errorMsgLocator = By.tagName("h3");


    public String getUserName(){
        return getElementText(userName);
    }

    public String getPassword(){
        return getElementText(password);
    }


}
