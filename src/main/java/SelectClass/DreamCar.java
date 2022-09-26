package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class DreamCar {
    @Test
    public void searchCar() throws InterruptedException {

        /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX-350
*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");

        WebElement newUsedBox = driver.findElement(By.xpath("//select[@id=\"make-model-search-stocktype\"]"));
        BrowserUtils.selectBy(newUsedBox, "2", "index");
        WebElement make = driver.findElement(By.xpath("//select[@id=\"makes\"]"));
        BrowserUtils.selectBy(make, "Lexus", "text");
        WebElement model = driver.findElement(By.xpath("//select[@id=\"models\"]"));
        BrowserUtils.selectBy(model, "RX 350", "text");
        WebElement price = driver.findElement(By.xpath("//select[@id=\"make-model-max-price\"]"));
        Select prs = new Select(price);
        WebElement firstOption = prs.getFirstSelectedOption();
      //  String actualOption = firstOption.getText().trim();
        String actualOption=BrowserUtils.getText(firstOption);
        String expectedOption = "No max price";
        Assert.assertEquals(actualOption, expectedOption);
        WebElement distance = driver.findElement(By.xpath("//select[@id=\"make-model-maximum-distance\"]"));
        BrowserUtils.selectBy(distance, "40 miles", "text");
        WebElement zip = driver.findElement(By.xpath("//input[@id=\"make-model-zip\"]"));
        zip.clear();
        zip.sendKeys("60005");
        WebElement searchBtn = driver.findElement(By.xpath("//button[@class=\"sds-button\"]"));
        searchBtn.click();
        WebElement header = driver.findElement(By.xpath("//h1[@class=\"sds-heading--1 sds-page-section__title\"]"));
        String actualOption1 = header.getText().trim();
        String expectedOption1 = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualOption1, expectedOption1);
        WebElement sort = driver.findElement(By.xpath("//select[@id=\"sort-dropdown\"]"));
        BrowserUtils.selectBy(sort, "1", "index");
        Thread.sleep(3000);
       List<WebElement>  allTitles=driver.findElements(By.xpath("//h2[@class=\"title\"]"));
       for(WebElement title :allTitles){

           Assert.assertTrue(title.getText().contains("Lexus RX 350"));
       }
    }
}
