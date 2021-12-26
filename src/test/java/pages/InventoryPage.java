package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() {

        driver.get("https://www.saucedemo.com/cart.html");
    }

    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }

    public String getPriceByName(String nameProduct) {
        return driver.findElement(By.xpath(String.format(" ", nameProduct))).getText();
    }
}
