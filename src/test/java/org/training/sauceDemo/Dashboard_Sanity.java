package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.selenium.pageObjects.CartPage;
import org.training.selenium.pageObjects.DashboardPage;
import org.training.selenium.pageObjects.LoginPage;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.EnvironmentDetails;
import org.training.selenium.utils.TestDataUtils;

import java.util.List;

public class Dashboard_Sanity extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CartPage cartPage;
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @BeforeTest(description = "Initializing the page Objects", alwaysRun = true)
    public void loadSauceDemoApplication() {
        launchSauceDemoApplication();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(groups = {"sanity"})
    public void login() {
        log.info("Login to the application");
        loginPage.loginAndValidate(EnvironmentDetails.getProperty("valid.username"),
                EnvironmentDetails.getProperty("valid.password"));
        log.info("Logged into application");
    }

    @Test(dependsOnMethods = "login", groups = {"sanity"})
    public void addFirstProductToCartAndValidate() {
        log.info("Adding product to cart");
        dashboardPage.addProductToCart(TestDataUtils.getProperty("itemName"));
        log.info("Product added successfully");
        Assert.assertEquals(dashboardPage.returnNumberOfProductsAdded(), "1", "More number of elements are added to cart");
        log.debug("Test case completed");
    }

    @Test(dependsOnMethods = "login")
    public void addSecondProductToCartAndValidate() {
        log.debug("Test case started");
        log.info("Adding second product to the cart");
        dashboardPage.addProductToCart(TestDataUtils.getProperty("itemName2"));
        log.info("Product added to cart successfully");
        Assert.assertEquals(dashboardPage.returnNumberOfProductsAdded(), "2", "More number of elements are added to cart");
        log.debug("Test case completed");
    }

    @Test(dependsOnMethods = {"addFirstProductToCartAndValidate", "addSecondProductToCartAndValidate"})
    public void validateAddedItemsInCart() {
        log.debug("Test case started");
        log.info("Clicking on shopping cart");
        dashboardPage.clickOnShoppingCart();
        log.info("Clicked on shopping cart");
        List<String> productsAdded = cartPage.returnTheProductsAddedToTheCart();
        log.info("Products returned :: " + productsAdded);
        Assert.assertEquals(productsAdded.get(0), TestDataUtils.getProperty("itemName"), "The name of the products first added is not matching");
        Assert.assertEquals(productsAdded.get(1), TestDataUtils.getProperty("itemName2"), "The name of the products second added is not matching");
        log.debug("Test case completed");
    }

    @Test(dependsOnMethods = "validateAddedItemsInCart")
    public void removeAProductAndValidate() throws InterruptedException {
        log.debug("Testcase started");
        log.info("Clicking on menu button");
        dashboardPage.clickOnMenuButton();
        log.info("Clicked on menu button");
        log.info("Clicking on All items");
        dashboardPage.clickOnAllItems();
        log.info("Clicked on All items");
        log.info("Removing the product from the cart");
        dashboardPage.removeProductFromTheCart(TestDataUtils.getProperty("itemName2"));
        log.info("Product removed successfully");
        Thread.sleep(1000);
        Assert.assertEquals(dashboardPage.returnNumberOfProductsAdded(), "1", "More number of elements are added to cart");
        log.info("Text is matching with number of products added");
        log.info("Clicking on shopping cart");
        dashboardPage.clickOnShoppingCart();
        log.info("Clicked on shopping cart");
        List<String> productsAdded = cartPage.returnTheProductsAddedToTheCart();
        log.info("Products returned :: " + productsAdded);
        Assert.assertEquals(productsAdded.get(0), TestDataUtils.getProperty("itemName"), "The name of the products first added is not matching");
        Assert.assertEquals(productsAdded.size(), 1, "Removed elements are still getting displayed in the cart");
        log.debug("Testcase completed");
    }
}
