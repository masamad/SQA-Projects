package pages;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.ByteArrayInputStream;
import java.util.Locale;

import static utilities.DriversSetup.getDriver;


public class BasePage {

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnByLoctor(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public void selectItemByIndex(WebElement element, int index) {
        Select selectItems = new Select(element);
        selectItems.selectByIndex(index);
    }


    /****************************
     * Faker Related Task Start*
     ****************************
     */
    static Faker faker = new Faker(new Locale("en-US"));

    public static String email;

    public static String emailGenerate() {
        email = faker.bothify("????##@mail.com");
        return email;
    }

    public static String firstName;

    public static String firstNameGenerate() {
        firstName = faker.name().firstName();
        return firstName;
    }

    public static String lastName;

    public static String lastNameGenerate() {
        lastName = faker.name().lastName();
        return lastName;
    }

    public static String phoneNumber;

    public String phoneNumberGenerate() {
        phoneNumber = faker.numerify("###-###-####");
        return phoneNumber;
    }

    public static String password;

    public String passwordGenerate() {
        password = faker.animal().name();
        return password;
    }
    /****************************
     * Faker Related Task End*
     ****************************
     */

    public void takeScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)(getDriver())).getScreenshotAs(OutputType.BYTES)));
    }
}

