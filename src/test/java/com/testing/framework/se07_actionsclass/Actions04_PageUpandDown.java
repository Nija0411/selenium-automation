package com.testing.framework.se07_actionsclass;

import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions04_PageUpandDown {

    @Test
    @Description("Verify Page up and Down for The Testing Academy website")
    public void pageUpDown() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.thetestingacademy.com");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_DOWN).build().perform();
    }
}
