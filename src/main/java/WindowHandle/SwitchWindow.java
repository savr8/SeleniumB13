package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SwitchWindow {
    @Test//logic
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickBtn.click();
        WebElement headeText = driver.findElement(By.tagName("h3"));
        System.out.println( headeText.getText().trim());
        String mainPageId=driver.getWindowHandle();//CC
        System.out.println(mainPageId);
        Set<String> allPageIds=driver.getWindowHandles();//unique ids thats why we use SET
        System.out.println(allPageIds);//CC,F0
        for(String id:allPageIds){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
            }
        }
        headeText = driver.findElement(By.tagName("h3"));
        System.out.println(headeText.getText().trim());
    }
}
