package com.test.blaze.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("blazeurl"));

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            BrowserUtils.getScreenShot(driver, "BlazeScreenShot");
        }
        //   driver.quit();
    }
}
