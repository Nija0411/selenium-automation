package com.testing.framework.se05_svg;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium22_FlipkartSvg {
    WebDriver driver;

    @BeforeTest
    @Description("Open Browser")
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); //Waits till page loads completely
        options.addArguments("--guest"); //Will open browser in guest mode
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

    }

    @AfterTest
    @Description("Close the Browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    @Description("Verify you are able to search for Macmini in flipkart using search icon")
    @Severity(SeverityLevel.CRITICAL)
    public void searchFlipkart() {
        driver.get("https://www.flipkart.com/");

        //Step 1- Enter the Macmini in the input box
        //Step 2 - Click on the search icon

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("macmini");

        List<WebElement> search = driver.findElements(By.xpath("//*[name()='svg']"));
        if (!search.isEmpty()) {
            search.get(0).click();
        } else {
            System.out.println("No SVG elements found on the page.");
        }

        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement title : titles) {
            System.out.println(title.getText());
        }
    }
}
