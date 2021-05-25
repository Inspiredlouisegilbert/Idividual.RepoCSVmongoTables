package My_Assignments;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import frameworkclasses.SeleniumFunctions;

public class Nyeleti_Assign1 {
	

	
	Assertion hardAssert = new Assertion();
	Assertion softAssert = new SoftAssert();
	
	// Run Test Section
	
	//Instantiate Selenium Functions
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	String pURL = "http://demo.guru99.com/telecom/index.html";
	 
	
	// driver variable
	WebDriver driver;
	//Temp
	boolean eleDisplayed;
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}

	
	@Test

	
	public void testFirst() throws Exception {
		System.out.println("Test");
	}
	
	 
    //NAVIGATE TO URL

   // public void navigateToURL(String pURL) {

    // driver.get(pURL);

      //sfSelenium.maximiseBrowserWindow();



      //CLICK ON THE Add Customer

    //  public void clickAddCustomer() {

    //  sfSelenium.clickLink("Add Customer");
               
     // driver.findElement(By.class("logo")) >Guru99 telecom</a>);
    //span[@id='header']//a[@href='index.html']
      
     // Add customer xpath from guru.com
    //section[@id='main']/div[@class='inner']//h1[.='Add Customer']
      
      //String actualString = driver.findElement(By.xpath("section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
    //  assertTrue(actualString.contains("Add Customer"));
      
    //  }
    

    //POPULATE INPUT FIELDS
@Test 
public void populateInput() throws InterruptedException {

   

    //sfSelenium.findElement(By.css("//label[@for=" + 'done' +  "]")).click();

	//String pURL;
	driver.get(pURL);	
	
	// Click on Add Customer
	driver.findElement(By.linkText("Add Customer")).click();
	 
	 
	//String actualString = driver.findElement(By.xpath("section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
    //assertTrue(actualString.contains("Add Customer"));
      
	
	//select done radio button
	driver.findElement(By.cssSelector("[for='done']")).click();
	
	Thread.sleep(5000);
	
	//Populate the billing details
	driver.findElement(By.name("fname")).sendKeys("Nyeleti");
    driver.findElement(By.name("lname")).sendKeys("Baloyi");
    driver.findElement(By.name("emailid")).sendKeys("baloyibene@gmail.com");
    driver.findElement(By.name("addr")).sendKeys("eqeqwe12424324324^%%");
    driver.findElement(By.name("telephoneno")).sendKeys("5021yutyt4");
    
    //click on submit
    driver.findElement(By.name("submit")).click();
    
	Thread.sleep(5000);
	
	
  //HANDLE UNSUCCESSFUL POPUP ALERT
	sfSelenium.createTest("Run Alert Failure: Unsuccessful login popup text test");
	String pExpectedMessage = "please fill all fields";
	
	//CREATE AN OBJECT OF THE POPUP

	Alert alert = this.driver.switchTo().alert();
	String sAlertMessage = alert.getText();
	System.out.println(sAlertMessage);

	//Click on OK button
	alert.accept();
	sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
	//eleDisplayed = driver.findElement(By.????"")).isDisplayed();
	
	Thread.sleep(5000);
	//wait(5000);
	
	// Second attempt
	
	
	  //String actualString = driver.findElement(By.xpath("section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
     //assertTrue(actualString.contains("Add Customer"));
     
	//Click reset button to clear screen
	driver.findElement(By.cssSelector("input[value='Reset']")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.cssSelector("[for='done']")).click();
	driver.findElement(By.name("fname")).sendKeys("Nyeleti");
   driver.findElement(By.name("lname")).sendKeys("Baloyi");
   driver.findElement(By.name("emailid")).sendKeys("baloyibene@gmail.com");
   driver.findElement(By.name("addr")).sendKeys("Star Street");
   driver.findElement(By.name("telephoneno")).sendKeys("5021321414");
 
   //click on submit
   driver.findElement(By.name("submit")).click();
   
   
	  String expectedString = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div[@class='table-wrapper']/table//b[.='Customer ID']")).getText();
     assertTrue(expectedString.contains("Customer ID"));
     
   //section[@id='main']/div[@class='inner']'/div[@class='table-wrapper']/table//b[.='Customer ID']
     
	
	String CustomerID ="";

}
	
		
	
	//@AfterTest
	//public void afterTest() throws Exception {
		//sfSelenium.CloseSelenium();
	//}
	
	}

