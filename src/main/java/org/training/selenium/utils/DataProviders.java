package org.training.selenium.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider
    public Object[][] loginTestData() {
        Object[][] loginData = new Object[3][3];
        loginData[0][0] = "kongara.bharghav@gmail.com";
        loginData[0][1] = "Testing@1234";
        loginData[0][2] = true;
        loginData[1][0] = "kongara.bharghav@gmail.com";
        loginData[1][1] = "Testing@14";
        loginData[1][2] = false;
        loginData[2][0] = "invalid";
        loginData[2][1] = "invalid";
        loginData[2][2] = false;
        return loginData;
    }

    @DataProvider
    public Object[][] swagLabLoginTestData() {
        Object[][] loginData = new Object[3][3];
        loginData[0][0] = "standard_user";
        loginData[0][1] = "secret_sauce";
        loginData[0][2] = true;
        loginData[1][0] = "locked_out_user";
        loginData[1][1] = "secret_sauce";
        loginData[1][2] = false;
        loginData[2][0] = "performance_glitch_user";
        loginData[2][1] = "secret_sauce";
        loginData[2][2] = true;
        return loginData;
    }
}