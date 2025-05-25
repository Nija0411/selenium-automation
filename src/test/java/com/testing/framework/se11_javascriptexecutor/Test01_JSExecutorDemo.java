package com.testing.framework.se11_javascriptexecutor;

import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test01_JSExecutorDemo {

    @Test
    @Description("Open the google.com with JSExecutor")
    public void jsExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://www.google.com'");

        Thread.sleep(3000);
        driver.quit();
    }
}
