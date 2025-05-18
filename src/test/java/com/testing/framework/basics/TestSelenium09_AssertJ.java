package com.testing.framework.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestSelenium09_AssertJ {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //AssertJ
        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://www.google.com/");
        assertThat(driver.getTitle()).isNotNull().isAlphabetic().isEqualTo("Google");

        driver.quit();
    }
}
