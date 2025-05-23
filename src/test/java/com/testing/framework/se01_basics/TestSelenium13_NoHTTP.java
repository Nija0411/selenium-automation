package com.testing.framework.se01_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium13_NoHTTP {

    @Test
    public void test() {
        WebDriver driver = new EdgeDriver();

        driver.get("www.google.com"); //it won't work
        driver.get("https://www.google.com"); //correct URL
    }
}
