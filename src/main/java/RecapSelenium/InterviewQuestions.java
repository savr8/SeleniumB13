package RecapSelenium;

public class InterviewQuestions {

    /*

      1-What are the advantages and disadvantages of Selenium?

    Advantages: -Free Source
                -It supports multiple language(Java,Python,c++,C#)
                -Big Community
                -It supports multiple browser(Chrome,Safari,FireFox...)

    Disadvantages: -You cannot automate (CAPTCHA,PICTURES,MOBILE APPLICATIONS...)
                   -There is no direct call for the error report(support center/customer call)
                   -It only automates Web applications.
                   -It doesn't have any system to generate report, so we integrate reports
                    TESTNG report,Cucumber Report

    2-What type of testing can you automate with Selenium?

     -Smoke Testing        - Regression Testing      -Functional Testing(positive/negative)

    3-What are the test types you can not automate with Selenium?

     -Performance Testing
     -Manual Testing(captcha,pictures,Adhoc testing)
     -Non-functional testing(performance,stress testing,load testing)

    4-What is locator and what are the locator types ? ************

     -->Locator is a way to find the elements from DOM(development tool/page)

      -->ID                  --> ClassName             -->Name                -->TagName
      -->LinkText            -->PartialLinkText        -->CSS                 -->XPATH

    5-How do you handle the Dynamic Elements(CVS) *******

     In my project,I faced many dynamic elements and I used different ways to handle with:

     -->I use parent-child relationship to locate the element.
     -->I used different attributes which are not dynamic.(changes)
    *SHOW OFF--> I use special xpath types -->
                -->Following-siblings
                -->preceding-siblings
                -->contains
                --> .=
                --> and condition

     6-What is the difference between driver.get() and driver.navigate.to() **

      NavigateTo() --> it doesn't wait webelements(page) to be loaded totally.
                   -->have some methods --> refresh,back,forward,to

      Get()        -->it will wait all the webelements(page) to be loaded.
                   -->doesn't have methods.

     7-What is the difference between driver.close() and driver.quit() *****

       Close() --> it specifically closes the window that your driver is currently working on.

       quit() -->it closes all the opened pages from automation.(SUGGESTED)

     8-What is XPATH? and can you tell me about types of Xpath ? Which one do you use in your project mostly?***

      XPATH:-->Xpath is used to find the location of the elements on a webpage by using HTML structure
            -->Xpath is one of the ways to locate the webelement.

       -->There two types of XPATH

          -->Absolute XPATH -->it goes from all the way parent to child step by step(html/body/div/h1/button)
                            -->It starts with single slash(/)

         *--->Relative XPATH --> It directly focuses on the child(location of the element)(button) or parent-child(h1/button)

      -->In my project, I use mostly relative xpath because it directly focuses on the child which i need to locate
                       -->It saves a lot of time to not check all the parents of the child
                       --->Element is in Relative Xpath way shorter than Absolute Xpath

      9-What is the difference between Relative and Absolute Xpath?

      Absolute XPATH:
       -->It goes from parent to child
       -->It has single slash(/) for the path
       -->Syntax is different

      Relative XPATH:
      -->It goes from parent to child or to the child directly
      -->it has double slash(//) for the path
      -->Syntax is different

     10-How do you handle(static) drop down menu/drop-downs?

      In my project, I was handling static drop-down with different ways:

      *I would definitely check the tag of the location

       *If the tag name is "SELECT" -->I use Select class (Select select =new Select(Location Of the WebElement)
       *IF the tag name is "NOT SELECT"-->I use locators to locate my elements and "SENDKEYS"
       *I can also use ACTION CLASS to click or Hover Over the element (Actions actions=new Actions(driver) -->
         -->actions.moveToElement(WebElement).PERFORM

     11-Can you tell me some methods that you use for Select Class ? *

      In my project, I use select class to handle drop-downs.
      -->Select class is really useful to locate and find the element and to be able to use Select Class
      -->This element MUST HAVE SELECT TAG  NAME.

       -->SelectByVisibleText()
       -->SelectByIndex()
       -->SelectByValue()

     12-What kind of Exception did you face in selenium during automation? ****

      -->NoSuchElementException
      -->StaleElementReference
      -->NullPointerException(driver,pages)
      -->ElementIsNotInterceptedException -->element might not be visible on the page(scrooldown)
      -->ElementIsNotIntractable -->element might not be visible on the page(scrooldown)
      -->TimeOutException -->Explicit and Fluent wait
      -->NoSuchFrameException
      -->NoSuchWindowException
      -->UnHandledAlertException

 13-In what condition do you get StateElement Reference Exception? How do you handle it?****
  -->There are couple reasons of getting this exception:
     **-->The element is not on DOM(development structural/tool)
     *-->The element is not updated YET.(Thred.Sleep)
     -->The element needs to be refreshed.

  -->How do you handle it?
     -->First of all,As an tester one of the top exception i face and struggle to handle is StateElementReference.
     With my research i found these three ways that are really effective.
     *****I reinitialize the WebElement-->reassign the webelement
     exp.WebElement element=driver.findElement(By.id("Savr");
     element.click;//state element reference exception
     element=driver.findElement(By.id("Savr");
     element.click;

     **-->Thread.sleep because some elements take little time to updated,so we can wait with Tread.sleep
     *-->driver.navigate.refresh();

14-How do you handle alert?

     There rea different types of alert I faced in my framework?Can you tell me which one you are asking specifically?
     do you want me to talk all of them?

     -->Os alert/pop-ups -->Operation System alert which we cannot handle with Selenium.As much as I know there is
     a Robot class which handles it ,but tbh(to be honest)I never used before
     -->HTML alert/pop-ups -->As you know sir with Slenium you can go find the elemnt then take any actions
     you want.Like click OK,Cancel,X button..etc
     -->JAVASCRIPT pop-ups-->Alert interface-->Mostly I face with Alert pop-ups  which comes from JAVASCRIPT
     To be able to handle these pop-ups .I create an Object using Alert interface and call the methods:

        Alert alert=driver.switchTo().alert()

     -->alert.accept-->It clicks"OK"button
     -->alert.dismiss-->it click"CANCEL"button
     -->alert.sendKeys()-->it sends the key (text...)to the JS pop-up
     -->alert.getText()-->it gets the Text

 15-What do you know about Iframe?Can you tell me the type that you used before and how do you handle Iframe in Selenuim?

    ** Iframe is a way to protect the data like advertisement,videos,documents...etc.
    *** We cannot derectly access the inside of iframe because "Iframe is HTML inside of HTML"
    -->To be able to understand the data is under the Iframe:
    *I automate my element and getting NoSuchElement exception(If you believe everything is good with this element like xpath)
    *I go to website and search for //frame or //iframe
    *Then i look up my element wehter it is  under ths iframe or not

     Thre are different types of Iframe that I can handle

     -->Yuo have to swich your iframe to beable access the data:

     driver.swichTo().frame(Name or ID)-->MOST COMMON(%99)
     driver.swichTo().frame(WebElement)-->driver.findElement(By.path(//frame[@id='frame-1'])
     driver.swichTo().frame(index)-->not suggested since index numbers are changing a lot

     -->SHOW OFF:

     -->If you want i can give you more details about other methods for Iframes LIKE:

     -->driver .SwichTo.ParentFrame()--Which goes to the parent of the frame
     -->DRIVER.SWICHTO>DEFAULTCONTEN()-->which goes directly to MAIN HTML(all the way to the top(main))
                                      -->which goes directly to the out af all frames(until main html)

  16-What do you know about Actions Class?

     --> Actions Class is really useful for my framework since with actions class i use Keyboard and mouse actions

        -->Actions actions=new Actions(drive);

     -->actions.

          -->MoveByOffSet(x,y)-->it is going to find the element based on x and y locatoins
          -->DoubleClick-->it double-click the element
          -->SendKeys()--It sends the Keys to the element,Keys.ENTER***
          -->ConTextClick()-->it right click the element
          --ClickAndHold()-->it click and holds the element
          -->release()-->it releases the element is already clicked and hold
          -->DragAndDrop()-->it drags and drops the element
  **      -->MoveToElement()-->It hovers Over the element
          -->Click()-->it clicks the element
          -->ScrollByAmount(x,y)-->it scrolls the page based on the x and y
*****     -->Perform()-->it performs the actions methods.(WITHOUT THIS IT WILL NOT WORK)

        KEYBOARD ACTIONS:

        -->Keys.ENTER/RETURN -->it enters after sending the keys
        -->Keys.Arrow-up/down/right/left-->it goes different directions on the page.(Sliders and scrollPage)

 17-What is the differnce between FinElemet and FindElements>?***

        Find Element:                                                         Find Elements:
 *driver.findElement(By)             -->syntax is different               <--driver.findElements(By)
 *returns the single WebElement      <--Return type is different          <--*returns the list Of WebElement
 *it throwsNoSuchElemnet exception <--Exception Type                      <--*It throws the emty list.No exception

 18-Can you tell me some driver and WebElement Element methods ?
 -->Driver Methods:                                                         -->WebElement Methods:
 *get()-->goes to the website                                    *sendkeys()->it send the keys
 *navigate().to()-->goes to hte website no wiating               *click()->it clicks the element
 *getTitle()-->gets the title                                    *getText()->gets the text
 *findElement/s()->find the elements from webpage                *clear()->clear the box
 *getCurrentUrl()-->gets the url of the page                     *isDisplayed()-checks the element is visible
 *getPageSource()->gets the source of thepage(HTML)              *isSelected()->chacks the box/radio button is selected
 *manage().vindow().miximize()->it miximize your web page        *submit()->clicks the submit button
 *manage().wiat().implicitlyWays()->creates wait times           *getCSSValue()->it gets the CSS value of the element(color)
 *getWindowHandle/s-->getsthe id of the webpage
 *switchTo().window-->swiches the window
 *swichTo().alert()->swiches the alert
 *swichTTo().frame()->swiches the frames
 *quit()-->it closes the "ALL PAGES"
 *close()-->it closes the current page

 19-What is the difference between check-box and radio-button?

  CheckBox=>You can click multiple boxes

  RadioButton=>You can choose only one

  20-Difference between isDisplayed ,isSelected and isEnabled?

  -->All of the return boolean condition:

  *IsDisplayed:it displayed the element is visible or not

  *isSelected:it checks the element is selected or not(check-mark inside of the box)

  *isEnabled: it checks the element is enabled or not(some elements are faded(it means it not clickable))

 21-How do you switch multiple windows?

 -->i can use driver.windowHandle/s method to switch my windows.
 -->i have Util package which has methods fir this.
 -->driver.switchTo().window(driver.getWindowHandle)
 -->BrowserUtils.switchByTitle()
 -->BrowserUtils.switchById()

 22-How do you scroll down to the page from Web Browser?

 -->First i definitely use JS scrollIntoView script
 -->Actions Class(ScrollByAmount(x,y))
 -->SHOW OFF :POINT CLASS-->getX,getY-->x and y location

      Point point =WebElement.getLocation()
      int x=point.getX();
      int y=point.grtY();
      js.executeScript("window.scrollTo("+xCord+","+yCord+")");

23-How do you upload file in Selenuim?

 -->find the element that triggers upload window(Choose button)
 -->Find the path of the file you want to upload(C://techtorial//picture//flag.png)
 -->driver.findElement(ChooseButton).sendKeys(location of file)).

24-What is the difference between Assert and SoftAssert?

 -->To be honest they have similar logic in terms of validations,but there is couple difference
 as much as i know.
 Assert:is the class that have some methods to validate the acctual and expected data
 with the methods like assert.assertequals,assertTrue,assertFalse,assertFail()
 *It will throws an exception and stop execution no matter what when it fails.

 SoftAssert():is a class that have some methods to validate actual and expected data
 with methods like softassert.assertEquals,assertTrue,assertFalse,assertFail()
 *When softassert fails ,it will not throws an exception and stop the execution
 *You need to create an object to be able to use softAssert methods.
 *To be able to activate softassert -->at the end you need to put.ASSERTALL method

  SoftAssert softAssert=new SoftAssert();

 25-Can you tell me about Singleton?or can you make your constructor private?SOW OFF***

 First of all i appreciate for this question sincei love the singleton a lot.In the past one of the failure
 i was struggling to solve in NULLPOINTER EXEPTION,but with the help of Singleton Pettern Design(SPD)I made my
 driver more useful,protected and safe which is centralized into the framework.
 -->Encapsulation
    *private WebDriver-->protected data
    *private Constructor -->protected data
    *publick method getDriver()-->have access the data

 26-Can you tell me about TestNg Annotation?What do you know about @Parameters and DataProvider?

 -->@Test
 -->@BeforeMethod   -->@BeforeClass  -->@BeforeTest -->@BeforeSuite -->@Parameters
 -->@AfterMethod    -->AfterClass    -->@AfterTest  -->@AfterSuite  -->@Parameters

 @Parameters:is a way to parameterize the data inTestNG

 -->I use <parameter keyword inside of xml file.
 -->I need to provide parameters from xml which is written from class

* @DataProvider:is a way to execute same test with different set of data
*-->I use @DataProvider annotation to link test cases and method

 @DataProvider(name="test")
 public Object[][] data(){
 return new Ogject[][]{
 {"ahmet","mehmet","uasy","fatma"},
 {"Kutman","MhhBack","Amina","Ali"}

 @Test(dataProvider="tets")

 it will run 2 times with same test case.if you are storing your data provider in different class.
 Then you need to do one more implementation
 @Test (dataprovider="test","dataproviderclass="nameoftheClass".class)

 *-->It returns Object[][] multidimensional array.

27-What do you know about wait times?Can you tell me the difference Implicit and Explicit waits?

    tbh,i this is one of my favorite concept since it handles a lot of wait times issues.To be able to do that

-->Implicit wait=>is one of the wait times that handles wait issue for specific elements to locate
     *when the element is not found in certain amount of time,then it throws nosuchELEMENT EXCEPTION
     *driver.manage.timeouts.implicit(Duration.ofSecond(10))

-->Explicit wait:is one of wait time that handles wwait issue for specific element to locate with
"SPECIFIC CONDITION".-->visibleOf,clickable..etc
     *WebDriverWait wait = new WebDriverWait(Duration.ofSecond(10)
     wait.until(ExceptedCondition.visibleOf(WebElement)***
     *When it doesn't find the element,it thorws TimeoutException

-->Fluent wait:is one of wait times that handles wait issue for specific element to locate with
     checking the element "CONSTANTLY/Frequently/periodically"

    NOTE:Please check the fluent wait class if you would like to see implementation

28--What is difference between Verification and Validation?**

-->Verification:is a way to verify data.It doesn't  need execution of code or Assertion.We just read and verify the codes

Exp:i completed my homework and sending to Savr.Savr is reading my implementation and verifying that my code is good

-->Validation:It is a way to validate data."IT REQUIRES EXECUTION AND ASSERTION OF THE CODE".
Exp:I start doing my homework and i do all of the execution and assertion to "VALIDATE"my code is good.

-->









     */
}
