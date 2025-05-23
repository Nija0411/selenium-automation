package com.testing.framework.se02_locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestSelenium16_Locators_Id_Name_ClassName {

    @Test
    @Description("Locators")
    @Owner("Nikhita")
    public void loctors() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://app.vwo.com");

//      driver.manage().window().maximize();

        //Start testing - Verify page should throw an error msg after entering incorrect email and password
        /*
        1. Locate email id box and enter email - incorrect@incorrect.com
        2. Locate the password text box and enter the pswd - 1234
        3. Locate the submit button and click on submit
        4. Wait for some time
        5. Verify the error msg
         */

        //Step1: Locate email and enter email id, first copy the html input tag from n/w tab
       /* <input type="email"
       class="text-input W(100%)"
       name="username"
       id="login-username"
       data-qa="hocewoqisi">

       here we have id so will find an element by id
        */

        WebElement email_box = driver.findElement(By.id("login-username"));
        email_box.sendKeys("incorrect@incorrect.com");

        //Step 2 - Locate an Password and enter
        /*
        <input type="password"
        class="text-input W(100%)"
        name="password"
        id="login-password"
        data-qa="jobodapuxe">

        in this case you can use id or name but don't use classname to locate an element bcz it is dynamid
         */

        WebElement pswd = driver.findElement(By.name("password"));
        pswd.sendKeys("1234");

        //Step 3 - Locate and click submit
     /*
       <button type="submit"
       id="js-login-btn"
       class="btn btn--positive btn--inverted W(100%) H(48px) Fz(16px)" onclick="login.login(event)" data-qa="sibequkica">
       <span class="icon loader hidden" data-qa="zuyezasugu"></span>
       <span data-qa="ezazsuguuy">Sign in</span>
       </button>
      */

        WebElement signin_button = driver.findElement(By.id("js-login-btn"));
        signin_button.click();

        //Ste 4 - Wait for sometime
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Step 5 - Verify error msg -Your email, password, IP address or location did not match
        /*
        <div class="notification-box-description"
        id="js-notification-box-msg" data-qa="rixawilomi">Your email, password, IP address or location did not match</div>
         */

        WebElement error_msg = driver.findElement(By.className("notification-box-description"));
        System.out.println(error_msg.getText());

        //Using AssertJ
        assertThat(error_msg.getText()).isNotNull();

        //Using TestNG
        Assert.assertEquals(error_msg.getText(), "Your email, password, IP address or location did not match");

        driver.quit();
    }


}
