package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutYourInformationPage extends BasePage {
    public static final By USERNAME_INPUT_CHECK_INFO = By.id("first-name");
    public static final By LASTNAME_INPUT_CHECK_INFO = By.id("last-name");
    public static final By ZIP_POSTAL_INPUT_CHECK_INFO = By.id("postal-code");
    public static final By CONTINUE_BUTTON_CHECK_INFO = By.id("continue");
    public static final By ERROR_MESSAGE_CHECK_INFO = By.xpath("//div[@class='error-message-container error']");

    public static final By LAST_PAGE = By.xpath("//span[@class='title']");

    String userName = "//input[@name='user-name']";
    String passwordUser = "password";
    String loginButton = "[name='login-button']";


    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
    }

    public void checkInfoNameAndLastName(String firstName, String lastName, String zipOrPost) {
        driver.findElement(USERNAME_INPUT_CHECK_INFO).sendKeys(firstName);
        driver.findElement(LASTNAME_INPUT_CHECK_INFO).sendKeys(lastName);
        driver.findElement(ZIP_POSTAL_INPUT_CHECK_INFO).sendKeys(zipOrPost);
        driver.findElement(CONTINUE_BUTTON_CHECK_INFO).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE_CHECK_INFO).getText();
    }

    public void criticalPath() {
        driver.get("https://www.saucedemo.com/");
        WebElement userNameElement = driver.findElement(By.xpath(userName));
        userNameElement.sendKeys(driver.findElement(By.xpath("//div[@id='login_credentials']"))
                .getText()
                .split("\\r?\\n")[1]);


        WebElement passwordUserElement = driver.findElement(By.id(passwordUser));
        passwordUserElement.sendKeys(driver.findElement(By.xpath("//div[@class='login_password']"))
                .getText()
                .split("\\r?\\n")[1]);

        WebElement loginButtonPress = driver.findElement(By.cssSelector(loginButton));
        loginButtonPress.click();

        WebElement buttonItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        buttonItem.click();
        WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();
    }

    public void nextPageCheckoutOverview() {
        driver.findElement(LAST_PAGE);
    }

}
