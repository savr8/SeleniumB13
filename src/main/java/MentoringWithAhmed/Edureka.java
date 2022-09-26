package MentoringWithAhmed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class Edureka {
    @Test
    public void printAllContents() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.edureka.co/");
        Actions actions = new Actions(driver);


        WebElement browserCategories = driver.findElement(By.xpath("//a[@class=\"dropdown-toggle hidden-xs hidden-sm ga_browse_top_cat\"]"));
        actions.moveToElement(browserCategories).perform();
        Thread.sleep(2000);
        WebElement softwareTesting = driver.findElement(By.xpath("//a[@href=\"/software-testing-certification-courses\" and contains(text(),'Software Testing')]"));
        actions.moveToElement(softwareTesting).perform();

        WebElement seleniumCertificTrainingCource = driver.findElement(By.xpath("//a[@class=\"ga_top_categories_course\" and contains(text(),'Selenium Certification Training Course')]"));
        actions.click(seleniumCertificTrainingCource).perform();
        Thread.sleep(2000);
        WebElement javaRefresher = driver.findElement(By.xpath("//h3[.='Java Basics Refresher for Selenium Training Course']"));
        List<WebElement> alltexts = driver.findElements(By.xpath("//div[@id=\"21930\"]//div[@class=\"ul-li-content-clp\"]//li"));
        for (WebElement text : alltexts) {
            System.out.println(BrowserUtils.getText(text));
        }

    }
}
