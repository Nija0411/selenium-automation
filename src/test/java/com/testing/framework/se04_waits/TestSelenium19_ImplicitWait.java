package com.testing.framework.se04_waits;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSelenium19_ImplicitWait {

    @Test
    @Description("Verify Implicit Wait")
    public void implicitWait() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://app.vwo.com/#/login");

        driver.quit();
    }
}
