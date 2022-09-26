package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookProPage {
    public MacBookProPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement nameOfBrands;

    @FindBy(tagName = "h3")
    WebElement price;

    @FindBy(id = "myTabContent")
    WebElement description;

    @FindBy(xpath = "//a[.=\"Add to cart\"]")
    WebElement addToCart;

    @FindBy(id = "cartur")
    WebElement cartButton;

    public String validationProductName() {
        return BrowserUtils.getText(nameOfBrands);
    }

    public String validationPrice() {
        return BrowserUtils.getText(price);
    }

    public String validationDescription() {
        return BrowserUtils.getText(description);
    }

    public void addToCartclick() {
        addToCart.click();
    }

    public void validateMessage(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText().trim(), "Product added");
        alert.accept();
    }

    public void clickCartButton() {
        cartButton.click();
    }

}
