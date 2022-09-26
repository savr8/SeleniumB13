package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class YahooInterviewQuestion {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.yahoo.com/");

        WebElement news = driver.findElement(By.id("root_2"));
        news.click();

        List<WebElement> allHeaders3 = driver.findElements(By.tagName("//h3"));
        List<WebElement> allHeaders2 = driver.findElements(By.tagName("//h2"));
        for (WebElement allheader : allHeaders3) {
            System.out.println(allheader.getText().trim());
        }
        for (WebElement allheader : allHeaders2) {
            System.out.println(allheader.getText().trim());
        }


    }
}
