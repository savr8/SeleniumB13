package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class CSSLocator {
    @Test

    public void cssLocatorIdPractice(){
        WebDriverManager .chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.etsy.com/");

        WebElement shearchBar=driver.findElement(By.cssSelector("#global-enhancements-search-query"));
        shearchBar.sendKeys("Watch", Keys.ENTER);

    }
    @Test
    public void cssLocatorClassPractice(){
        WebDriverManager .chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///C:/Users/12672/Downloads/Techtorialhtml.html");

        WebElement allTools=driver.findElement(By.cssSelector(".group_checkbox"));
        System.out.println(BrowserUtils.getText(allTools));

    }
}
