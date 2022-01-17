package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }
}


