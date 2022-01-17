package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CheckoutYourInformationPage;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckoutYourInformationPage checkoutYourInformation;


    @BeforeMethod(description = "Setup and start browser")
    public void setup(ITestContext context) {
        log.info("<----- начало теста ----->");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setAttribute("driver",driver);

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkoutYourInformation = new CheckoutYourInformationPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Close")
    public void tearDown() {
        driver.quit();
        log.info("конец теста");
    }
}
