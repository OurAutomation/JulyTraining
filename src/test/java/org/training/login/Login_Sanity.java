package org.training.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.DataProviders;

import java.util.List;

public class Login_Sanity extends Base {

    @Test(priority = 0)
    public void validateContactUsButton() {
        launchApplication();
        WebElement element = driver.findElement(By.id("contact-link"));
        System.out.println("Contact link displayed :: " + element.isDisplayed());
        Assert.assertTrue(element.isDisplayed(), "Contact us link is not displayed");
    }


    @Test(priority = 2, enabled = false)
    public void validateNumberOfInputBoxesAvailableInTheLoginPage() {
        List<WebElement> input = driver.findElements(By.tagName("input"));
        System.out.println("Number of input boxes :: " + input.size());
        Assert.assertEquals(input.size(), 6, "Number of input boxes are not as expected");
    }

    @Test(priority = 3, dataProvider = "loginTestData", dataProviderClass = DataProviders.class)
    public void validateLoginFunctionality(String username, String password, boolean isValid) {
        launchApplication();
        WebElement login = driver.findElement(By.partialLinkText("Sign "));
        login.click();
        WebElement emailInputBox = driver.findElement(By.id("email"));
        emailInputBox.clear();
        emailInputBox.sendKeys(username);
        WebElement passwordInputBox = driver.findElement(By.name("passwd"));
        passwordInputBox.clear();
        passwordInputBox.sendKeys(password);
        WebElement loginButton = driver.findElement(By.name("SubmitLogin"));
        loginButton.click();
        if (isValid) {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@title=\"View my customer account\"]/span")).
                    getText(), "Bharghav Sravan", "Wrong user logged in");
        } else {
            Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,\"alert-danger\")]")).isDisplayed(), "Authentication error message not displayed");
        }
    }


}
