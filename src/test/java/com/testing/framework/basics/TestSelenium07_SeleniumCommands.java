package com.testing.framework.basics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestSelenium07_SeleniumCommands {

    @Test
    @Description ("Verify Page source, title and URL")
    @Owner("Nikhita")
    public void verifyCommands(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        System.out.println( driver.getPageSource());

        //TestNg assetions
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");

        driver.quit();
    }

}
