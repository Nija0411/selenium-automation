package com.testing.framework.miniproject1;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium10 extends BaseTest {

    @Test
    @Description("Verify the webpage contain the CURA Healthcare Service")
    @Owner("Nikhita")
    public void verifyURL() throws Exception {
        WebDriver driver = new ChromeDriver();
        openBrowser(driver, "https://katalon-demo-cura.herokuapp.com/");

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");

        if (driver.getPageSource().contains("CURA Healthcare Service")) {
            System.out.println("Test Case Passed");
            Assert.assertTrue(true);
        } else {
            Assert.fail("CURA Healthcare Service text is not available");
//          throw new Exception("CURA Healthcare Service text is not available");
        }
    }
}
