package org.training.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.training.selenium.utils.ObjectRepository;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAndValidate(String username, String password) {
        driver.findElement(ObjectRepository.getLocator("loginPage.username.inputBox")).sendKeys(username);
        driver.findElement(ObjectRepository.getLocator("loginPage.password.inputBox")).sendKeys(password);
        driver.findElement(ObjectRepository.getLocator("loginPage.continue.button")).click();
        Assert.assertTrue(driver.findElement(ObjectRepository.getLocator("dashboardPage.menu.button")).isDisplayed(), "Login did not happen");
    }

    public void login(String username, String password) {
        driver.findElement(ObjectRepository.getLocator("loginPage.username.inputBox")).sendKeys(username);
        driver.findElement(ObjectRepository.getLocator("loginPage.password.inputBox")).sendKeys(password);
        driver.findElement(ObjectRepository.getLocator("loginPage.continue.button")).click();
    }

    public boolean isInvalidUsernameErrorMessageDisplayed() {
        return driver.findElement(ObjectRepository.getLocator("loginPage.invalidUser.errorMessage")).isDisplayed();
    }

}
