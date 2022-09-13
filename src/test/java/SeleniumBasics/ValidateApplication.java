package SeleniumBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.List;

public class ValidateApplication {
    public static void main(String[] args) throws InterruptedException {
        String titleOfThePage = "Login - My Store";
        String URL = "http://automationpractice.com/index.php";
        String PROJECT_HOME = System.getProperty("user.dir");
        /*System.setProperty("webdriver.chrome.driver", PROJECT_HOME + File.separator + "Drivers" + File.separator + "chromedriver.exe");
        System.setProperty("webdriver.edge.driver", PROJECT_HOME + File.separator + "Drivers" + File.separator + "msedgedriver.exe");*/
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        System.out.println("The driver exe path :: " + System.getProperty("webdriver.edge.driver"));
        WebDriver driver = new EdgeDriver();//Open the browser
        Dimension size = driver.manage().window().getSize();
        System.out.println(size.getWidth() + " :: " + size.getHeight());
        driver.manage().window().maximize(); //Maximize the chrome window
        size = driver.manage().window().getSize();
        System.out.println(size.getWidth() + " :: " + size.getHeight());
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

        Thread.sleep(7000);
        driver.close();//Close the browser
    }
}

