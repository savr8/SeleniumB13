package WindowHandle;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SwichMultipleWindowsPractice {
    @Test
    public void practice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        WebElement Btn2 = driver.findElement(By.xpath("//button[@id=\"newTabsBtn\"]"));
        BrowserUtils.scrollWithJS(driver, Btn2);
        BrowserUtils.clickWithJS(driver, Btn2);
        BrowserUtils.switchByTitle(driver, "Basic Controls");
        //AlertsDemo
        WebElement registerBtn = driver.findElement(By.xpath("//button[@id=\"registerbtn\"]"));
        BrowserUtils.scrollWithJS(driver, registerBtn);
        WebElement firstName = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
        firstName.sendKeys("Savr");
        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        lastName.sendKeys("Muchkaev");
        WebElement languages = driver.findElement(By.id("englishchbx"));
        WebElement gender = driver.findElement(By.xpath("//input[@id=\"malerb\"]"));
        BrowserUtils.clickWithJS(driver, gender);
        WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        email.sendKeys("savr8303@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
        password.sendKeys("lkadflkf");


        BrowserUtils.clickWithJS(driver, registerBtn);
        WebElement message = driver.findElement(By.xpath("//label[contains(text(),'Registration is Successful')]"));

        String atualMessage = BrowserUtils.getText(message);

        String expectedMessage = "Registration is Successful";
        Assert.assertEquals(atualMessage, expectedMessage);
      //  Assert.assertEquals(BrowserUtils.getText(message),"Registration is Successful");
        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        WebElement clickmeBtn = driver.findElement(By.xpath("//button[@id=\"alertBox\"]"));
        BrowserUtils.clickWithJS(driver, clickmeBtn);
        Thread.sleep(3000);
        driver.quit();

    }

}
