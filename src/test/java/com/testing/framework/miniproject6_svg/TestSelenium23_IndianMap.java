package com.testing.framework.miniproject6_svg;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestSelenium23_IndianMap {

    WebDriver driver;

    @BeforeTest
    @Description("Open Browser")
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterTest
    @Description("Close Browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    @Description("Locate a Karnataka in Indian map and Zoom it")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nikhita")
    public void indianMap() {
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name='path']")));

        List<WebElement> locateStates = driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name='path']"));

        for (WebElement states : locateStates) {
            String statename = states.getAttribute("aria-label");
            System.out.println(statename);

            if (statename.contains("Karnataka")) {
                states.click();
            }
        }

    }
}
