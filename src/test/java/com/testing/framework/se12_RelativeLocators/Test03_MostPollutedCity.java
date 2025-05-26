package com.testing.framework.se12_RelativeLocators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Test03_MostPollutedCity {

    WebDriver driver;

    @Test
    @Description("Verify the Most Polluted Cities in India by rank and AQI")
    @Owner("Nikhita")
    @Severity(SeverityLevel.CRITICAL)
    public void mostPollutedCities() throws InterruptedException {
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://www.aqi.in/real-time-most-polluted-city-ranking'");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        searchBox.sendKeys("india" + Keys.ENTER);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]")));

        Thread.sleep(5000);

        List<WebElement> locations = driver.findElements(By.xpath("//div[contains(@class,\"location-name\")]/p"));
        int count = locations.size();
        for (int i = 0; i < count; i++) {
            // Re-locate the location element freshly so that you will not get StaleElementReferenceException
            WebElement location = driver.findElements(By.xpath("//div[contains(@class,'location-name')]/p")).get(i);
            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String aqi = driver.findElement(with(By.tagName("div")).toRightOf(location)).getText();

            System.out.println("|" + rank + " |" + location.getText() + " |" + aqi + " |");

        }
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
