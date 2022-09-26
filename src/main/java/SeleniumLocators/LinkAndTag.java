package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkAndTag {
    public static void main(String[] args) throws InterruptedException {
        //TagName
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/12672/Downloads/Techtorialhtml.html");
        WebElement javaVersion = driver.findElement(By.tagName("u"));
        System.out.println(javaVersion.getText());

        //LinkText-->it will look for a tag and click on it
       WebElement javaLink= driver.findElement(By.linkText("Java"));
       javaLink.click();
       WebElement header=driver.findElement(By.tagName("h1"));
        System.out.println(header.getText());

        /*
        TASK:
        STORY:CAN you verify all the links are working on the techtorial page
        1-first of all ,you need to go back to main page
        2- you need to click selenium link and get the title
        3- Go back to main page and click Cucumber and sout header of the page
        4- go back to main page and refresh the page
        5- close the page
        */

        driver.navigate().back();
        WebElement selenium =driver.findElement(By.linkText("Selenium"));
        selenium.click();
        driver.navigate().back();
        Thread.sleep(3000);
        javaLink= driver.findElement(By.linkText("Java"));
        javaLink.click();



        System.out.println(driver.getTitle());//you can also tagName for the title
        Thread.sleep(3000);
       driver.navigate().back();//Main
        WebElement cucumber = driver.findElement(By.linkText("Cucumber"));
        cucumber.click();
        Thread.sleep(3000);
        WebElement headerCucumber=driver.findElement(By.tagName("h1"));
        System.out.println(headerCucumber.getText());
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        //driver.close();

        //PartialLinkText
        WebElement restApi = driver.findElement(By.partialLinkText("Api"));
        restApi.click();



    }
}
