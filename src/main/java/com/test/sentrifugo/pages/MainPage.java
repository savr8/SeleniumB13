package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title=\"Departments\"]")
    WebElement departmentButton;
    @FindBy(xpath = "//li[@id=\"main_parent_5\"]")
    WebElement backGroundCheckButton;

    public void clickDepartment() {
        departmentButton.click();
    }

    public void clickBackGroundCheck() {
        backGroundCheckButton.click();
    }


}
