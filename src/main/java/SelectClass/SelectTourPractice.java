package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.operator.AADProcessor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class SelectTourPractice {

   /*
1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulca"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
9-Print out all the options from Airline
10-Choose the Unified option from airline list
11-Click Continue
12-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Avaialble.
 NOTE2:You can use any select method value,visibleText

 */



        @Test
        public void validateMessage () {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
            WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
            oneWay.click();
            WebElement passenger = driver.findElement(By.name("passCount"));
            Select pssnger = new Select(passenger);
            pssnger.selectByValue("4");
            WebElement fromPort = driver.findElement(By.name("fromPort"));
            Select fromprt = new Select(fromPort);
            String actualOption = fromprt.getFirstSelectedOption().getText().trim();
            String expectedOption = "Acapulco";
            Assert.assertEquals(actualOption, expectedOption);
            fromprt.selectByVisibleText("Paris");
            WebElement fromMonth = driver.findElement(By.name("fromMonth"));
            Select frmMonth = new Select(fromMonth);
            frmMonth.selectByIndex(7);
            WebElement fromDay = driver.findElement(By.name("fromDay"));
            Select frmDay = new Select(fromDay);
            frmDay.selectByVisibleText("15");
            WebElement toPort = driver.findElement(By.name("toPort"));
            Select toPrt = new Select(toPort);
            toPrt.selectByValue("San Francisco");
            WebElement toMonth = driver.findElement(By.name("toMonth"));
            Select toMnth = new Select(toMonth);
            toMnth.selectByIndex(11);
            WebElement toDay = driver.findElement(By.name("toDay"));
            Select toDy = new Select(toDay);
            toDy.selectByValue("15");
            WebElement firstClass = driver.findElement(By.xpath("//input[@value='First']"));
            firstClass.click();
            WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
            Select options = new Select(airlines);
            List<WebElement> allOptions = options.getOptions();
            for (WebElement option : allOptions) {
                System.out.println(option.getText().trim());
            }
            options.selectByVisibleText("Unified Airlines");
            WebElement continueButton = driver.findElement(By.name("findFlights"));
            continueButton.click();
            WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
            String actualMessage = message.getText().trim();
            String expectedMessage = "After flight finder - No Seats Avaialble";
            Assert.assertEquals(actualMessage, expectedMessage);
        }

        @Test
        public void SecondWayOfSelectPractice () {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
            WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
            oneWay.click();
            WebElement passenger = driver.findElement(By.name("passCount"));

            BrowserUtils.selectBy(passenger,"4","value");

            WebElement fromPort = driver.findElement(By.name("fromPort"));
            BrowserUtils.selectBy(fromPort,"Paris","text");

            WebElement fromMonth = driver.findElement(By.name("fromMonth"));
            BrowserUtils.selectBy(fromMonth,"8","value");

            WebElement fromDay = driver.findElement(By.name("fromDay"));
            BrowserUtils.selectBy(fromDay,"15","value");

        }
    }
