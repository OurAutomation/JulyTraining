package org.training.application;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.training.selenium.utils.Base;

public class Application_Sanity extends Base {
    String titleOfThePage = "Login - My Store";

    @Test
    public void A_validateTitle_HardAssertion() {
        String title = driver.getTitle();// Validate the title
        Assert.assertEquals(title,titleOfThePage,"The title of the application not matching");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, URL, "Current URL of the application is not matching with the URL we navigated to." +
                " May be it is redirected to a phishing page.");
        if (currentUrl.equals(URL)) {
            System.out.println("Original application is loaded");
        } else {
            System.err.println("Phishing page is loaded");
        }
        System.out.println("Test Completed");
    }

    @Test
    public void validateTitleAndURl_SoftAssertion() {
        SoftAssert softAssert = new SoftAssert();
        String title = driver.getTitle();// Validate the title
        softAssert.assertEquals(title,titleOfThePage,"The title of the application not matching");
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(currentUrl, URL, "Current URL of the application is not matching with the URL we navigated to." +
                " May be it is redirected to a phishing page.");
        softAssert.assertAll();
        System.out.println("Test Completed");
    }

    @Test(enabled = false)
    public void A_validateURL() {
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(URL)) {
            System.out.println("Original application is loaded");
        } else {
            System.err.println("Phishing page is loaded");
        }
    }
}
