package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.training.selenium.pageObjects.DashboardPage;
import org.training.selenium.pageObjects.LoginPage;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.EnvironmentDetails;
import org.training.selenium.utils.TestDataUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ValidateFilterFunctionality extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeTest
    public void loadSauceDemoApplication() {
        launchSauceDemoApplication();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(priority = 0)
    public void login() {
        loginPage.loginAndValidate(EnvironmentDetails.getProperty("valid.username"),
                EnvironmentDetails.getProperty("valid.password"));
    }

    @Test(priority = 1)
    public void validateFilterFunctionalityAtoZ() throws InterruptedException {
        dashboardPage.selectGivenFilter(TestDataUtils.getProperty("AToZFilterText"));
        List<String> inventoryStrings = dashboardPage.returnTheProductNamesDisplayed();
        List<String> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Assert.assertEquals(inventoryStrings, actualOrder, "A to Z filter functionality is not working as expected");
    }

    @Test(priority = 2)
    public void validateFilterFunctionalityZtoA() throws InterruptedException {
        dashboardPage.selectGivenFilter(TestDataUtils.getProperty("ZToAFilterText"));
        List<String> inventoryStrings = dashboardPage.returnTheProductNamesDisplayed();
        List<String> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Collections.reverse(inventoryStrings);
        Assert.assertEquals(inventoryStrings, actualOrder, "Z to A filter functionality is not working as expected");
    }

    @Test(priority = 3)
    public void validateFilterFunctionalityLowToHigh() throws InterruptedException {
        dashboardPage.selectGivenFilter(TestDataUtils.getProperty("priceLowToHighFilterText"));
        List<String> inventoryStrings = dashboardPage.returnTheProductNamesDisplayed();
        List<String> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Assert.assertEquals(inventoryStrings, actualOrder, "Price Low to High filter functionality is not working as expected");
    }

    @Test(priority = 4)
    public void validateFilterFunctionalityHighToLow() throws InterruptedException {
        dashboardPage.selectGivenFilter(TestDataUtils.getProperty("priceHighToLowFilterText"));
        List<String> inventoryStrings = dashboardPage.returnTheProductNamesDisplayed();
        List<String> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Collections.reverse(inventoryStrings);
        Assert.assertEquals(inventoryStrings, actualOrder, "Price High to low filter functionality is not working as expected");
    }

    @Test(priority = 5)
    public void validateAllTheItemsInTheMenuBar() throws InterruptedException {
        dashboardPage.clickOnMenuButton();
        Thread.sleep(2000);
        List<WebElement> sideBarTabs = driver.findElements(By.cssSelector("[id*='sidebar_link']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sideBarTabs.get(0).getText(), "All Items".toUpperCase(), "First Item in the sidebar is not matching");
        softAssert.assertEquals(sideBarTabs.get(1).getText(), "About".toUpperCase(), "Second Item in the sidebar is not matching");
        softAssert.assertEquals(sideBarTabs.get(2).getText(), "Logout".toUpperCase(), "Third Item in the sidebar is not matching");
        softAssert.assertEquals(sideBarTabs.get(3).getText(), "Reset App State".toUpperCase(), "Fourth Item in the sidebar is not matching");
        softAssert.assertAll();
    }
}
