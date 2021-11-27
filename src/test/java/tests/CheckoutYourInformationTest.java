package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

public class CheckoutYourInformationTest extends BaseTest {

    @Test
    public  void NextPageUnderCheckoutYourInformationPage(){
        checkoutYourInformation.criticalPathTest();
        checkoutYourInformation.open();
        checkoutYourInformation.nextPageCheckoutOverview();

        String overviewPage1 = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String overviewPage2 = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(overviewPage2,overviewPage1,"проверка правильности перехода на эту страницу");
    }
    @Test
    public void checkUserFirstName(){
        checkoutYourInformation.criticalPathTest();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("qwer","qwer","qwer");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(),"Тест в zip/postal code проошел без цифр BUG");
    }
    @Test
    public void checkUserLastName(){
        checkoutYourInformation.criticalPathTest();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("Bob","","12345");
        Assert.assertEquals(loginPage.getErrorMessage(),"Error: Last Name is required",
                "");
    }
    @Test
    public void checkZipOrPostalCode(){
        checkoutYourInformation.criticalPathTest();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("","Bruce","12345");
        Assert.assertEquals(loginPage.getErrorMessage(),"Error: First Name is required");
    }
    @Test
    public void pushContinue(){
        checkoutYourInformation.criticalPathTest();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("Bob","Bruce","");
        Assert.assertEquals(loginPage.getErrorMessage(),"Error: Zip/Postal code  is required");
    }
}
