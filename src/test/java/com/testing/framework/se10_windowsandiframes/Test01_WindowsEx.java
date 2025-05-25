package com.testing.framework.se10_windowsandiframes;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class Test01_WindowsEx {

    @Test
    @Description("Verify Parent and Child Window Handles")
    public void win() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();

        String parent = driver.getWindowHandle();
        System.out.println(parent);

        WebElement clickHere = driver.findElement(By.xpath("//a[@target='_blank']"));
        clickHere.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        for (String child : windowHandles) {
            driver.switchTo().window(child);
            if (driver.getPageSource().contains("New Window")) {
                System.out.println("Test Case Passed");
            }
            driver.switchTo().window(parent);
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
