package MentoringWithAhmed.com.test.OpenCart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn-close")
    WebElement xButton;

    @FindBy(xpath = "//h2[@class='float-end']")
    List<WebElement> dashBoardValues;

    @FindBy(xpath = "//li[@id='menu-customer']")
    WebElement mainCustomer;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement subCustomer;

    public void validateInformation(){

        xButton.click();
        List<String> expectedValues = Arrays.asList("93", "23.9K", "4.5K", "78");

        for (int i = 0; i < dashBoardValues.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(dashBoardValues.get(i)), expectedValues.get(i));
        }

        mainCustomer.click();
        subCustomer.click();
    }
}
