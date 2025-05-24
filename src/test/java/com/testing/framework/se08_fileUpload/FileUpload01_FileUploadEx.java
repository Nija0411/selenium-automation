package com.testing.framework.se08_fileUpload;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload01_FileUploadEx {

    @Test
    @Description
    public void fileUpload() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/selenium/upload.html");
        driver.manage().window().maximize();

        WebElement fileInput = driver.findElement(By.name("fileToUpload"));

        //It gives the project path: C:\Users\nija0225\Documents\Automation Testing_ATB\selenium_learning
        //hover over the project name you'll get the path
        String working_dir = System.getProperty("user.dir");

        String filePath = working_dir + "/src/test/java/com/testing/framework/se08_fileUpload/Data.txt";

        fileInput.sendKeys(filePath);
        driver.findElement(By.name("submit"));

        Thread.sleep(3000);
        driver.quit();
    }
}
