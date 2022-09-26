package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");
        /*
        1-navigate to the website
        2-click Horizontal Slider with partial or linkText
        3- Get the text of header print out
        4- Get the text of paragraph print out
        5- Click Elemental Selenium
        6-close your page
         */
        WebElement horizontalSlider = driver.findElement(By.partialLinkText("Slider"));
        horizontalSlider.click();
        Thread.sleep(3000);
        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(header.getText());
        WebElement paragraph = driver.findElement(By.tagName("h4"));
        System.out.println(paragraph.getText());
        Thread.sleep(3000);
        WebElement seleniumElemental = driver.findElement(By.linkText("Elemental Selenium"));
        seleniumElemental.click();
        Thread.sleep(3000);
        driver.quit();//It closes all the pages that open during automation
    }
}
