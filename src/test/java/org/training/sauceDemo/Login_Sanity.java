package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.DataProviders;

public class Login_Sanity extends Base {


    @Test(dataProvider = "swagLabLoginTestData", dataProviderClass = DataProviders.class)
    public void login(String userName, String password, boolean isValid) {
        launchSauceDemoApplication();
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        if (isValid) {
            Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed(), "Login did not happen");
        } else {
            Assert.assertTrue(driver.findElement(By.cssSelector(".error-message-container>h3")).isDisplayed(),
                    "Error Message is not displayed");
        }
    }
}
