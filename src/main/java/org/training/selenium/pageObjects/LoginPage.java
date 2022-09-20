package org.training.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.training.selenium.utils.ObjectRepository;
import org.training.selenium.utils.SeleniumUtils;

public class LoginPage extends SeleniumUtils {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginAndValidate(String username, String password) {
        sendKeys(ObjectRepository.getLocator("loginPage.username.inputBox"), username);
        sendKeys(ObjectRepository.getLocator("loginPage.password.inputBox"), password);
        click(ObjectRepository.getLocator("loginPage.continue.button"));
        Assert.assertTrue(isDisplayed(ObjectRepository.getLocator("dashboardPage.menu.button")), "Login did not happen");
    }

    public void login(String username, String password) {
        sendKeys(ObjectRepository.getLocator("loginPage.username.inputBox"), username);
        sendKeys(ObjectRepository.getLocator("loginPage.password.inputBox"), password);
        click(ObjectRepository.getLocator("loginPage.continue.button"));
    }

    public boolean isInvalidUsernameErrorMessageDisplayed() {
        return isDisplayed(ObjectRepository.getLocator("loginPage.invalidUser.errorMessage"));
    }

}
