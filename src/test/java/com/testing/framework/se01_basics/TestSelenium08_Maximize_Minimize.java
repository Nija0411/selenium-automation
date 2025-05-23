package com.testing.framework.se01_basics;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium08_Maximize_Minimize {

    @Test
    public void test(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");

        driver.manage().window().maximize(); //maximize the web page loaded
//      driver.manage().window().minimize();

        driver.quit();
    }
}
