package MentoringWithAhmed.com.test.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


public class LoginPage1 {

  public LoginPage1(WebDriver driver) {

    PageFactory.initElements(driver, this);
    }
  @FindBy(xpath = "//button[.=\"Bank Manager Login\"]")
  WebElement managerButton;

  public void clickManagerButton() {

    managerButton.click();
  }

}

