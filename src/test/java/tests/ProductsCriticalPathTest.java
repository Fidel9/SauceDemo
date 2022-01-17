package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class ProductsCriticalPathTest extends BaseTest {
    @Test
    public void productShouldBeAddedIntoCart(){
     loginPage.open();
     loginPage.login("standard_user","secret_sauce");
     log.info("вход на страницу проверяет userName и password");

     inventoryPage.addToCart("Sauce Labs Onesie");
    // cartPage.open();
        log.info("проверяет добавление продукта в карзиру");

     //TODO validate name and
    }
}
