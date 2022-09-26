package MentoringWithAhmed.com.test.OpenCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void loginToWebSite(){

        userName.sendKeys(ConfigReader.readProperty("openChartUserName"));
        password.sendKeys(ConfigReader.readProperty("openChartPassword"));
        loginButton.click();

    }
}
