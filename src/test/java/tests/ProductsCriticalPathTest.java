package tests;

import org.testng.annotations.Test;

public class ProductsCriticalPathTest extends BaseTest {
    @Test
    public void productShouldBeAddedIntoCart(){
     loginPage.open();
     loginPage.login("standard_user","secret_sauce");

     inventoryPage.addToCart("Sauce Labs Onesie");
    // cartPage.open();

     //TODO validate name and
    }
}
