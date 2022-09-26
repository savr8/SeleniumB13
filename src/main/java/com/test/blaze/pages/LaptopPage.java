package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {
    public LaptopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"hrefch\"]")//6 elements laptops
    List<WebElement> allBrands;

    public void chooseLaptop(WebDriver driver, String brand) throws InterruptedException {
        Thread.sleep(3000);
        for (WebElement laptop : allBrands) {
            if (BrowserUtils.getText(laptop).contains(brand)) {
                BrowserUtils.scrollWithJS(driver, laptop);
                laptop.click();
                break;
            }
        }
    }

}
