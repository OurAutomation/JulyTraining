package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.selenium.pageObjects.DashboardPage;
import org.training.selenium.pageObjects.LoginPage;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.DataProviders;

public class Login_Sanity extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "swagLabLoginTestData",groups = {"sanity"},dataProviderClass = DataProviders.class, description = "Validate login functionality with valid and invalid credentials")
    public void login(String userName, String password, boolean isValid) {
        launchSauceDemoApplication();
        loginPage.login(userName, password);
        if (isValid) {
            Assert.assertTrue(dashboardPage.isDashboardPageLoaded(), "Login did not happen");
        } else {
            Assert.assertTrue(loginPage.isInvalidUsernameErrorMessageDisplayed(),
                    "Error Message is not displayed");
        }
    }
}
