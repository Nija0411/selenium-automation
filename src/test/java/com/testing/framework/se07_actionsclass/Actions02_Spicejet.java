package com.testing.framework.se07_actionsclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions02_Spicejet {

    @Test
    public void testSpicejet() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement source = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div/input"));

        Actions actions = new Actions(driver);
        // move to Element
        // click
        // sendKeys

        actions.moveToElement(source).click().sendKeys("BLR").build().perform();

        Thread.sleep(3000);
        driver.quit();

    }
}
