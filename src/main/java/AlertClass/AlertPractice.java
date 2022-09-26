package AlertClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertPractice {
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(" https://sweetalert.js.org/");
        WebElement previewBtn = driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewBtn.click();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Oops, something went wrong!";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();

        WebElement previewBtn1 = driver.findElement(By.xpath("//button[@onclick=\"swal('Oops', 'Something went wrong!', 'error')\"]"));
        previewBtn1.click();

        WebElement text = driver.findElement(By.xpath("//div[contains(text(),'Something went wrong!')]"));
        Assert.assertEquals(BrowserUtils.getText(text), "Something went wrong!");
        WebElement btn = driver.findElement(By.xpath("//button[@class=\"swal-button swal-button--confirm\"]"));

        btn.click();
    }
}
