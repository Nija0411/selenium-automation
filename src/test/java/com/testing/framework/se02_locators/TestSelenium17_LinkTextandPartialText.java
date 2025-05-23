package com.testing.framework.se02_locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestSelenium17_LinkTextandPartialText {

    @Test
    @Description("Verify app.vwo using LinkText Locator")
    @Owner("Nikhita")
    public void verifyHyperlink() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        //Locate a Start a free-trail hyperlink
        /*
        <a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage" class="text-link" data-qa="bericafeqo">Start a free trial</a>
         */
        WebElement startTrial = driver.findElement(By.linkText("Start a free trial"));
        // This will work only if the entire visible text exactly matches "Start a free trial"
        startTrial.click();
        String trialURL = driver.getCurrentUrl();

        //verification
        assertThat(trialURL).contains("free-trial");

        Thread.sleep(5000);

        driver.quit();

    }

    @Test
    @Description("Verify vwo using partial link text")
    public void verifyHyperlink1() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        //Locate a Start a free-trail hyperlink
        /*
        <a href="https://vwo.com/free-trial/?utm_medium=website&amp;utm_source=login-page&amp;utm_campaign=mof_eg_loginpage" class="text-link" data-qa="bericafeqo">Start a free trial</a>
         */

        WebElement startTrial = driver.findElement(By.partialLinkText("start"));
        // PartialLinkText works even if only part of the link text is provided (case-sensitive)
        startTrial.click();

        String trialURL = driver.getCurrentUrl();

        assertThat(trialURL.contains("free-trial"));

        Thread.sleep(3000);

        driver.quit();
    }
}
