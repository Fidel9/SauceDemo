import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest extends BasicTest {
    String userName = "//input[@name='user-name']";
    String passwordUser = "password";
    String loginButton = "[name='login-button']";
    //  String thingsFromCatalog = "//div[@class='inventory_item_name']";
    // String priceThingsFromCatalog = "//div[@class='inventory_item_price']";
    // String buttonItem = "//button[@id='add-to-cart-sauce-labs-backpack']";
    // String cartLink = "//a[@class='shopping_cart_link']";
    // String thingsForCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
    //  String priceThingsForCartItem = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();


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

        // String thingsFromCatalog2 = driver.findElement(By.xpath("")).getText();

        WebElement buttonItem = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        buttonItem.click();
        WebElement cartLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cartLink.click();

        String thingsForCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        String priceThingsForCartItem = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();

        Assert.assertEquals(thingsForCart, thingsFromCatalog);
        Assert.assertEquals(priceThingsForCartItem, priceThingsFromCatalog);
    }
}
