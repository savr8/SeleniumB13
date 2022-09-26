package MentoringWithAhmed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Register {
    @Test
    public void register() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

        WebElement firstName = driver.findElement(By.xpath("//input[@id=\"input-firstname\"]"));
        firstName.sendKeys("Savr");
        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"input-lastname\"]"));
        lastName.sendKeys("Muchkaev");
        WebElement email = driver.findElement(By.xpath("//input[@id=\"input-email\"]"));
        email.sendKeys("savr@gmail.com");
        WebElement telephone = driver.findElement(By.xpath("//input[@id=\"input-telephone\"]"));
        telephone.sendKeys("2672075299");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("Password");
        WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id=\"input-confirm\"]"));
        passwordConfirm.sendKeys("Password");
        WebElement subscribe = driver.findElement(By.xpath("//input[@value='0']"));
        subscribe.click();
        WebElement continueBtn= driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]"));
        continueBtn.click();

    }
}
