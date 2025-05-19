package com.testing.framework.miniproject4_xpath;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    @Description("Open Browser")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    @Description("Close the Browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}


