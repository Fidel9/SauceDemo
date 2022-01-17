package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;
import utils.AllureUtils;


@Log4j2
public class LoginPagesTest extends BaseTest {
    String userName = "//input[@name='user-name']";
    String passwordUser = "password";
    String loginButton = "[name='login-button']";


    @Test
    public  void checkingAddingToCart(){
        log.info("проверка userName и пассворд");
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        //TODO add checks after login
    }

    @Test
    public void criticalPathTest() {
        log.info("проверяет вход на страницу userName и password");
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

        String thingsFromCatalog = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        String priceThingsFromCatalog = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();

        WebElement buttonItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        buttonItem.click();
        WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();

        String thingsForCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        String priceThingsForCartItem = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();

        Assert.assertEquals(thingsForCart, thingsFromCatalog);
        Assert.assertEquals(priceThingsForCartItem, priceThingsFromCatalog);
    }
    @Test(description = "Username should be required")
    public void usrNameShouldBeRequired(){
        log.info("проверка ввода имени");
        loginPage.open();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required",
                "Собщение об ошибке не верно");
    }
    @Test(description = "Password should be required")
    public void passwordShouldBeRequired(){
        log.info("проверка пассворда");
        loginPage.open();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required",
                "Собщение об ошибке не верно");
    }
    @Test(description = "Userdata should be required")
    public void UserDataBeRequired(){
        log.info("проверка user-Name и Password");
        loginPage.open();
        loginPage.login("abcd","abc");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service",
                "Собщение об ошибке не верно");
        AllureUtils.takeScreenshot(driver);
    }
    @Test(description = "Locked User")
    public void lockedUser(){
        log.info("Locked User");
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.",
                "Собщение об ошибке не верно");
    }
}
