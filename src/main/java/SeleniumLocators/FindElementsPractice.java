package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.util.List;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
        /*
        Task1:
       1-navigate to the internet-herokuapp
       2-print out all the links
         */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com");

        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));
        for (WebElement link : allLinks) {
            System.out.println(link.getText().trim());

        }
        /*
        Task2:
        3-i want to print out only the once size less than 12
        4-print out how many of them are less than 12
         */
        int counter = 0;
        for (WebElement link : allLinks) {
            if (link.getText().length() < 12) {
                System.out.println(link.getText().trim());
                counter++;
            }
        }
        System.out.println(counter);
/*
TASK 3:Contact Form
1-Fill the all the boxes (yourname,youremail,subject and your message)
2-Click save button
3-Validate (IF CONDITION) message "Your message was sent successfully.Thanks."

 */

        WebElement basicAuth = driver.findElement(By.linkText("//a[contains(text(),'Basic Auth')]"));
        Thread.sleep(2000);
        basicAuth.click();


    }
}