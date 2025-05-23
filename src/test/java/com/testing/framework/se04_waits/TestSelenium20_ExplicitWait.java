package com.testing.framework.se04_waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;

public class TestSelenium20_ExplicitWait {

    @Test
    @Description("Verify Explicit Wait")
    public void explicitWait() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); //opens incognito mode
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://app.vwo.com");

        assertThat(driver.getCurrentUrl().equals("https://app.vwo.com/#/login"));

        WebElement email = driver.findElement(By.xpath("//input[@id='login-username']"));
        email.sendKeys("admin@admin.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
        password.sendKeys("password@321");

        WebElement signIn = driver.findElement(By.xpath("//button[@type='submit']"));
        signIn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notification-box-description']")));

        WebElement error_msg = driver.findElement(By.xpath("//div[@class='notification-box-description']"));
        assertThat(error_msg.getText().equals("Your email, password, IP address or location did not match"));


        driver.quit();
    }
}
