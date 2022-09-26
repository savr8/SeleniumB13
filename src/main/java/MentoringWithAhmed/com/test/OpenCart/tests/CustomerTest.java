package MentoringWithAhmed.com.test.OpenCart.tests;

import MentoringWithAhmed.com.test.OpenCart.pages.CustomerPage;
import MentoringWithAhmed.com.test.OpenCart.pages.LoginPage;
import MentoringWithAhmed.com.test.OpenCart.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


    public class CustomerTest extends TestBase{

       @Parameters({"fistName", "lastName"})

        @Test
        public void validateMessage(String name, String lastName){

            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginToWebSite();
            MainPage mainPage = new MainPage(driver);
            mainPage.validateInformation();

            CustomerPage customerPage = new CustomerPage(driver);
            customerPage.customerInfo(name, lastName);


        }
}
