package com.testing.framework.se01_basics;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestSelenium02 {

    @Test
    @Description("TC#1 Verify the URL of the webpage")
    public void verifyURL() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://app.vwo.com");

        //TestNG Assertion
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://app.vwo.com/#/login");
        assertThat(webDriver.getTitle()).isNotBlank().isEqualTo("Login - VWO");

        webDriver.quit();
    }

    @Test
    @Description("TC#2 Verify the Title of the Page")
    @Owner("Nikhita")
    public void verifyTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        driver.quit();
    }
}
