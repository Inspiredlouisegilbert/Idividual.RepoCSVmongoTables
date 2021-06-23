
package TelcoProject;
//package My_Assignments;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import frameworkclasses.SeleniumFunctions;

	public class TelcoAssignment {


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

    
//Populate the billing details
public void populate_biling_data(String sfname,String slname, String semailid,String saddr,String stelephoneno ) {

sfSelenium.populateInputField(By.name("fname"),sfname);
sfSelenium.populateInputField(By.name("lname"),slname);
sfSelenium.populateInputField(By.name("emailid"),semailid);
sfSelenium.populateInputField(By.name("addr"),saddr);
sfSelenium.populateInputField(By.name("telephoneno"),stelephoneno);
}

@Test 
public void Given_Invalid_Data_Entered_Then_warning_message_Displayed() throws InterruptedException {


//String pURL;
driver.get(pURL); 
sfSelenium.maximiseBrowserWindow();

//CLICK ON THE Add Customer
//public void clickAddCustomer() {         
//driver.findElement(By.class("logo")) >Guru99 telecom</a>);
//span[@id='header']//a[@href='index.html']
// Add customer xpath from guru.com 
//section[@id='main']/div[@class='inner']//h1[.='Add Customer']
//String actualString = driver.findElement(By.xpath("section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
//  assertTrue(actualString.contains("Add Customer"));  
//}


// Click on Add Customer
driver.findElement(By.linkText("Add Customer")).click();

Thread.sleep(1000);
//String actualString = driver.findElement(By.cssSelector("h1")).getText();

   // assertTrue(actualString.contains("Add Customer"));
   //Assert.assertEquals(actualString, "Add Customer");
    
   // Customer
	String actualString = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
   // assertTrue(actualString.contains("Add Customer"));
	Assert.assertEquals(actualString, "Add Customer");
	Reporter.log("The actual result is "+actualString);

	Reporter.log("The expected result is "+"Add Customer");

	//Select On Done radio button
	driver.findElement(By.cssSelector("[for='done']")).click();

	
	//Populate the billing details with the INVALID Data
	String sfname= "Nyeleti";
	String slname = "Chauke";
	String semailid = "123@gmail.com";
	String saddr= "!#@### Smit steet";
	String stelephoneno= "0242353454";
	//call a method to populate the fields
	populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
	//wait
	Thread.sleep(5000);
   
    // verify if the validation message displays below the field  // 
	String actualString1 = driver.findElement(By.xpath("//label[.='Special characters are not allowed']")).getText();
    // assertTrue(actualString.contains("Add Customer"));
	Assert.assertEquals(actualString1, "Special characters are not allowed");
	Reporter.log("The actual result is "+actualString1);

	Reporter.log("The expected result is "+"Special characters are not allowed");
  
}
  //==========================
@Test
  	public void Given_Invalid_Data_When_submit_Button_IsPresedOn_Then_Alert() throws InterruptedException {
  
	//click on Submit
     driver.findElement(By.name("submit")).click();
      
       //HANDLE UNSUCCESSFUL POPUP ALERT
      sfSelenium.createTest("Run Alert Failure: Unsuccessful login popup text test");
      String pExpectedMessage = "please fill all fields";
      Alert alert = this.driver.switchTo().alert();
      String sAlertMessage = alert.getText();
      Assert.assertEquals(sAlertMessage, "please fill all fields");
      Reporter.log("The actual result is "+sAlertMessage);

      Reporter.log("The expected result is "+"please fill all fields");
      
      //CREATE AN OBJECT OF THE POPUP

      //Alert alert = this.driver.switchTo().alert();
      //String sAlertMessage = alert.getText();
      System.out.println(sAlertMessage);

      //Click on OK button
      alert.accept();
      
      sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
      //eleDisplayed = driver.findElement(By.????"")).isDisplayed();
      Thread.sleep(5000);
  
  }

    // Second attempt 
	//Click reset button to clear screen
    
    @Test 
    public void Capture_correct_data() throws InterruptedException    {
    
    //Populate the billing details
    //Set valid data
    String sfname= "Nyeleti";
    String slname = "Chauke";
    String semailid = "baloyibene@gmail.com";
    String saddr= "Star Street";
    String stelephoneno= "0242353454";
    
    //Click on Reset button to Clear the fields
    driver.findElement(By.cssSelector("input[value='Reset']")).click();
    //wait for 5 seconds
    Thread.sleep(10000);
    
    //Then on Click on the Done radio buttons
    driver.findElement(By.cssSelector("[for='done']")).click();
    
    //call a method to populate the fields
    populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
    Thread.sleep(5000);
    
    //click on Submit button
    driver.findElement(By.name("submit")).click();
    
    
    // verify that the Customer ID message is displayed below the field  // 
    String actualString2 = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Access Details to Guru99 Telecom']")).getText();
    //assertTrue(expectedString.contains("Customer ID"));
    Assert.assertEquals(actualString2, "Access Details to Guru99 Telecom");
    Reporter.log("The actual result is "+actualString2);

    Reporter.log("The expected result is "+"Access Details to Guru99 Telecom");
        
    // Asset for the Customer ID that keeps on Changing
      boolean actualString3 = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).isDisplayed();
      String actualSlength = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).getText();
      System.out.println(actualSlength);
      Assert.assertTrue(actualSlength.length() > 0);
      Assert.assertEquals(actualString3, true);
      
      //Reporter.log("The actual result is "+actualString1);
      //Reporter.log("The expected result is "+"Special characters are not allowed"); 
                
      
    }

@AfterTest
public void afterTest() throws Exception {
sfSelenium.CloseSelenium();
}

}
