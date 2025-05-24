package com.testing.framework.se07_actionsclass;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Actions03_Makemytrip {

    @Test
    @Description("Verify Make My Trip From Element")
    @Owner("Nikhita")
    public void makemyTrip() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement closeModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        closeModal.click();

        WebElement fromCity = driver.findElement(By.xpath("//input[@id='fromCity']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();
        Thread.sleep(3000);

        WebElement input = driver.findElement(By.xpath("//input[@placeholder='From']"));
        input.sendKeys("IXC");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));
        List<WebElement> list = driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));

        for (WebElement e : list) {
            if (e.getText().contains("Chandigarh")) {
                e.click();
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();

    }
}
