package com.testing.framework.se12_RelativeLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import static org.assertj.core.api.Assertions.*;

public class Test02_EmailValidation_Negative {

    @Test
    @Description
    public void emailValidator() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location='https://codepen.io/AbdullahSajjad/full/LYGVRgK'");
        driver.manage().window().maximize();

        driver.switchTo().frame("result");

        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"Enter Username\"]"));
        username.sendKeys("ABC123");

        WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        email.sendKeys("abc");

        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.sendKeys("LNMJKKJK0900@");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id=\"password2\"]"));
        confirmPassword.sendKeys("LNMJKKJK0900@");

        driver.findElement(By.xpath("//form[@id=\"form\"]/button[text()=\"Submit\"]")).click();

        WebElement errorMsg = driver.findElement(with(By.xpath("//div[@class=\"form-control error\"]/small[contains(text(),\"Email is not invalid\")]")).below(email));

        //One more way to locate error msg
        WebElement errorMsg1 = driver.findElement(with(By.tagName("small")));

        assertThat(errorMsg.getText().equals("Email is not invalid"));

        //TestNg assertion
//        Assert.assertEquals(errorMsg.getText(), "Email is not invalid");

        Thread.sleep(3000);
        driver.quit();

    }
}
