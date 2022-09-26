package SavrPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FacebookLoginPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        WebElement name = driver.findElement(By.xpath("//input[@class=\"inputtext _55r1 _6luy\"]"));
        name.click();
        name.sendKeys("sd..sv.,");
        WebElement password = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        password.click();
        password.sendKeys("dfslalkmd");
        WebElement logBtn=driver.findElement(By.xpath("//button[@name=\"login\"]"));
        logBtn.click();

        WebElement errorMsg=driver.findElement(By.xpath("//div[@class=\"_9ay7\"]"));
        String expectedError ="The email or mobile number you entered isn’t connected to an account.";
        String actualError=errorMsg.getText().trim();
        Assert.assertEquals(actualError,expectedError);//
     //   Assert.assertTrue(actualError.equals(expectedError));same thing|
    }
}
