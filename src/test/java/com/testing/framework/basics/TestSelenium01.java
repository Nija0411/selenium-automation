package com.testing.framework.basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {

    @Test
    public void launchBrowser(){
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://app.vwo.com"); //Launch the browser
        chromeDriver.quit(); //close the browser
    }
}
