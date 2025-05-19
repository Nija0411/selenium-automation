package com.testing.framework.miniproject4_xpath;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSelenium extends BaseTest {

    @Test(priority = 1)
    @Description("Click on Make Appointment button using XPath and Verify the navigation URL")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nikhita")
    public void clickButton() {

        //usind default locators
        //WebElement makeAppoint_id = driver.findElement(By.id("btn-make-appointment"));

        //using XPath - findElement() method
        //Copy below html tag from dev tools
        //<a id="btn-make-appointment" href="./profile.php#login" class="btn btn-dark btn-lg">Make Appointment</a>
        WebElement makeAppoint_element = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppoint_element.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("TestCase1 Passed");
    }

    @Test(priority = 2, dependsOnMethods = {"clickButton"})
    @Description("Navigate to Make Appointment and verify Invalid Login Handle")
    @Severity(SeverityLevel.NORMAL)
    public void validateLogin() throws InterruptedException {
        // Continue on the same page (login form is already loaded from clickButton)
        //Using XPath - findElements method

        List<WebElement> username = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        username.get(1).sendKeys("User_Name04"); //we are returning list so we need to specify index, we want 2nd box to locate

        List<WebElement> password = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password.get(1).sendKeys("password123");

        WebElement clickLogin = driver.findElement(By.xpath("//button[@id='btn-login']"));
        clickLogin.click();

        //Verify error msg
        // <p class="lead text-danger">Login failed! Please ensure the username and password are valid.</p>
        Thread.sleep(1000);
        WebElement error_msg = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
        Assert.assertEquals(error_msg.getText(), "Login failed! Please ensure the username and password are valid.");
        System.out.println("TestCase2 Passed");

    }


}
