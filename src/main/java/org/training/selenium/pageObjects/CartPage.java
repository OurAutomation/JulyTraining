package org.training.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.training.selenium.utils.ObjectRepository;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> returnTheProductsAddedToTheCart() {
        List<WebElement> elements = driver.findElements(ObjectRepository.getLocator("cartPage.productNames.text"));
        List<String> productNames = new ArrayList<>();
        elements.forEach(e -> productNames.add(e.getText()));
        return productNames;
    }
}
