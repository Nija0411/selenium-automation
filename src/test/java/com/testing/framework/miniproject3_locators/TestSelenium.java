package com.testing.framework.miniproject3_locators;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium extends BaseTest {

    @Test(priority = 1)
    @Description("Verify Start a free trial Page by invalid email id")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Nikhita")
    public void startTrial() {

        WebElement startTrial = driver.findElement(By.partialLinkText("Start a free"));
        startTrial.click();

        /*
        <input class="W(100%) Py(14px) input-text"
        placeholder="name@yourcompany.com" type="email"
        id="page-v1-step1-email"
        name="email" data-qa="page-su-step1-v1-email" required="">
         */

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("invalid_email");

        /* <div class="D(f) Ai(b) ">
                <input class="Cur(p) Flxs(0) M(0) Pos(r) T(2px)"
                type="checkbox"
                name="gdpr_consent_checkbox"
                id="page-free-trial-step1-cu-gdpr-consent-checkbox" value="true" data-qa="page-free-trial-step1-gdpr-consent-checkbox">
                <label for="page-free-trial-step1-cu-gdpr-consent-checkbox" class="Ta(start) Cur(p) Fz($font-size-12) Mstart(10px) Us(n)">
                I agree to VWO's <a class="C($color-blue) white_C($color-white)" href="https://vwo.com/privacy-policy/" target="_blank">Privacy Policy</a> &amp; <a href="https://vwo.com/terms/" class="C($color-blue) white_C($color-white)" target="_blank">Terms</a>    </label>
                </div>
         */

        WebElement checkbox = driver.findElement(By.id("page-free-trial-step1-cu-gdpr-consent-checkbox"));
        checkbox.click();

        //Create a free trial account button
        /*
        <button type="submit"
        class="button W(100%) btn-modal-form-submit"
        data-qa="page-su-submit">Create a Free Trial Account</button>
         */
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

       /*
        <div class="C($color-red) Fz($font-size-12) Trsp($Op) Trsdu(0.15s) Op(0) invalid-input+Op(1)
        invalid-reason">
        The email address you entered is incorrect.</div>

        here we have multiple classes and each class seperated by a space, so you can use className here
        */

        WebElement error_msg = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(error_msg.getText(), "The email address you entered is incorrect.");
    }

}
