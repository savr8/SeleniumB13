package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertIntro {
    @Test
    public void alertAcceptAndGetText() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        jsAlert.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText="I am a JS Alert";
        Assert.assertEquals(actualText,expectedText);
        alert.accept();
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
        WebElement message=driver.findElement(By.id("result"));
        Assert.assertEquals(BrowserUtils.getText(message),"You successfully clicked an alert");
    }
    @Test
    public void Dismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText="I am a JS Confirm";
        Assert.assertEquals(actualText,expectedText);
        alert.dismiss();
        WebElement message=driver.findElement(By.id("result"));
        Assert.assertEquals(BrowserUtils.getText(message),"You clicked: Cancel");
    }
    @Test
    public void SendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPromt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        jsPromt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I am a JS prompt");
        alert.accept();
        //You entered: I am a JS prompt
        WebElement message=driver.findElement(By.id("result"));
        Assert.assertEquals(BrowserUtils.getText(message),"You entered: I am a JS prompt");
    }
}
