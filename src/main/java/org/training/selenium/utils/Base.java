package org.training.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    public WebDriver driver;
    public String URL = "http://automationpractice.com/index.php";

    @BeforeClass
    public void launchDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @AfterClass
    public void shutDown() {
        driver.quit(); // to close the complete browser
        //driver.close(); // to close only one window
    }
}
