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

import java.lang.annotation.Target;
import java.time.Duration;
import java.util.*;

public class HoverOver {
    //MOVETOELEMENT
    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> userNames = driver.findElements(By.tagName("h5"));
        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        //We should use as list method to make our code more professional and also code.
        //The example of aslist does exactly same thing what the 3 lines of code do below
        //  actualNames.add("name: user1");
        //actualNames.add("name: user2");
        // actualNames.add("name: user3");

        Actions actions = new Actions(driver);
        for (int i = 0; i < userNames.size(); i++) {
            Thread.sleep(5000);
            actions.moveToElement(allImages.get(i)).perform();//gives image one by one
            actualNames.add(BrowserUtils.getText(userNames.get(i)));
            System.out.println(BrowserUtils.getText(userNames.get(i)));
        }
        Assert.assertEquals(actualNames, expectedNames);

    }

    @Test
    public void hoverOverPractice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");
        Actions actions = new Actions(driver);
        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        actions.click(acceptCookies);
        List<WebElement> allImages = driver.findElements(By.xpath("//div[@class='product k-listview-item']"));
        List<WebElement> allNames = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> allPrices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List<String> listOfNames = new ArrayList<>();
        List<Double> listOfPrices = new ArrayList<>();
        Map<String, Double> allNamesAndPrices = new HashMap<>();
        actions.scrollByAmount(200,200);
        for(int i = 0 ;i<allImages.size();i++){
            actions.moveToElement(allImages.get(i)).perform();
            listOfNames.add(BrowserUtils.getText(allNames.get(i)));
            listOfPrices.add(Double.parseDouble(BrowserUtils.getText(allPrices.get(i)).substring(1)));//intentionally fail
            allNamesAndPrices.put(listOfNames.get(i),listOfPrices.get(i));
        }
        Collections.sort(listOfNames);
        Collections.sort(listOfPrices);
        System.out.println(listOfPrices);
        System.out.println(listOfNames);
        System.out.println(allNamesAndPrices);
        }


}
