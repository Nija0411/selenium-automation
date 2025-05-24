package com.testing.framework.se07_actionsclass;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions01_ActionsClassEx {

    @Test
    @Description("Verify Actions Class - Keys")
    public void actionsDemo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url = "https://awesomeqa.com/practice.html";
        driver.get(url);
        driver.manage().window().maximize();

        WebElement firstname = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).
                sendKeys(firstname, "nikhita jalapure").
                keyUp(Keys.SHIFT).build().perform();

        Thread.sleep(10000);
        driver.quit();
    }
}
