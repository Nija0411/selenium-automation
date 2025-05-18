package com.testing.framework.miniproject3_locators;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    @Description("Open a VWO Web Page")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
    }

    @AfterTest
    @Description("Close the Driver and Quite sesson")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
