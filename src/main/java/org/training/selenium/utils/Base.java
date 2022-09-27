package org.training.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;
import java.util.Collections;

public class Base {
    public static WebDriver driver;
    public String URL = "http://automationpractice.com/index.php";
    //public String URL = "https://demo.automationtesting.in/Register.html";

    @BeforeSuite(alwaysRun = true)
    @Parameters(value = {"environment", "browser"})
    public void beforeSuite(@Optional("SauceDemo") String environment, @Optional("chrome") String browser) {
        EnvironmentDetails.loadProperties(environment);
        TestDataUtils.loadProperties(environment);
        ObjectRepository.loadProperties(environment);
    }

    @BeforeTest(alwaysRun = true)
    public void launchDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--user-data-dir=C:\\Users\\Sravan\\AppData\\Local\\Google\\Chrome\\User Data");
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        chromeOptions.setExperimentalOption("excludeSwitches",
                Collections.singletonList("enable-automation"));
        /*
        chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-features=EnableEphemeralFlashPermission");
				if (gridValue) {
					// set the path to where chrome driver exist in remote
					// machine while using
					// selenium grid
					System.setProperty("webdriver.chrome.driver", remotenodeprojectpath);
				} else {
					// setting the chrome driver path to chrome key in the
					// system
					System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
				}
				// adding basic desired capabilities of chrome
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_setting_values.plugins", 1);
				chromePrefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
				chromePrefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);

				 chromePrefs.put("PluginsAllowedForUrls",
				 "https://unifiedqa.clearhub.tv/BC/Product/Modules/SignIn.aspx" );

        // Enable Flash for this site

        // Disable the content related popup blocking
        chromePrefs.put("profile.default_content_settings.popups", 1);
        // enable safe browsing
        // chromePrefs.put("safebrowsing.enabled", "true");
        // setting default download directory path
        chromePrefs.put("download.default_directory", Constants.HTTP_DOWNLOAD_PATH);
        chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("profile.default_content_setting_values.notifications", 1);
        chromePrefs.put("webkit.webprefs.allow_running_insecure_content", 1);
        // chromePrefs.put("excludeSwitches","disable-component-update");
        // C:\Users\BHARGH~1.KON\AppData\Local\Temp\scoped_dir2672_6708\pnacl\0.57.44.2492\_platform_specific\x86_64
        // chromeOptions.addArguments("--pnacl-dir=C:\\Users\\BHARGH~1.KON\\AppData\\Local\\Temp\\scoped_dir2672_6708\\pnacl\\0.57.44.2492\\_platform_specific\\x86_64");
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        if (gridValue) {
            // open browser in kiosk (maximized) mode in remote machine
            chromeOptions.addArguments("--kiosk");
        }
        // To disable all the certificate errors
        chromeOptions.addArguments("-test-type");
        // To open the browser in incognito mode
        chromeOptions.addArguments("--disable-notifications");
        // chromeOptions.addArguments("--incognito");
        // openbrowser maximized state
        chromeOptions.addArguments("start-maximized");
        // Always allow the authorized plugins
        chromeOptions.addArguments("--always-authorize-plugins=true");
        chromeOptions.addArguments("--enable-automation");
        // enable native client
        // chromeOptions.addArguments("--enable-npapi");
        chromeOptions.addArguments("-enable-pnacl");
        // chromeOptions.addArguments("--enable-pnacl");
        // chromeOptions.addArguments("enable-pnacl");
        chromeOptions.addArguments("-enable-nacl");
        // chromeOptions.addArguments("--enable-nacl");
        // Disable popup blocking
        chromeOptions.addArguments("-disable-popup-blocking=true");
        chromeOptions.addArguments("user-data-dir=" + Constants.USERDATA_TEMP_FOLDER_PATH + tempFolderName);
        chromeOptions.addExtensions(new File(Constants.EXTENSION_CRX));
        // Disable all the extensions
        // chromeOptions.addArguments("chrome.switches", "--disable-extensions");
        // Don't show any infobars in the browser
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        // always accept secure socket layer alerts
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
         */
//        chromeOptions.addExtensions(new File("D:\\cucumber\\JulyTraining\\AdBlockExtension.crx"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest(alwaysRun = true)
    public void shutDown() {
        driver.quit(); // to close the complete browser
        //driver.close(); // to close only one window
    }

    public void launchApplication() {
        driver.get(URL);
    }

    public void launchSauceDemoApplication() {
        driver.manage().deleteAllCookies();
        driver.get(EnvironmentDetails.getProperty("URL"));
    }
}
