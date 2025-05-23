package com.testing.framework.se06_shadowDOM;

import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {

    @Test
    @Description("Verify JavaScriptExecutor")
    public void jsexecutordemo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("alert('Hello Google')");

        Thread.sleep(3000);
        driver.quit();
    }
}
