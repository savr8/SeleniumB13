package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCaseExample {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions)
//4. Get URL of current page and validate it.
//            5. Close browser.(driver.closed)
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");
        System.out.println(driver.getTitle());
        String actualTitile = driver.getTitle();
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools GoDaddy";
        System.out.println(driver.getTitle());
        if (actualTitile.equals(expectedTitle)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.godaddy.com/";
        if (currentUrl.equals(expectedUrl)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.close();
    }

}
