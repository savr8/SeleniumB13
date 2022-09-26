package MentoringWithNuradil;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PianoClass {
    @Test
    public void playPiano() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.musicca.com/piano");

        List<WebElement> keys = driver.findElements(By.xpath("//span[@data-note]"));

        List<String> music = Arrays.asList("2g", "2g", "2g", "2d", "2e", "2e", "2d", "3b", "3b", "3a", "3a", "2g");
        Map<String, WebElement> keyBoard = new HashMap<>();
        //["2g"webelement1,"2d"webelement2,...]
        // nameOfWebelement.getAttribute("nameOfTheAttribute");

        for (WebElement key : keys) {
            //     String dataNoteValue= key.getAttribute("data-note");
            keyBoard.put(key.getAttribute("data-note"), key);
        }

        for (String note : music) {

            WebElement key = keyBoard.get(note);
            key.click();
            Thread.sleep(100);
        }


    }
}
