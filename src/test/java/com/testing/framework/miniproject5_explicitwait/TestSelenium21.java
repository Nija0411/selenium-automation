package com.testing.framework.miniproject5_explicitwait;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium21 extends BaseTest {

    @Test
    @Description("Verify Close Model")
    public void closeModel() {
        visibilityofCrossModel(3, "//span[@class='commonModal__close']");

        WebElement closeModel = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
        closeModel.click();
    }
}
