package com.testing.framework.se01_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium12_NavigateToCommand {

    @Test
    public void test() {
        WebDriver driver = new EdgeDriver();

        //these both are same
        driver.get("https://www.google.com");

        // Using .navigate().to() - same as get() but allows chaining with back/forward/refresh
        driver.navigate().to("https://www.google.com");

        // Navigate back (will go to the previous page in history)
        driver.navigate().back();

        // Navigate forward (if back was called before)
        driver.navigate().forward();

        // Refresh the page
        driver.navigate().refresh();

    }
}
