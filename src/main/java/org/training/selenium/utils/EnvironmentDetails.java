package org.training.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentDetails {

    static Properties prop = new Properties();

    public static void loadProperties(String environment) {
        try {
            File propertiesFile = new File(Constants.environmentDetailsPropFile + environment+".properties");
            prop.load(new FileInputStream(propertiesFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
