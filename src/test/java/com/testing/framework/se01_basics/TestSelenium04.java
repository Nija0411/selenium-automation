package com.testing.framework.se01_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSelenium04 {
    public static void main(String[] args) {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");

    }
}
