package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuit Annotation");
        //You can use to set up your Chrome browser properties
        //You can delete your cookies
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest Annotation");
        //You can use to launch your browser
        //WebDriver driver=DriverHelper.getDriver()
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass Annotation");
        //You can navigate to the website
    }
    @BeforeMethod//2
    public void beforeMethod() {
        System.out.println("BeforeMethod Annotation");
      //driver initialization. WebDriver driver =DriverHelper.getDriver()
      //driver.get(url)
      //You can use to login the website
    }

    @Test
    public void test() {//1
        System.out.println("Test Annotation");

    }

    @Test
    public void test2() {//1
        System.out.println("Test2 Annotation");

    }
    @AfterMethod//2
    public void afterMethod(){
        System.out.println("AfterMethod Annotation");
        //You can teardown that
        //You can take screenshot for failed test annotation
    }
@AfterClass
    public void afterClass(){
    System.out.println("AfterClass Annotation");
}
@AfterTest
    public void afterTest(){
    System.out.println("AfterTest Annotation");
}
@AfterSuite
    public void afterSuite(){
    System.out.println("AfterSuite Annotation");
}
}
