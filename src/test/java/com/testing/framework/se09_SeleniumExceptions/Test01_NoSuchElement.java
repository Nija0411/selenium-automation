package com.testing.framework.se09_SeleniumExceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test01_NoSuchElement {

    @Test
    @Description("Verify NoSuchElementException in app.vwo.com")
    public void testexception() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();

        WebElement element = null; //org.openqa.selenium.NoSuchElementException
        try {
            element = driver.findElement(By.name("Nikhita"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        element.sendKeys("Jalapure");
    }
}
