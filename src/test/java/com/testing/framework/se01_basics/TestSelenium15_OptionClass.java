package com.testing.framework.se01_basics;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium15_OptionClass {

    @Test
    public void optionClass() throws InterruptedException {

        // Create EdgeOptions object to customize browser behavior
        EdgeOptions edgeOptions = new EdgeOptions();
        // like that we also have: FirefoxOptions, ChromeOptions, SafariOptions

        /*
         * You can set various browser options using EdgeOptions like:
         * - Headless mode (no UI, faster execution)
         * - Incognito mode (private browsing)
         * - Start maximized
         * - Set window size
         * - Add browser extensions
         * - Set download directories, allow insecure certificates, etc.
         * Full list of Chromium command-line switches:
         * https://peter.sh/experiments/chromium-command-line-switches/
         */

        // Uncomment and modify these lines as needed:
        // edgeOptions.addArguments("--window-size=1280,720");
        // edgeOptions.addArguments("--window-size=800,600");

        // Enable Incognito Mode
        edgeOptions.addArguments("--incognito");

        // Start Browser Maximized
        edgeOptions.addArguments("--start-maximized");

        // Initialize EdgeDriver with the specified options
        EdgeDriver driver = new EdgeDriver(edgeOptions);

        // Let the browser stay open for 5 seconds (just for demo purposes)
        Thread.sleep(5000);

        // Quit the browser and end the WebDriver session
        driver.quit();
    }
}

