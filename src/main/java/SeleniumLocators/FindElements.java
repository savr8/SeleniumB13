package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements {
    //FindElements method

    //file:///C:/Users/12672/Downloads/Techtorialhtml.html
    public static void main(String[] args) {
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///C:/Users/12672/Downloads/Techtorialhtml.html");

        ////input[@id='cond1']    //input[@type='checkbox']

       List<WebElement> allboxes= driver.findElements(By.xpath("//input[@type='checkbox']"));

       for(WebElement box:allboxes){
           if(box.isDisplayed() && !box.isSelected())
           box.click();

       }


    }
}
