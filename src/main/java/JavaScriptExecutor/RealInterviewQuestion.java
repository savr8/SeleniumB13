package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class RealInterviewQuestion {
    @Test
    public void interview() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.thespruceeats.com/");
        WebElement weather = driver.findElement(By.xpath("//a[.='Warm-Weather Treats']"));
        BrowserUtils.scrollWithJS(driver, weather);
        WebElement clickVideoBtn = driver.findElement(By.xpath("//div[@class=\"jw-icon jw-icon-display jw-button-color jw-reset\"]"));
        // BrowserUtils.clickWithJS(driver,clickVideoBtn);
        clickVideoBtn.click();
    }
}
