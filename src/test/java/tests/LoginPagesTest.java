package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

public class LoginPagesTest extends BaseTest {
    String userName = "//input[@name='user-name']";
    String passwordUser = "password";
    String loginButton = "[name='login-button']";


    @Test
    public  void checkingAddingToCart(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        //TODO add checks after login
    }



    @Test
    public void criticalPathTest() {
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
    @Test
    public void usrNameShouldBeRequired(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required",
                "Собщение об ошибке не верно");
    }
    @Test
    public void passwordShouldBeRequired(){
        loginPage.open();
        loginPage.login("standard_user","");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required",
                "Собщение об ошибке не верно");
    }
    @Test
    public void UserDataBeRequired(){
        loginPage.open();
        loginPage.login("abcd","abc");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service",
                "Собщение об ошибке не верно");
    }
    @Test
    public void lockedUser(){
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.",
                "Собщение об ошибке не верно");
    }
}
