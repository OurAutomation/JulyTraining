package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.selenium.pageObjects.CartPage;
import org.training.selenium.pageObjects.DashboardPage;
import org.training.selenium.pageObjects.LoginPage;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.EnvironmentDetails;
import org.training.selenium.utils.SeleniumUtils;
import org.training.selenium.utils.TestDataUtils;

import java.util.List;

public class Practice extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CartPage cartPage;
    SeleniumUtils seleniumUtils;

    @BeforeTest
    public void loadSauceDemoApplication() {
        launchSauceDemoApplication();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        cartPage = new CartPage(driver);
        seleniumUtils = new SeleniumUtils(driver);
    }

    @Test
    public void login() {
        loginPage.loginAndValidate(EnvironmentDetails.getProperty("valid.username"),
                EnvironmentDetails.getProperty("valid.password"));
        seleniumUtils.scroll(By.xpath("//*[text()=\"LinkedIn\"]"));
        String text = driver.findElement(By.xpath("//*[text()=\"LinkedIn\"]")).getText();
        System.out.println(text);
    }


}
