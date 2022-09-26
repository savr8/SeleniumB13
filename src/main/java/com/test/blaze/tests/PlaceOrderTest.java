package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class PlaceOrderTest extends TestBase {
//    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://www.demoblaze.com/#");
//    }

    @Parameters({"brand", "name", "country", "city", "creditcard", "month", "year", "message"})
    @Test
    public void validatePurchaseMessage(String brand, String name, String country, String city, String creditCard
            , String month, String year, String message) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptops();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop(driver, brand);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.addToCartclick();
        macBookProPage.validateMessage(driver);
        CartPage cartPage = new CartPage(driver);
        macBookProPage.clickCartButton();
        cartPage.clickPlaceOrderButton();
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.fillAllInformation(name, country, city, creditCard, month, year);
        Assert.assertEquals(placeOrderPage.finalMessage(), message);
        placeOrderPage.clickOkButton();
    }

    @Test(dataProvider = "validationCustomer", dataProviderClass = CustomerDataProvider.class)
    public void validatePurchaseMessageWithDataProvider(String brand, String name, String country, String city, String creditCard
            , String month, String year, String message) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptops();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.chooseLaptop(driver, brand);
        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.addToCartclick();
        macBookProPage.validateMessage(driver);
        CartPage cartPage = new CartPage(driver);
        macBookProPage.clickCartButton();
        cartPage.clickPlaceOrderButton();
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.fillAllInformation(name, country, city, creditCard, month, year);
        Assert.assertEquals(placeOrderPage.finalMessage(), message);
        placeOrderPage.clickOkButton();
    }
//    @AfterMethod
//    public void tearDown() {
//          driver.quit();
//    }

}
