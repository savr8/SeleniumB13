package com.test.sentrifugo.tests;

import TestNG.FullNameDataProvider;
import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class LoginTest extends LoginTestDataProvider {
    @Test
    public void validatePositivelogin() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("EM01", "sentrifugo");
        Assert.assertEquals(driver.getCurrentUrl(), "http://demo.sentrifugo.com/index.php/index/welcome");
    }

    @Test
    public void validateNegative() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        //Please enter username or email.
        LoginPage validate = new LoginPage(driver);
        Assert.assertEquals(loginPage.usernameErrorMessage(), "Please enter username or email.");
        Assert.assertEquals(loginPage.passwordErrorMessage(), "Please enter password.");
        Assert.assertEquals(loginPage.usernameErrorColor(), "rgba(255, 0, 0, 1)");
        Assert.assertEquals(loginPage.passwordErrorColor(), "rgba(255, 0, 0, 1)");

    }

//    @Test(dataProvider = "fullLogin", dataProviderClass = LoginTestDataProvider.class)
//    public void validationOfLogin(String userName,String password) {
//        WebDriver driver = DriverHelper.getDriver();
//        driver.get("http://demo.sentrifugo.com/index.php/");
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login(userName,password);
//        Assert.assertTrue(driver.getCurrentUrl().contains("welcome"));//you are testing
//        driver.quit();
//
//    }

    @Test(dataProvider = "fullLogin")
    public void validationOfLoginExtention(String userName,String password) {
        WebDriver driver = DriverHelper.getDriver();
        driver.get("http://demo.sentrifugo.com/index.php/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password);
        Assert.assertTrue(driver.getCurrentUrl().contains("welcome"));//you are testing
        driver.quit();

    }
}
