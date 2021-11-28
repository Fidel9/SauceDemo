package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutYourInformationTest extends BaseTest {

    @Test
    public void nextPageUnderCheckoutYourInformation() {
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.nextPageCheckoutOverview();

        String textFromTitle = driver.findElement(By.xpath("//span[@Class='title']")).getText();
        Assert.assertEquals(textFromTitle, "CHECKOUT: YOUR INFORMATION", "Текст не соответствует ожидаемому.");
    }

    @Test
    public void checkUserZipPostalCode() {
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("qwer", "qwer", "qwer");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: Postal Code is required",
                "Тест в zip/postal code проошел без цифр BUG");
    }

    @Test
    public void checkUserLastName() {
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("Bob", "", "12345");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: Last Name is required",
                "Не заполнено второе имя");
    }

    @Test
    public void checkUserFirstName() {
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("", "Bruce", "12345");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: First Name is required",
                "Не заполнено первое имя");
    }

    @Test
    public void checkUserZipPostalCode2() {
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("Bob", "Bruce", "");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: Postal Code is required",
                "Ошибка поля Zip/Postal код");
    }
}
