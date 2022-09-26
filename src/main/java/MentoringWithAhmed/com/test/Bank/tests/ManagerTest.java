package MentoringWithAhmed.com.test.Bank.tests;

import MentoringWithAhmed.com.test.Bank.pages.LoginPage1;
import MentoringWithAhmed.com.test.Bank.pages.ManagerPage;
import com.test.sentrifugo.pages.LoginPage;
import com.test.sentrifugo.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class ManagerTest {
    /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE and click OK
10-Click Customers Button
11-Validate your firstname,lastName,PostCode and Account Number
12-driver.quit
13-Proud of yourself
 */
    @Test

    public void validateEmployee() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        LoginPage1 loginPage1 = new LoginPage1(driver);
        Thread.sleep(1000);
        loginPage1.clickManagerButton();
        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.CustomerInformation(driver, "Savr", "Muchkaev", "19116");
        managerPage.openAcc(driver);
        managerPage.validatingPopUp(driver);
        managerPage.validatingAccount();
        driver.quit();

    }

}