package com.testing.framework.miniproject1;

import org.openqa.selenium.WebDriver;

public class BaseTest {

    //Open Browser

    public void openBrowser(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    //Close Browser

    public void closeBrowser(WebDriver driver) {
        driver.quit();
    }

}
