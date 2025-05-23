package com.testing.framework.se01_basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium11_ChangeDriver {
    //Change Driver

    @Test
    public void changeDriver() {
        ChromeDriver driver = new ChromeDriver();
//      driver = new EdgeDriver(); this is not possible

        WebDriver driver1 = new ChromeDriver();
        driver1 = new EdgeDriver(); //this is possible
    }


}
