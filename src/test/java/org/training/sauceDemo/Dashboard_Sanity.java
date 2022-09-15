package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.selenium.utils.Base;

import java.util.List;

public class Dashboard_Sanity extends Base {
    String itemName = "Sauce Labs Backpack";
    String itemName2 = "Sauce Labs Bike Light";
    String xpathForAddToCartButton = "//div[text()='${itemname}' and @class='inventory_item_name']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button[text()='Add to cart']";
    String xpathForRemoveButton = "//div[text()='${itemname}' and @class='inventory_item_name']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button[text()='Remove']";

    @BeforeTest
    public void loadSauceDemoApplication() {
        launchSauceDemoApplication();
    }

    @Test
    public void login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed(), "Login did not happen");
    }

    @Test(dependsOnMethods = "login")
    public void addFirstProductToCartAndValidate() {
        String xpathForItem = xpathForAddToCartButton.replace("${itemname}", itemName);
        driver.findElement(By.xpath(xpathForItem)).click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1", "More number of elements are added to cart");
    }

    @Test(dependsOnMethods = "login")
    public void addSecondProductToCartAndValidate() {
        String xpathForItem = xpathForAddToCartButton.replace("${itemname}", itemName2);
        driver.findElement(By.xpath(xpathForItem)).click();
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "2", "More number of elements are added to cart");
    }

    @Test(dependsOnMethods = {"addFirstProductToCartAndValidate", "addSecondProductToCartAndValidate"})
    public void validateAddedItemsInCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='cart_list']//*[@class=\"inventory_item_name\"]"));
        Assert.assertEquals(elements.get(0).getText(), itemName, "The name of the products first added is not matching");
        Assert.assertEquals(elements.get(1).getText(), itemName2, "The name of the products second added is not matching");
    }

    @Test(dependsOnMethods = "validateAddedItemsInCart")
    public void removeAProductAndValidate() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.xpath("//*[contains(@class,\"menu-item\") and text()=\"All Items\"]")).click();
        driver.findElement(By.xpath(xpathForRemoveButton.replace("${itemname}", itemName2))).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1", "More number of elements are added to cart");
        driver.findElement(By.className("shopping_cart_link")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='cart_list']//*[@class=\"inventory_item_name\"]"));
        Assert.assertEquals(elements.get(0).getText(), itemName, "The name of the products first added is not matching");
        Assert.assertEquals(elements.size(),1,"Removed elements are still getting displayed in the cart");
    }
}
