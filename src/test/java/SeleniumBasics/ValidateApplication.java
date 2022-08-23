package SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class ValidateApplication {
    public static void main(String[] args) throws InterruptedException {

        String titleOfThePage = "Login - My Store";
        String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
        String PROJECT_HOME = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", PROJECT_HOME + File.separator + "Drivers" + File.separator + "chromedriver.exe");
        System.setProperty("webdriver.edge.driver", PROJECT_HOME + File.separator + "Drivers" + File.separator + "msedgedriver.exe");
        WebDriver driver = new EdgeDriver();//Open the browser
        driver.manage().window().maximize(); //Maximize the chrome window
        driver.get(URL);//Navigate to URL
        String title = driver.getTitle();// Validate the title
        if (title.equals(titleOfThePage)) {
            System.out.println("Proper application is loaded");
        } else {
            System.err.println("Phishing application is loaded");
        }
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals(URL)) {
            System.out.println("Original application is loaded");
        } else {
            System.err.println("Phishing page is loaded");
        }
        Thread.sleep(5000);
        driver.close();//Close the browser


    }
}

