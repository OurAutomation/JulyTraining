package org.training.selenium.utils;

import java.io.File;

public class Constants {
    public final static String PROJECT_HOME = System.getProperty("user.dir");
    public final static String MAIN_RESOURCES = PROJECT_HOME + File.separator + "src" + File.separator + "main" + File.separator + "resources";
    public final static String environmentDetailsPropFile = MAIN_RESOURCES + File.separator + "Environment" + File.separator;
    public final static String testdataDetailsPropFile = MAIN_RESOURCES + File.separator + "Testdata" + File.separator;
    public final static String objectRepositoryDetailsPropFile = MAIN_RESOURCES + File.separator + "ObjectRepository" + File.separator;
}
