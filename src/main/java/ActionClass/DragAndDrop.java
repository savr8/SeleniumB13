package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class DragAndDrop {
    //DRAG and Drop
    @Test
    public void dragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
        WebElement closeCookie = driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]"));
//The reason i create action class to show you that you can use click method from actions as well
        WebElement bluecircle = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.scrollByAmount(1000, 1000);
        actions.click(closeCookie).perform();
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(orangeBox);
        String expectedMessage = "... Or here.";
        actions.scrollByAmount(1000, 1000);
        Assert.assertEquals(actualMessage, expectedMessage);
        actions.dragAndDrop(bluecircle, orangeBox).perform();
        Thread.sleep(3000);
        orangeBox = driver.findElement(By.xpath("//div[@class=\"test2\"]"));
        String actualAfterDrop = BrowserUtils.getText(orangeBox);
        String expectedAfterDrop = "You did great!";
        Assert.assertEquals(actualAfterDrop, expectedAfterDrop);


    }

    @Test
    public void DragAndDropPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement messageBox = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        String acturalMessage = BrowserUtils.getText(messageBox);
        String expectedMessage = "Drop here";
        Assert.assertEquals(acturalMessage, expectedMessage);
        WebElement dragBox = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement dropHereBox = dragBox.findElement(By.xpath("//div[@id=\"simpleDropContainer\"]//div[@id=\"droppable\"]"));
        actions.dragAndDrop(dragBox, dropHereBox).perform();
        Thread.sleep(2000);
        String avtualMessageDroped = BrowserUtils.getText(dropHereBox);
        String expectedMessageDroped = "Dropped!";
        Assert.assertEquals(avtualMessageDroped, expectedMessageDroped);
        String actualColor=dropHereBox.getCssValue("background-color");
        String expectedColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor,expectedColor);


    }

}
