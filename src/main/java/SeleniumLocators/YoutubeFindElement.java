package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class YoutubeFindElement {

    public static void main(String[] args) throws InterruptedException {
        /*
1-Navigate to the website youtube
2-Search for justin bieber
3-Find the all song names and store in the list
4-Use for and if conditions to find the song "Justin Bieber - Love Yourself (Official Music Video)'
5-Click the song
6-Enjoy your music
7-Ready to be level 2

 */
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Justin Bieber");
        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        Thread.sleep(2000);
        searchButton.click();
        Thread.sleep(2000);
        List<WebElement> allsongs = driver.findElements(By.xpath("//a[@id='video-title']"));
for(WebElement song:allsongs){
    if(song.getAttribute("title").equals("Justin Bieber - Love Yourself (Official Music Video)")){
        song.click();
    }
}

    }
}
