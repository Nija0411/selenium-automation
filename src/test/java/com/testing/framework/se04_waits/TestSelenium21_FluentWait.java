package com.testing.framework.se04_waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSelenium21_FluentWait {

    @Test
    @Description("Verify Fluent Wait")
    public void fluentWait() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://app.vwo.com");
        driver.manage().window().maximize();

        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/login");

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("admin123@admin.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("password123");

        WebElement signin = driver.findElement(By.xpath("//button[@type='submit']"));
        signin.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//div[@class='notification-box-description']"));
            }
        });

        assertThat(error_message.getText().equals("Your email, password, IP address or location did not match"));
        driver.quit();

    }
}
