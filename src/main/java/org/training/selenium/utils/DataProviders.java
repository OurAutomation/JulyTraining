package org.training.selenium.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider
    public Object[][] loginTestData() {
        Object[][] loginData = new Object[3][3];
        loginData[0][0] = EnvironmentDetails.getProperty("valid.username");
        loginData[0][1] = EnvironmentDetails.getProperty("valid.password");
        loginData[0][2] = true;
        loginData[1][0] = EnvironmentDetails.getProperty("locked.username");
        loginData[1][1] = EnvironmentDetails.getProperty("locked.password");
        loginData[1][2] = false;
        loginData[2][0] = EnvironmentDetails.getProperty("invalid.username");
        loginData[2][1] = EnvironmentDetails.getProperty("invalid.password");
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
