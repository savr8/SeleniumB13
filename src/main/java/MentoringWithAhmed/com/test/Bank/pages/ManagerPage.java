package MentoringWithAhmed.com.test.Bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerPage {

    public ManagerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement addButton;

    @FindBy(xpath = "//button[@ng-click=\"openAccount()\"]")
    WebElement openAccBtn;

    @FindBy(id = "userSelect")
    WebElement customerDdl;

    @FindBy(xpath = "//select[@id=\"currency\"]")
    WebElement curencyDdl;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement processBtn;

    @FindBy(xpath = "//button[@ng-click=\"showCust()\"]")
    WebElement customerBtn;

    @FindBy(xpath = "//tr[@ng-repeat=\"cust in Customers | orderBy:sortType:sortReverse | filter:searchCustomer\"][6]")
    List<WebElement> customerAcc;
    @FindBy(xpath = "//body//table//tr[@class=\"ng-scope\"][6]")
    List<WebElement> allCustomerInfo;

    public void CustomerInformation(WebDriver driver, String firstName, String lastName, String postCode) {
        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        addButton.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Customer added successfully with customer id :6");
        alert.accept();
    }

    public void openAcc(WebDriver driver) {
        openAccBtn.click();
        customerDdl.click();
        BrowserUtils.selectBy(customerDdl, "Savr Muchkaev", "text");
        BrowserUtils.selectBy(curencyDdl, "Dollar", "text");
        processBtn.click();
    }

    public void validatingPopUp(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Account created successfully with account Number :1016";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();

    }

    public void validatingAccount() {
        customerBtn.click();
        List<String> expectedCustomerInfo = Arrays.asList("Savr", "Muchkaev", "19116", "1016", "Delete");
        List<String> actualInformation = new ArrayList<>();
        for (int i = 1; i < allCustomerInfo.size(); i++) {
            actualInformation.add(allCustomerInfo.get(i).getText().trim());
        }
        for (int i = 0; i < actualInformation.size(); i++) {
            Assert.assertEquals(actualInformation.get(i), expectedCustomerInfo.get(i));
        }
    }
}