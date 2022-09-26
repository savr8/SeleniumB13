package MentoringWithAhmed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class PracticeSelectAndLocators {
    /*
    Open this link - https://www.techlistic.com/p/selenium-practice-form.html
Enter first and last name (textbox).
Select gender (radio button).
Select years of experience (radio button).
Enter date.
Select Profession (Checkbox).
Select Automation tools you are familiar with (multiple checkboxes).
Select Continent (Select box).
Select multiple commands from a multi select box
Click on Submit button.
Try your own logic and automate it without any help. If you still find it difficult to automate then follow reference links.

     */
    @Test
    public void practice() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement nameBox = driver.findElement(By.xpath("//input[@name=\"firstname\"]"));
        nameBox.sendKeys("Savr");
        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        lastNameBox.sendKeys("Muchkaev");
        WebElement gender = driver.findElement(By.xpath("//input[@id=\"sex-0\"]"));
        gender.click();

        WebElement yearsExperience = driver.findElement(By.xpath("//input[@id=\"exp-4\"]"));
        yearsExperience.click();
        WebElement date = driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
        date.sendKeys("2022-11-14");
        WebElement proffesion = driver.findElement(By.xpath("//input[@id=\"exp-4\"]"));
        proffesion.click();
        WebElement tool = driver.findElement(By.xpath("//input[@id=\"tool-2\"]"));
        tool.click();
        WebElement continent= driver.findElement(By.xpath("//select[@class=\"input-xlarge\"]"));
        BrowserUtils.selectBy(continent,"5","index");
        WebElement seleniumCom= driver.findElement(By.xpath("//select[@class=\"input-xlarge\"]"));
        BrowserUtils.selectBy(seleniumCom,"1","index");
        BrowserUtils.selectBy(seleniumCom,"2","index");
        WebElement submitBtn=driver.findElement(By.xpath("//button[@class=\"btn btn-info\"]"));
        submitBtn.click();



    }

}
