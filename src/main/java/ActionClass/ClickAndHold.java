package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

@Test
public class ClickAndHold {
    public void clickAndHold() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        Thread.sleep(2000);
        WebElement closeCookie = driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]"));
//The reason i create action class to show you that you can use click method from actions as well

        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.click(closeCookie).perform();
        actions.scrollByAmount(500, 500);
        WebElement circle = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        actions.clickAndHold(circle).moveToElement(blueBox).release().perform();
        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage, expectedMessage);
        actions.scrollByAmount(500, 500);
        actions.clickAndHold(circle).moveToElement(blueBox).release();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMeassageAfter = BrowserUtils.getText(blueBox);
        String expectedMessageAfter = "You did great!";
        Assert.assertEquals(actualMeassageAfter, expectedMessageAfter);

        String actualColor = blueBox.getCssValue("");
        String expectedColor = "";
        Assert.assertEquals(actualColor, expectedColor);
    }

    @Test
    public void clickAndHoldPractice() throws InterruptedException {

        /*
 1-Navigate to the website "https://demoqa.com/droppable"
 2-Click Accept
 3-Click and hold notAccepted box and release to the Drop box
 4-Validate message is still "Drop here"
 5-Click and hold acceptable box and release to Drop box
 6-Validate the message is "dropped"
 */
        // 1-Navigate to the website "https://demoqa.com/droppable"
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(2000);
        // 2-Click Accept
        Actions actions = new Actions(driver);
        WebElement acceptBox = driver.findElement(By.xpath("//a[contains(text(),'Accept')]"));//By.linkText"Accept"
        acceptBox.click();
        Thread.sleep(2000);
        //3-Click and hold notAccepted box and release to the Drop box
        WebElement notAcceptBox = driver.findElement(By.xpath("//div[@id=\"notAcceptable\"]"));
        WebElement dropHereBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        actions.clickAndHold(notAcceptBox).moveToElement(dropHereBox).release().perform();
        Thread.sleep(2000);
        // 4-Validate message is still "Drop here"
        dropHereBox = driver.findElement(By.xpath("//div[@id='acceptDropContainer']//div[@id='droppable']"));
        String actualMessageBefore = BrowserUtils.getText(dropHereBox);
        String expectedMessageBefore = "Drop here";
        Assert.assertEquals(actualMessageBefore, expectedMessageBefore);
        // 5-Click and hold acceptable box and release to Drop box
        WebElement acceptableBox = driver.findElement(By.xpath("//div[@id=\"acceptable\"]"));
        actions.clickAndHold(acceptableBox).moveToElement(dropHereBox).release().perform();
        // 6-Validate the message is "dropped"
        WebElement dropBoxAfterDrop = driver.findElement(By.xpath("//div[@id=\"droppable\"]//p[contains(text(),'Dropped!')]"));
        String actualMessageAfter = BrowserUtils.getText(dropBoxAfterDrop);
        String expectedMessageAfter = "Dropped!";
        Assert.assertEquals(actualMessageAfter, expectedMessageAfter);

    }

}
