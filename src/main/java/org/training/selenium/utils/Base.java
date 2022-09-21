package org.training.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public String URL = "http://automationpractice.com/index.php";
    //public String URL = "https://demo.automationtesting.in/Register.html";

    @BeforeSuite(alwaysRun = true)
    @Parameters(value = {"environment", "browser"})
    public void beforeSuite(@Optional("SauceDemo") String environment, @Optional("chrome") String browser) {
        EnvironmentDetails.loadProperties(environment);
        TestDataUtils.loadProperties(environment);
        ObjectRepository.loadProperties(environment);
    }

    @BeforeTest(alwaysRun = true)
    public void launchDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest(alwaysRun = true)
    public void shutDown() {
        driver.quit(); // to close the complete browser
        //driver.close(); // to close only one window
    }

    public void launchApplication() {
        driver.get(URL);
    }

    public void launchSauceDemoApplication() {
        driver.manage().deleteAllCookies();
        driver.get(EnvironmentDetails.getProperty("URL"));
    }
}
