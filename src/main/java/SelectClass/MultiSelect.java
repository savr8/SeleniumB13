package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class MultiSelect {

    @Test
    public void selectMultiMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/12672/Downloads/Techtorialhtml.html");
        WebElement multiSelect = driver.findElement(By.xpath("//select[@class=\"select\"]"));
        BrowserUtils.selectBy(multiSelect,"1","value");
        BrowserUtils.selectBy(multiSelect,"Two","text");
        BrowserUtils.selectBy(multiSelect,"4","index");
        Select multiBox=new Select(multiSelect);
        multiBox.deselectByVisibleText("Two");
        multiBox.deselectAll();

    }
}
