package org.training.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.training.selenium.utils.ObjectRepository;
import org.training.selenium.utils.SeleniumUtils;
import org.training.selenium.utils.TestDataUtils;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends SeleniumUtils {
    String xpathForAddToCartButton = ObjectRepository.getProperty("dashBoardPage.addToCart.xpath");
    String xpathForRemoveButton = ObjectRepository.getProperty("dashBoardPage.removeFromCart.xpath");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardPageLoaded() {
        return isDisplayed(ObjectRepository.getLocator("dashboardPage.menu.button"));
    }

    public void addProductToCart(String productName) {
        String xpathForItem = xpathForAddToCartButton.replace("${itemname}", productName);
        click(By.xpath(xpathForItem));
    }

    public String returnNumberOfProductsAdded() {
        return getText(ObjectRepository.getLocator("dashboardPage.cart.icon"));
    }

    public void clickOnShoppingCart() {
        click(ObjectRepository.getLocator("dashboardPage.cart.link"));
    }

    public void removeProductFromTheCart(String product) {
        click(By.xpath(xpathForRemoveButton.replace("${itemname}", product)));
    }

    public void clickOnMenuButton() {
        click(ObjectRepository.getLocator("dashboardPage.menu.button"));
    }

    public void clickOnAllItems() {
        click(ObjectRepository.getLocator("dashboardPage.allItems.menuButton"));
    }

    public void selectGivenFilter(String filterName) {
        select(ObjectRepository.getLocator("dashboardPage.filter.dropdown"),filterName);
        hardWait(1);
    }

    public List<Float> returnTheProductPricesDisplayed() {
        List<Float> inventoryPrices = new ArrayList<>();
        getText(findElements(ObjectRepository.getLocator("dashboardPage.productPrice.text"))).forEach(e-> {
            inventoryPrices.add(Float.parseFloat(e.replace("$","")));
        });
        return inventoryPrices;
    }

    public List<String> returnTheProductNamesDisplayed() {
        return getText(findElements(ObjectRepository.getLocator("dashboardPage.productNames.text")));
    }
}
