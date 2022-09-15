package org.training.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base {
    public WebDriver driver;
    public String URL = "http://automationpractice.com/index.php";
    String sauceDemoURL = "https://www.saucedemo.com/";
    //public String URL = "https://demo.automationtesting.in/Register.html";

    @BeforeSuite
    public void launchDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get(URL);
    }

    @AfterSuite
    public void shutDown() {
        driver.quit(); // to close the complete browser
        //driver.close(); // to close only one window
    }
    public void launchApplication() {
        driver.manage().deleteAllCookies();
        driver.get(URL);
    }

    public void launchSauceDemoApplication() {
        driver.manage().deleteAllCookies();
        driver.get(sauceDemoURL);
    }
}
