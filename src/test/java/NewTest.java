import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NewTest extends BasicTest{
    String searchWithAttribute = "//div[@class='page_wrapper']";
    String getSearchWithText = "//div[text()='Sauce Labs Backpack']";
    String attributeContains = "//div[contains(@class,'login_password')]";
    String textText = "//h4[contains(text(),'usernames are:')]";
    String ancestor = "";

    @Test
    public void searcshLocator() {
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath(searchWithAttribute));
        driver.findElement(By.xpath(getSearchWithText));
        driver.findElement(By.xpath(attributeContains));
        driver.findElement(By.xpath(textText));
        driver.findElement(By.xpath(ancestor));
       /*driver.findElement();
        driver.findElement();
        driver.findElement();
        driver.findElement();
        driver.findElement();
        driver.findElement();*/
    }
}
