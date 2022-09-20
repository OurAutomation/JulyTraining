package org.training.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.training.selenium.utils.ObjectRepository;
import org.training.selenium.utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends SeleniumUtils {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> returnTheProductsAddedToTheCart() {
        return getText(findElements(ObjectRepository.getLocator("cartPage.productNames.text")));
    }
}
