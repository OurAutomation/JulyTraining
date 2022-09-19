package org.training.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.training.selenium.utils.ObjectRepository;
import org.training.selenium.utils.TestDataUtils;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {
    WebDriver driver;
    String xpathForAddToCartButton = ObjectRepository.getProperty("dashBoardPage.addToCart.xpath");
    String xpathForRemoveButton = ObjectRepository.getProperty("dashBoardPage.removeFromCart.xpath");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardPageLoaded() {
        return driver.findElement(ObjectRepository.getLocator("dashboardPage.menu.button")).isDisplayed();
    }

    public void addProductToCart(String productName) {
        String xpathForItem = xpathForAddToCartButton.replace("${itemname}", productName);
        driver.findElement(By.xpath(xpathForItem)).click();
    }

    public String returnNumberOfProductsAdded() {
        return driver.findElement(ObjectRepository.getLocator("dashboardPage.cart.icon")).getText();
    }

    public void clickOnShoppingCart() {
        driver.findElement(ObjectRepository.getLocator("dashboardPage.cart.link")).click();
    }

    public void removeProductFromTheCart(String product) {
        driver.findElement(By.xpath(xpathForRemoveButton.replace("${itemname}", product))).click();
    }

    public void clickOnMenuButton() {
        driver.findElement(ObjectRepository.getLocator("dashboardPage.menu.button")).click();
    }

    public void clickOnAllItems() {
        driver.findElement(ObjectRepository.getLocator("dashboardPage.allItems.menuButton")).click();
    }

    public void selectGivenFilter(String filterName) {
        Select select = new Select(driver.findElement(ObjectRepository.getLocator("dashboardPage.filter.dropdown")));
        select.selectByVisibleText(filterName);
    }

    public List<String> returnTheProductNamesDisplayed() {
        List<WebElement> elements = driver.findElements(ObjectRepository.getLocator("dashboardPage.productNames.text"));
        List<String> productNames = new ArrayList<>();
        elements.forEach(e -> productNames.add(e.getText()));
        return productNames;
    }
}
