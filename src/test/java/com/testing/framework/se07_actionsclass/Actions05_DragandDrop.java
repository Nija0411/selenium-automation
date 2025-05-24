package com.testing.framework.se07_actionsclass;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Actions05_DragandDrop {

    @Test
    @Description("Verify Drag and Drop using Actions class")
    public void dragDrop() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement from = driver.findElement(By.xpath("//div[@id='column-a']"));
        WebElement to = driver.findElement(By.xpath("//div[@id='column-b']"));

        actions.dragAndDrop(from, to).build().perform();

        Thread.sleep(3000);
        driver.quit();
    }
}
