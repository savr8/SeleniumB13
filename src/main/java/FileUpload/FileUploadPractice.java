package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {
    @Test
    public void practice(){
           /*
1-Navigate to the "https://demo.guru99.com/test/upload/"
2-upload the file
3-Click the box of I accept terms of service
4-Click submit file
5-Validate the message "1 file has been successfully uploaded."
6-Close the webpage
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\12672\\Desktop\\usa.png");
        WebElement uploadBtn=driver.findElement(By.id("file-submit"));
        uploadBtn.click();
        WebElement message=driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(message));
        Assert.assertEquals(BrowserUtils.getText(message),"File Uploaded!");

    }

}
