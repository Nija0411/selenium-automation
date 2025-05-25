package com.testing.framework.se10_windowsandiframes;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Test02_WindowIframe_IQ {

    WebDriver driver;

    @Test
    @Description("Navigate to Child Window and Click clickmap")
    public void iframeHandle() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1&accountId=666400");
        driver.manage().window().maximize();

        String parent = driver.getWindowHandle();
        System.out.println(parent);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa=\"yedexafobi\"]")));
        List<WebElement> element = driver.findElements(By.xpath("//div[@data-qa=\"yedexafobi\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element.get(1)).click().build().perform();


        Thread.sleep(15000);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        for (String child : windowHandles) {
            if (!child.equals(parent)) {
                driver.switchTo().window(child);
                driver.switchTo().frame("heatmap-iframe");
                WebElement click_map_button = driver.findElement(By.xpath("//span[@data-qa=\"refoyekife\"]"));
                click_map_button.click();

            }

        }
    }

    @AfterTest
    @Description("Close the Browser")
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(30000);
        driver.quit();
    }
}


