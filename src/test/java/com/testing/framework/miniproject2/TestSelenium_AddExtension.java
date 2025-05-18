package com.testing.framework.miniproject2;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium_AddExtension {

    //Add an extension to block the YouTube adds.

    //PR- Download the AddBlock.crx file, and paste in your package

    @Test
    @Description("Option Class")
    public void blockAdd() {
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("--window-size=1920,1080");
        edgeoptions.addExtensions(new File("src/test/java/com/testing/framework/miniproject2/Adblock.crx"));

        WebDriver driver = new EdgeDriver(edgeoptions);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");

        driver.manage().deleteAllCookies();
        driver.quit();
    }


}
