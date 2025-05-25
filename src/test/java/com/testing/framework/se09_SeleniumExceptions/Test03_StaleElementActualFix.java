package com.testing.framework.se09_SeleniumExceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test03_StaleElementActualFix {
    @Test
    @Description("Verify StaleElementReferenceException")
    public void testExc() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://app.vwo.com");
            driver.manage().window().maximize();

            WebElement emailAdd = driver.findElement(By.xpath("//input[@id='login-username']"));

            driver.navigate().refresh();

            emailAdd = driver.findElement(By.xpath("//input[@id='login-username']"));
            emailAdd.sendKeys("abc123@gmail.com");//org.openqa.selenium.StaleElementReferenceException
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
