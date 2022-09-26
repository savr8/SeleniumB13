package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionMethods {
     //ContextClick(It means rigthClick)
    @Test
    public void ContextClick() {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement context = driver.findElement(By.linkText("Context Menu"));
        context.click();
        WebElement box = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();//perform must be there
    }
        @Test
        public void contextClickPractice(){

            WebDriverManager.chromedriver();
            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

            WebElement box = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));

            Actions actions = new Actions(driver);
            actions.contextClick(box).perform();
        }

        //DOUBLE CLICK()-->it will double click
        @Test
    public void doubleClick(){

            WebDriverManager.chromedriver();
            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

            WebElement doubleClick = driver.findElement(By.xpath("//button[.='Double-Click Me To See Alert']"));

            Actions actions = new Actions(driver);
            actions.doubleClick(doubleClick).perform();
        }

        @Test
    public void doubleClickPractice(){
            WebDriverManager.chromedriver();
            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://selenium08.blogspot.com/2019/11/double-click.html");

            WebElement doubleClick = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction()\"]"));

            Actions actions = new Actions(driver);
            actions.doubleClick(doubleClick).perform();
        }

    }


