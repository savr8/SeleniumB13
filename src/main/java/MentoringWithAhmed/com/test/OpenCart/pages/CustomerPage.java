package MentoringWithAhmed.com.test.OpenCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addNewButton;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    public void customerInfo(String name, String lastName){

        addNewButton.click();
        firstName.sendKeys(name);
        this.lastName.sendKeys(lastName);



    }
}
