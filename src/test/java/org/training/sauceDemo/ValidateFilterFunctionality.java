package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.training.selenium.utils.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ValidateFilterFunctionality extends Base {

    @BeforeTest
    public void loadSauceDemoApplication() {
        launchSauceDemoApplication();
    }

    @Test(priority = 0)
    public void login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed(), "Login did not happen");
    }

    @Test(priority = 1)
    public void validateFilterFunctionalityAtoZ() throws InterruptedException {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
//        select.selectByIndex(0);
        select.selectByVisibleText("Name (A to Z)");
//        select.selectByValue("az");
        Thread.sleep(2000);
        List<String> inventoryStrings = new ArrayList<>();
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item_name"));
        inventoryItems.stream().forEach(e-> inventoryStrings.add(e.getText()));
        List<String> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Assert.assertEquals(inventoryStrings,actualOrder,"A to Z filter functionality is not working as expected");
    }

    @Test(priority = 2)
    public void validateFilterFunctionalityZtoA() throws InterruptedException {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText("Name (Z to A)");
        Thread.sleep(2000);
        List<String> inventoryStrings = new ArrayList<>();
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item_name"));
        inventoryItems.stream().forEach(e-> inventoryStrings.add(e.getText()));
        List<String> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Collections.reverse(inventoryStrings);
        Assert.assertEquals(inventoryStrings,actualOrder,"Z to A filter functionality is not working as expected");
    }

    @Test(priority = 3)
    public void validateFilterFunctionalityLowToHigh() throws InterruptedException {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
//        select.selectByIndex(0);
        select.selectByVisibleText("Price (low to high)");
//        select.selectByValue("az");
        Thread.sleep(2000);
        List<Float> inventoryStrings = new ArrayList<>();
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item_price"));
        inventoryItems.stream().forEach(e-> {
            inventoryStrings.add(Float.parseFloat(e.getText().replace("$","")));
        });
        List<Float> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Assert.assertEquals(inventoryStrings,actualOrder,"Price Low to High filter functionality is not working as expected");
    }

    @Test(priority = 4)
    public void validateFilterFunctionalityHighToLow() throws InterruptedException {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText("Price (high to low)");
        Thread.sleep(2000);
        List<Float> inventoryStrings = new ArrayList<>();
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item_price"));
        inventoryItems.stream().forEach(e-> {
            inventoryStrings.add(Float.parseFloat(e.getText().replace("$","")));
        });
        List<Float> actualOrder = new ArrayList<>();
        actualOrder.addAll(inventoryStrings);
        Collections.sort(inventoryStrings);
        Collections.reverse(inventoryStrings);
        Assert.assertEquals(inventoryStrings,actualOrder,"Price High to low filter functionality is not working as expected");
    }

    @Test(priority = 5)
    public void validateAllTheItemsInTheMenuBar() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        List<WebElement> sideBarTabs = driver.findElements(By.cssSelector("[id*='sidebar_link']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(sideBarTabs.get(0).getText(),"All Items".toUpperCase(),"First Item in the sidebar is not matching");
        softAssert.assertEquals(sideBarTabs.get(1).getText(),"About".toUpperCase(),"Second Item in the sidebar is not matching");
        softAssert.assertEquals(sideBarTabs.get(2).getText(),"Logout".toUpperCase(),"Third Item in the sidebar is not matching");
        softAssert.assertEquals(sideBarTabs.get(3).getText(),"Reset App State".toUpperCase(),"Fourth Item in the sidebar is not matching");
        softAssert.assertAll();
    }
}
