package com.testing.framework.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSelenium06_Selenium03Driver_Setup {

    public static void main(String[] args) {

        // ===== Selenium 3.14 - Manual Driver Setup =====
        // Uncomment and modify the paths based on your local driver location

        // For Edge
        // System.setProperty("webdriver.edge.driver", "C:/path/to/msedgedriver.exe");
        // WebDriver driver = new EdgeDriver();

        // For Firefox
        // System.setProperty("webdriver.gecko.driver", "C:/path/to/geckodriver.exe");
        // WebDriver driver = new FirefoxDriver();

        // For Chrome
        // System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
        // WebDriver driver = new ChromeDriver();

        // For Internet Explorer
        // System.setProperty("webdriver.ie.driver", "C:/path/to/IEDriverServer.exe");
        // WebDriver driver = new InternetExplorerDriver();

        // For Safari (only works on macOS with SafariDriver enabled)
        // System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
        // WebDriver driver = new SafariDriver();


        // ===== Selenium 4.x - Selenium Manager (Auto Driver Setup) =====
        // Just create the driver directly — no need to set driver path manually

        WebDriver driver = new EdgeDriver(); // or new ChromeDriver(), FirefoxDriver() etc.
        driver.get("https://www.google.com");

        System.out.println("Page Title: " + driver.getTitle());
        driver.quit();
    }
}
