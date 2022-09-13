package org.training.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.training.selenium.utils.Base;

import java.util.List;

public class Login_Sanity extends Base {

    @Test(priority = 0)
    public void validateContactUsButton() {
        WebElement element = driver.findElement(By.id("contact-link"));
        System.out.println("Contact link displayed :: " + element.isDisplayed());
    }

    @Test(priority = 1)
    public void clickOnSignInLink() {
        WebElement login = driver.findElement(By.partialLinkText("Sign "));
        login.click();
    }

    @Test(priority = 2)
    public void validateNumberOfInputBoxesAvailableUInTheLoginPage() {
        List<WebElement> input = driver.findElements(By.tagName("input"));
        System.out.println("Number of input boxes :: " + input.size());
    }

    @Test(priority = 3)
    public void validateLoginFunctionality() throws InterruptedException {
        WebElement emailInputBox = driver.findElement(By.id("email"));
        emailInputBox.clear();
        emailInputBox.sendKeys("kongara.bharghav@gmail.com");
        Thread.sleep(2000);
        WebElement passwordInputBox = driver.findElement(By.name("passwd"));
        passwordInputBox.clear();
        passwordInputBox.sendKeys("Testing@1234");
        Thread.sleep(2000);
        WebElement loginButton = driver.findElement(By.name("SubmitLogin"));
        loginButton.click();
    }
}
