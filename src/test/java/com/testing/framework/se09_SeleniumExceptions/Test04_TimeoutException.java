package com.testing.framework.se09_SeleniumExceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test04_TimeoutException {

    @Test
    @Description
    public void testTimeout() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();


        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqd")));//Timeout
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
            Actions actions = new Actions(driver);
            searchBox.click();
            actions.moveToElement(searchBox).sendKeys("thetestingacademy").keyDown(Keys.ENTER).build().perform();
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("End of an Program");
        Thread.sleep(3000);
        driver.quit();
    }
}
