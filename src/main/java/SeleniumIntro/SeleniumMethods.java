package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) throws InterruptedException {
        // System.setProperties("webdriver.chrome.driver","cromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //navigate.to -->is used to navigate to website without waiting for all elements from page
        //get -->is used to get to website but it waits for elements to be loaded(little bit slower)
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.youtube.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);//it will wait 3 sec on the page
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        driver.navigate().refresh();
        System.out.println(driver.getPageSource());//this is method that you access the HTML of page



    }
}
