package com.testing.framework.se12_RelativeLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Test01_RelativeLocatorEx {

    @Test
    @Description("Locate the Element which is located right of the Years of Experience Text")
    public void relLocator() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/practice.html");
        driver.manage().window().maximize();

        //Step 1: import static org.openqa.selenium.support.locators.RelativeLocator.*;

        //Step 2: Find the Xpath for the span element (Years of Experience)
        WebElement spanElement = driver.findElement(By.xpath("//span[text()=\"Years of Experience\"]"));

        //Step 3: Find the element which is right to the spanElement - radio button 2
        driver.findElement(with(By.id("exp-1")).toRightOf(spanElement)).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
