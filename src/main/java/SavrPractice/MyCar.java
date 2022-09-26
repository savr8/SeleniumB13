package SavrPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class MyCar {
    @Test
    public void searchCar() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cars.com/");

        WebElement newUsedBox = driver.findElement(By.xpath("//select[@id=\"make-model-search-stocktype\"]"));
        BrowserUtils.selectBy(newUsedBox, "2", "index");
        WebElement make = driver.findElement(By.xpath("//select[@id=\"makes\"]"));
        BrowserUtils.selectBy(make, "Rolls-Royce", "text");
        WebElement model = driver.findElement(By.xpath("//select[@id=\"models\"]"));
        BrowserUtils.selectBy(model, "Cullinan", "text");
        WebElement price = driver.findElement(By.xpath("//select[@id=\"make-model-max-price\"]"));
        BrowserUtils.selectBy(price, "0", "index");
        WebElement distance = driver.findElement(By.xpath("//select[@id=\"make-model-maximum-distance\"]"));
        BrowserUtils.selectBy(distance, "100 miles", "text");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        searchBtn.click();

        Thread.sleep(2000);
        List<WebElement> allcars = driver.findElements(By.xpath("//div[@data-tracking-orientation=\"vertical\"]"));
        for (WebElement car : allcars) {
            Assert.assertTrue(car.getText().contains("Rolls-Royce Cullinan "));
        }
        Thread.sleep(2000);
        WebElement dropDownSortBy = driver.findElement(By.xpath("//select[@id=\"sort-dropdown\"]"));
        BrowserUtils.selectBy(dropDownSortBy, "2", "index");
        Thread.sleep(2000);
        WebElement choseCar = driver.findElement(By.xpath("//div[@class=\"vehicle-card-main js-gallery-click-card\"]//a[@href=\"/vehicledetail/884ea364-573d-4768-8bfe-afcd042bcdf8/\"]"));
        choseCar.getLocation();
        Thread.sleep(5000);
        choseCar.click();
        WebElement pictureBtn=driver.findElement(By.xpath("//div[@class=\"rectangle rectangle-right\"]"));
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();
        Thread.sleep(1000);
        pictureBtn.click();





    }
}
