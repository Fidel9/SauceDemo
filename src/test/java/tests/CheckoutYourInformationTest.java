package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class CheckoutYourInformationTest extends BaseTest {

    @Test
    public void nextPageUnderCheckoutYourInformation() {
        log.info("Проверяет последовательность открытия другой страницы");
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.nextPageCheckoutOverview();

        String textFromTitle = driver.findElement(By.xpath("//span[@Class='title']")).getText();
        Assert.assertEquals(textFromTitle, "CHECKOUT: YOUR INFORMATION", "Текст не соответствует ожидаемому.");
        log.info("сравнивает  по тексту" + textFromTitle);
    }


   /* @Test
    public void checkUserZipPostalCode() {
        log.debug("проверка ввода zipOrPost кода, зип код должен принимать только цифры");
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("qwer", "qwer", "qwer");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: Postal Code is required",
                "Тест в zip/postal code проошел без цифр. BUG");
        log.error(checkoutYourInformation.getErrorMessage());
        log.debug(checkoutYourInformation.getErrorMessage());
    }*/

    @Test
    public void checkUserLastName() {
        log.info("проверяет ввод фамилии");
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("Bob", "", "12345");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: Last Name is required",
                "Не заполнено второе имя");
        log.info("проверяет ввод фамилии на страницы регистрации");
        log.error(checkoutYourInformation.getErrorMessage());
    }

    @Test
    public void checkUserFirstName() {
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("", "Bruce", "12345");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: First Name is required",
                "Не заполнено первое имя");
        log.info("проверяет ввод имени на страницы регистрации");
        log.error(checkoutYourInformation.getErrorMessage());
    }

    @Test
    public void checkUserZipPostalCode2() {
        log.info("проверяет zipOrPostal код на правильность ввода в даном случае, не вводит ни чего");
        checkoutYourInformation.criticalPath();
        checkoutYourInformation.open();
        checkoutYourInformation.checkInfoNameAndLastName("Bob", "Bruce", "");
        Assert.assertEquals(checkoutYourInformation.getErrorMessage(), "Error: Postal Code is required",
                "Ошибка поля Zip/Postal код");
        log.error(checkoutYourInformation.getErrorMessage());
    }
}
