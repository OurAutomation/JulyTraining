package org.training.sauceDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.training.selenium.pageObjects.CartPage;
import org.training.selenium.pageObjects.DashboardPage;
import org.training.selenium.pageObjects.LoginPage;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.EnvironmentDetails;
import org.training.selenium.utils.TestDataUtils;

import java.util.List;
import java.util.Set;

public class ValidateSocialMediaNetworksLinked extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String mainWindowHandle, facebookWindowHandle, twitterWindowHandle, linkedInWindowHandle;

    @BeforeTest(description = "Initializing the page Objects", alwaysRun = true)
    public void loadSauceDemoApplication() {
        launchSauceDemoApplication();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(groups = {"sanity"})
    public void login() {
        log.info("Login to the application");
        loginPage.loginAndValidate(EnvironmentDetails.getProperty("valid.username"),
                EnvironmentDetails.getProperty("valid.password"));
        log.info("Logged into application");
    }


    @Test(dependsOnMethods = "login", groups = {"sanity"},priority = 0)
    public void validateFaceBookFunctionality() {
        try {
            mainWindowHandle = dashboardPage.getPresentWindowHandle();
            log.info("Present window handle :: " + mainWindowHandle);
            dashboardPage.clickOnFacebookIcon();
            dashboardPage.hardWait(5);
            Set<String> windowHandles = dashboardPage.getWindowHandles();
            log.info("Present window is :: " + dashboardPage.getTitle());
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    facebookWindowHandle = windowHandle;
                    break;
                }
            }
            dashboardPage.switchToWindow(facebookWindowHandle);
            Assert.assertEquals(dashboardPage.getTitle(), "Sauce Labs - Home | Facebook", "Window did not switch to facebook window handle or it is not opened");
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            dashboardPage.switchToWindow(mainWindowHandle);
        }
    }

    @Test(dependsOnMethods = "login", groups = {"sanity"},priority = 1)
    public void validateTwitterFunctionality() {
        try {
            log.info("Present window handle :: " + mainWindowHandle);
            dashboardPage.clickOnTwitterIcon();
            dashboardPage.hardWait(5);
            Set<String> windowHandles = dashboardPage.getWindowHandles();
            log.info("Present window is :: " + dashboardPage.getTitle());
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(mainWindowHandle) && !windowHandle.equals(facebookWindowHandle)) {
                    twitterWindowHandle = windowHandle;
                    break;
                }
            }
            dashboardPage.switchToWindow(twitterWindowHandle);
            Assert.assertEquals(dashboardPage.getTitle(), "Sauce Labs (@saucelabs) / Twitter", "Window did not switch to twitter window handle or it is not opened" );
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            dashboardPage.switchToWindow(mainWindowHandle);
        }
    }

    @Test(dependsOnMethods = "login", groups = {"sanity"},priority = 2)
    public void validateLinkedInButtonFunctionality() {
        try {
            log.info("Present window handle :: " + mainWindowHandle);
            dashboardPage.clickOnLinkedInIcon();
            dashboardPage.hardWait(5);
            Set<String> windowHandles = dashboardPage.getWindowHandles();
            log.info("Present window is :: " + dashboardPage.getTitle());
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(mainWindowHandle) && !windowHandle.equals(facebookWindowHandle)&& !windowHandle.equals(twitterWindowHandle)) {
                    linkedInWindowHandle = windowHandle;
                    break;
                }
            }
            dashboardPage.switchToWindow(linkedInWindowHandle);
            Assert.assertEquals(dashboardPage.getTitle().trim(), "Sign In | LinkedIn", "Window did not switch to twitter window handle or it is not opened" );
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        } finally {
            dashboardPage.switchToWindow(mainWindowHandle);
        }
    }

    @Test(priority = 12)
    public void openNewTabAndNavigateToGmail() {
        dashboardPage.openNewTab();
        dashboardPage.hardWait(5);
        dashboardPage.navigateTo("https://mail.google.com/mail/u/0/#inbox");
        dashboardPage.hardWait(5);
        dashboardPage.navigateBackward();
        dashboardPage.hardWait(5);
        dashboardPage.navigateForward();
        dashboardPage.hardWait(2);
        dashboardPage.refresh();
    }

    @Test(priority = 13)
    public void openNewWindowAndNavigateToFacebook() {
        dashboardPage.openNewWindow();
        dashboardPage.hardWait(5);
        driver.get("https://www.facebook.com/");
        dashboardPage.hardWait(5);
    }

    @AfterClass
    public void closeAllWindows() {
        dashboardPage.closeTheTab(facebookWindowHandle);
        dashboardPage.closeTheTab(twitterWindowHandle);
        dashboardPage.closeTheTab(linkedInWindowHandle);
        dashboardPage.closeTheTab(mainWindowHandle);
    }

}
