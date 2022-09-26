package SavrPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/");
        WebElement serchBox = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        serchBox.click();
        serchBox.sendKeys("Gaming Laptop");
        WebElement searcBtn = driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
        searcBtn.click();
        WebElement laptop = driver.findElement(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
        laptop.click();
    }
}
