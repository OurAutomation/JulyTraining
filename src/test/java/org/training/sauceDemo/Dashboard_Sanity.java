package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @BeforeTest
    public void loadSauceDemoApplication() {
        launchSauceDemoApplication();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void login() {
        loginPage.loginAndValidate(EnvironmentDetails.getProperty("valid.username"),
                EnvironmentDetails.getProperty("valid.password"));
    }

    @Test(dependsOnMethods = "login")
    public void addFirstProductToCartAndValidate() {
        dashboardPage.addProductToCart(TestDataUtils.getProperty("itemName"));
        Assert.assertEquals(dashboardPage.returnNumberOfProductsAdded(), "1", "More number of elements are added to cart");
    }

    @Test(dependsOnMethods = "login")
    public void addSecondProductToCartAndValidate() {
        dashboardPage.addProductToCart(TestDataUtils.getProperty("itemName2"));
        Assert.assertEquals(dashboardPage.returnNumberOfProductsAdded(), "2", "More number of elements are added to cart");
    }

    @Test(dependsOnMethods = {"addFirstProductToCartAndValidate", "addSecondProductToCartAndValidate"})
    public void validateAddedItemsInCart() {
        dashboardPage.clickOnShoppingCart();
        List<String> productsAdded = cartPage.returnTheProductsAddedToTheCart();
        Assert.assertEquals(productsAdded.get(0), TestDataUtils.getProperty("itemName"), "The name of the products first added is not matching");
        Assert.assertEquals(productsAdded.get(1), TestDataUtils.getProperty("itemName2"), "The name of the products second added is not matching");
    }

    @Test(dependsOnMethods = "validateAddedItemsInCart")
    public void removeAProductAndValidate() throws InterruptedException {
        dashboardPage.clickOnMenuButton();
        dashboardPage.clickOnAllItems();
        dashboardPage.removeProductFromTheCart(TestDataUtils.getProperty("itemName2"));
        Thread.sleep(1000);
        Assert.assertEquals(dashboardPage.returnNumberOfProductsAdded(), "1", "More number of elements are added to cart");
        dashboardPage.clickOnShoppingCart();
        List<String> productsAdded = cartPage.returnTheProductsAddedToTheCart();
        Assert.assertEquals(productsAdded.get(0), TestDataUtils.getProperty("itemName"), "The name of the products first added is not matching");
        Assert.assertEquals(productsAdded.size(), 1, "Removed elements are still getting displayed in the cart");
    }
}
