package MentoringWithAhmed.com.test.OpenCart.tests;

import MentoringWithAhmed.com.test.OpenCart.pages.LoginPage;
import MentoringWithAhmed.com.test.OpenCart.pages.MainPage;
import org.testng.annotations.Test;


    public class MainTest extends TestBase{

        @Test
        public void validateData(){

            LoginPage loginPage  = new LoginPage(driver);
            loginPage.loginToWebSite();
            MainPage mainPage = new MainPage(driver);
            mainPage.validateInformation();
        }
}
