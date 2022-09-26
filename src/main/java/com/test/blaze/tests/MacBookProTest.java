package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacBookProTest extends TestBase{
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://www.demoblaze.com/#");
//    }

    @Test
    public void validateProduct() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptops();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop(driver, "MacBook Pro");
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        Assert.assertEquals(macBookProPage.validationProductName(), "MacBook Pro");
        Assert.assertEquals(macBookProPage.validationPrice(), "$1100 *includes tax");
        Assert.assertEquals(macBookProPage.validationDescription(), "Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        macBookProPage.addToCartclick();
        macBookProPage.validateMessage(driver);
        macBookProPage.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickPlaceOrderButton();
    }

//    @AfterMethod
//    public void tearDown() {
//        //   driver.quit();
//    }
}
