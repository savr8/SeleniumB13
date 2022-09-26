package MentoringWithAhmed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeLocators {
    /*
    1-Navigate this website http://www.testdiary.com/training/selenium/selenium-test-page/
    2-Printout selenium test page from website
    3-print out the paragraph from the page
    4-Check the selenium box is displayed or not,if it is displayed and not selected then click
    5-Click java radio button
    6- Click save
     */
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Selenium Test Page')]"));
        System.out.println(header.getText().trim());
        WebElement paragraph = driver.findElement(By.xpath("//strong[contains(text(),'test')]"));
        System.out.println(paragraph.getText().trim());

        WebElement seleniumBox = driver.findElement(By.id("seleniumbox"));
        if (seleniumBox.isDisplayed() && !seleniumBox.isSelected()) {
            seleniumBox.click();
        } else {
            System.out.println("selenium box is already checked");
        }

        WebElement javaRadioBotton = driver.findElement(By.xpath("//input[@id='java1']"));
        javaRadioBotton.click();
        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        saveButton.click();
/*

1-Click the Test Dairy link with linktext
2-print out the header,title and currentUrl of Test Dairy from opening page
3-Navigate back to main page
4-Click Test Diary Selenium learning with PartialLinkText
5-print out the header,title and currentUrl of Test Dairy from opening page
 */
        WebElement dairyLink = driver.findElement(By.linkText("Test Diary"));
        dairyLink.click();
        WebElement header1 = driver.findElement(By.tagName("h1"));
        System.out.println(header1.getText().trim());
        System.out.println(driver.getTitle().trim());
        System.out.println(driver.getCurrentUrl().trim());


        /*

        TASK 3:Contact Form
    1-Fill the all the boxes (yourname,youremail,subject and your message)
    2-Click save button
    3-Validate (IF CONDITION) message "Your message was sent successfully.Thanks."

         */
    }
}