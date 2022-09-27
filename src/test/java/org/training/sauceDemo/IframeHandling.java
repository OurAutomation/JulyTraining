package org.training.sauceDemo;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.training.selenium.utils.Base;
import org.training.selenium.utils.SeleniumUtils;

public class IframeHandling extends Base {
    SeleniumUtils seleniumUtils;

    @BeforeClass
    public void navigate() {
        seleniumUtils = new SeleniumUtils(driver);
        driver.get("https://demo.automationtesting.in/Register.html");
        seleniumUtils.mouseHover(By.xpath("//a[@class=\"dropdown-toggle\" and text()=\"SwitchTo\"]"));
        seleniumUtils.findElement(By.xpath("//a[text()=\"Frames\"]")).click();
    }

    @Test
    public void sendText() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"aswift_2\"]")));
        driver.switchTo().frame("ad_iframe");
        seleniumUtils.findElement(By.xpath("//*[text()=\"Close\"]")).click();
        driver.switchTo().frame("singleframe");
        seleniumUtils.sendKeys(By.xpath("//*[@type=\"text\"]"),"test");
        seleniumUtils.hardWait(5);
        driver.switchTo().defaultContent();
        seleniumUtils.click(By.xpath("//*[@href=\"#Multiple\"]"));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src=\"MultipleFrames.html\"]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src=\"SingleFrame.html\"]")));
        seleniumUtils.sendKeys(By.xpath("//*[@type=\"text\"]"),"test");
        driver.switchTo().parentFrame();
        seleniumUtils.hardWait(5);
    }

}
