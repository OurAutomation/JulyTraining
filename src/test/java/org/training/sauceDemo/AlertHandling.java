package org.training.sauceDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.SeleniumUtils;

public class AlertHandling extends Base {
    SeleniumUtils seleniumUtils;

    @BeforeClass
    public void navigate() {
        seleniumUtils = new SeleniumUtils(driver);
        driver.get("https://demo.automationtesting.in/Register.html");
        seleniumUtils.mouseHover(By.xpath("//a[@class=\"dropdown-toggle\" and text()=\"SwitchTo\"]"));
        seleniumUtils.findElement(By.xpath("//a[text()=\"Alerts\"]")).click();
    }

    @Test
    public void sendText() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"aswift_2\"]")));
        driver.switchTo().frame("ad_iframe");
        seleniumUtils.findElement(By.xpath("//*[text()=\"Close\"]")).click();
        driver.switchTo().defaultContent();
        seleniumUtils.findElement(By.xpath("//*[@href=\"#Textbox\"]")).click();
        seleniumUtils.findElement(By.xpath("//*[@onclick=\"promptbox()\"]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Sravan");
        alert.accept();
        seleniumUtils.findElement(By.xpath("//*[@onclick=\"promptbox()\"]")).click();
        alert.dismiss();
        System.out.println("clicked on cancel button");
    }

}
