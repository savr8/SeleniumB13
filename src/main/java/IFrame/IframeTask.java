package IFrame;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.Acceleration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class IframeTask {
    @Test
    public void task() throws InterruptedException {
 /*
    TASK 1:
    1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
    2-Click Pavillion and Click Selenium-java under Selenium option
    3-Validate the header " Selenium-Java Tutorial – Basic to Advance"

    TASK 2:
    1-Go back to the main page
    2-click "category1"
    3-validate the header "Category Archives: SeleniumTesting"

    TASK 3:
    1-Go back to the main page
    2-click category 3 and validate
    3-validate the header "Category Archives: SoftwareTesting"


     */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(" https://skpatro.github.io/demo/iframes/");
        WebElement pavilionBtn = driver.findElement(By.xpath("//a[@href=\"http://qavalidation.com/\"]"));
        pavilionBtn.click();
        BrowserUtils.switchByTitle(driver, "Home - qavalidation");
        WebElement selenium = driver.findElement(By.xpath("//ul[@id=\"primary-menu\"]//span[.='Selenium']//span"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();
        WebElement seleniumJava = driver.findElement(By.xpath("//ul[@id=\"primary-menu\"]//span[.='Selenium-Java']//span"));
        seleniumJava.click();
        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader, expectedHeader);
        //TASK2
        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver, "SeleniumTesting Archives - qavalidation");
        WebElement header2 = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header2), "Category Archives: SeleniumTesting");

        //TASK3
        BrowserUtils.switchByTitle(driver, "iframes");
        WebElement frame3=driver.findElement(By.xpath("//iframe[@id='Frame2']"));
        driver.switchTo().frame(frame3);
        WebElement category3Btn = driver.findElement(By.xpath("//a[.='Category3']"));
        category3Btn.click();
        BrowserUtils.switchByTitle(driver, "SoftwareTesting Archives - qavalidation");
        WebElement header3 = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowserUtils.getText(header3),"Category Archives: SoftwareTesting");

    }
}
