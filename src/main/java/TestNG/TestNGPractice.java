package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TransferQueue;

public class TestNGPractice {

    @Test
    public void validateTitleAndUrl() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("demo");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
        loginBtn.click();
        Thread.sleep(3000);
        WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
        closeBtn.click();
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.opencart.com/admin/";
        Assert.assertEquals(actualUrl.contains(expectedUrl), true);
    }

    public void productOption() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("demo");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
        loginBtn.click();
        Thread.sleep(3000);
        WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
        closeBtn.click();
        WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),\"Catalog\")]"));
        catalogOption.click();
        catalogOption.isDisplayed();
        WebElement productOption = driver.findElement(By.xpath("//a[.=\"Products\"]"));
        Assert.assertTrue(productOption.isDisplayed());
        productOption.click();

    }

    @Test
    public void validateTheBoxes() throws InterruptedException {
        /*
1-Create for loop(starts from i=1) not click first box because it selects everythng
2-Find the all boxes elements and store them in the List
3-Validate all boxes are displayed(1 one 1 in for loop)
4-Click the box and validate the box is selected after that.
 */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("demo");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
        loginBtn.click();
        Thread.sleep(3000);
        WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
        closeBtn.click();
        WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),\"Catalog\")]"));
        catalogOption.click();
        Thread.sleep(3000);
        catalogOption.isDisplayed();
        WebElement productOption = driver.findElement(By.xpath("//a[.=\"Products\"]"));
        productOption.click();

        List<WebElement> allboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]"));

        for (int i = 1; i < allboxes.size(); i++) {
            Assert.assertTrue(allboxes.get(i).isDisplayed());
            allboxes.get(i).sendKeys(Keys.ARROW_DOWN);
            allboxes.get(i).click();
            allboxes.get(i).sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(500);
            Assert.assertTrue(allboxes.get(i).isSelected());
        }

    }

    @Test
    public void validateIsProductAscendingOrder() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
        userName.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
        password.sendKeys("demo");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
        loginBtn.click();
        Thread.sleep(3000);
        WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
        closeBtn.click();
        WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),\"Catalog\")]"));
        catalogOption.click();
        Thread.sleep(3000);
        catalogOption.isDisplayed();
        WebElement productOption = driver.findElement(By.xpath("//a[.=\"Products\"]"));
        productOption.click();
        Thread.sleep(3000);

        List<WebElement> allBrands = driver.findElements(By.xpath("//tr//td[3]"));//indexing-->suggested for tables

        List<String> actualBrands = new ArrayList<>();
        List<String> expectedBrands = new ArrayList<>();

        for (int i = 1; i < allBrands.size(); i++) {
            actualBrands.add(allBrands.get(i).getText().trim());
            expectedBrands.add(allBrands.get(i).getText().trim());
            Collections.sort(expectedBrands);
            Assert.assertEquals(actualBrands, expectedBrands);
        }
        System.out.println(actualBrands);
        System.out.println(expectedBrands);
    }
        @Test
        public void validateIsProductDescendingOrder() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.opencart.com/admin/");

            WebElement userName = driver.findElement(By.xpath("//input[@id=\"input-username\"]"));
            userName.sendKeys("demo");
            WebElement password = driver.findElement(By.xpath("//input[@id=\"input-password\"]"));
            password.sendKeys("demo");

            WebElement loginBtn = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
            loginBtn.click();
            Thread.sleep(3000);
            WebElement closeBtn = driver.findElement(By.xpath("//button[@class=\"btn-close\"]"));
            closeBtn.click();
            WebElement catalogOption = driver.findElement(By.xpath("//a[contains(text(),\"Catalog\")]"));
            catalogOption.click();
            Thread.sleep(3000);
            catalogOption.isDisplayed();
            WebElement productOption = driver.findElement(By.xpath("//a[.=\"Products\"]"));
            productOption.click();
            Thread.sleep(3000);

            WebElement productNameBtn = driver.findElement(By.xpath("//td[@class=\"text-start\"]"));
            productNameBtn.click();
            Thread.sleep(3000);
            List<WebElement> productNames = driver.findElements(By.xpath("//tr/td[3]"));

            List<String> actualBrands1 = new ArrayList<>();
            List<String> expectedBrands1 = new ArrayList<>();
//whenever you need to do comparison for 2 list with String value.it goes to ASCII TABLE.It means.
// i suggest you to use eihter toLoverCase,or to UpperCase at the end of GetText()
            for (int i = 1; i < productNames.size(); i++) {
                Thread.sleep(200);
                actualBrands1.add(productNames.get(i).getText().toUpperCase().trim());
                expectedBrands1.add(productNames.get(i).getText().toUpperCase().trim());
                Collections.sort(expectedBrands1);
                Thread.sleep(2000);
                Collections.reverse(expectedBrands1);
                Assert.assertEquals(actualBrands1, expectedBrands1);
            }
            System.out.println(actualBrands1);
            System.out.println(expectedBrands1);
        }
  /*
HOMEWORK:Validation for the functionality of ProductName Button

1-Click productName button
2-Then validate the all brands are descending order.
TIPS:Think about Collections.sort and Collections.reverse.
TIPS2:Similar logic with ascending order but you need couple more steps to complete this task
   1-Click ProductName
   2-Reverse the list
 */


    }
