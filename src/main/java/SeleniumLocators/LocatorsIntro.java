package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/12672/Downloads/Techtorialhtml.html");

        //ID LOCATOR
        WebElement header = driver.findElement(By.id("techtorial1"));//it will find element with specific locator
        String actualHeader = header.getText();//getText method-->gets the text and return String
        String expectedHeader = "Techtorial Academy";
        System.out.println(actualHeader);
        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText());
        //Name Locator
        WebElement firstNameBox = driver.findElement(By.name("firstName"));
        firstNameBox.sendKeys("Savr");//SendKeys method sends the data that you want.
        WebElement lastNameBox=driver.findElement(By.name("lastName"));
        lastNameBox.sendKeys("Muchkaev");
        WebElement phoneBox =driver.findElement(By.name("phone"));
        phoneBox.sendKeys("2672075299");
        WebElement emailBox = driver.findElement(By.name("userName"));
        emailBox.sendKeys("savr8303@gamil.com");
        WebElement addressBox=driver.findElement(By.name("address1"));
        addressBox.sendKeys("441 Tomlinson rd");
        WebElement cityBox = driver.findElement(By.name("city"));
        cityBox.sendKeys("Philadelphia");
        WebElement stateBox =driver.findElement(By.name("state"));
        stateBox.sendKeys("PA");

        //CLASSNAME LOCATOR
        WebElement allTool = driver.findElement(By.className("group_checkbox"));
        System.out.println(allTool.getText());

        //ISDISPLAYED and ISSELECTED METHOD?
        WebElement javaBox =driver.findElement(By.id("cond1"));//i have box now
        System.out.println(javaBox.isDisplayed());//true
        if (javaBox.isDisplayed()){
            javaBox.click();
            System.out.println(javaBox.isSelected());//true
        }else {
            System.out.println("Box is not displayed");
        }

        WebElement testNGBox =driver.findElement(By.id("cond3"));
        System.out.println(testNGBox.isDisplayed());
        if(testNGBox.isDisplayed()){
            testNGBox.click();
            System.out.println(testNGBox.isSelected());
        }else {
            System.out.println("Box is not displayed");
        }
        WebElement cucumberBox=driver.findElement(By.id("cond4"));
        System.out.println(cucumberBox.isDisplayed());
        if(cucumberBox.isDisplayed()){
            cucumberBox.click();
            System.out.println(cucumberBox.isSelected());
        }else {
            System.out.println("Box is not displayed");
        }

    }
    }
