package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath(//div)
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(id = "loginsubmit")
    WebElement loginButton;
    @FindBy(id = "usernameerror")
    WebElement userNameError;
    @FindBy(id = "pwderror")
    WebElement passwordError;

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();

    }

    public String usernameErrorMessage() {
        return BrowserUtils.getText(userNameError);

    }

    public String passwordErrorMessage() {
        return BrowserUtils.getText(passwordError);
    }

    public String usernameErrorColor() {
        return userNameError.getCssValue("color");
    }

    public String passwordErrorColor() {
        return passwordError.getCssValue("color");
    }
}
