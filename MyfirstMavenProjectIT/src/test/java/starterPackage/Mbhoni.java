package starterPackage;

import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import frameworkclasses.SeleniumFunctions;


public class Mbhoni {
	String pURL = "http://demo.guru99.com/telecom/index.html";
	String sFirstname = "Mb";
	String sLastname = "Van";
	String sEmailInvalid = "ts@gmail";		    					//INVALID EMAIL ADDRESS FOR ASSERTION
	String sEmailValid = "ts@gmail.com";
	String sAddressInvalid = "123 main drive, polokwane";		//INVALID ADDRESS FOR ASSERTION		//ESCAPE THE SPECIAL CHARACTER
	String sAddressValid = "123 main drive polokwne";
	String sContactnumber = "0158124578";
	
	//Instantiate Selenium Functions
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	
	//Assert
	boolean eleDisplayed;
	
	// Data from CSV file
	
//	String sFormatedData = createNewCSVFile();
//	File log = new File("C:\\temp\\"+sFormatedData+".csv");
		
	//Return the date string
//	public String createNewCSVFile() {
		//Set the date string
//		Date date = Calendar.getInstance().getTime();  
//		DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");  
//		String strDate = dateFormat.format(date);  
	//System.out.println("Converted String: " + strDate); 
//		   return strDate;
			
//		}
	
	//NAVIGATE TO URL
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		}
	
	
	//CLICK ON THE Add Customer Button
	public void clickAddCustomer() {
		sfSelenium.clickLink("Add Customer");
	}
		

	
	// Assert after your Clicked Add Customer
//	public void landedInAddCusmtoer() {
//		try {
//			eleDisplayed = driver.findElement(By.cssSelector("body.subpage:nth-child(2) span:nth-child(5) nav.left > a.logo:nth-child(2)")).isDisplayed();
//			System.out.println("Successful Landed In Add Customer: " + eleDisplayed);
//			sfSelenium.createTest("Successful Landed In Add Customer");
//		}
//		catch(NoSuchElementException e) {
//			System.out.println(e);
//		}
//		
//	}
	
	
	// Capture New User Details
	public void CaptureUserDetailsInvalid(String sFirstname, String sLastname,String sEmailValid,
			String sEmailInvalid, String sAddressInvalid, String sContactnumber)throws IOException, InterruptedException {
		
		sfSelenium.createTest("Test 1");

		// Clicking Done in Add Customer page
		driver.findElement(By.xpath("//label[@for='done']")).click();

		// populate input data
		sfSelenium.populateInputField(By.name("fname"), sFirstname);
		sfSelenium.populateInputField(By.name("lname"), sLastname);
		sfSelenium.populateInputField(By.name("emailid"), sEmailInvalid);
		sfSelenium.populateInputField(By.name("addr"),sAddressInvalid);
		sfSelenium.populateInputField(By.name("telephoneno"), sContactnumber);
		
		
		boolean isMessageDisplayed = driver.findElement(By.cssSelector("body.subpage:nth-child(2) span:nth-child(5) nav.left > a.logo:nth-child(2)")).isDisplayed();
		String expectedErrorMessage = "Email-ID is not valid";
		String actualEmailErrorMessage = driver.findElement(By.cssSelector("body.subpage:nth-child(2) span:nth-child(5) nav.left > a.logo:nth-child(2)")).getText();
			
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isMessageDisplayed);
		softAssert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
		softAssert.assertAll(); 		

		Thread.sleep(500);
		
		// Capture a screenshot into the report
		sfSelenium.logScreenShot();
	}
	
	
	// Capture New User Details
	public void CaptureUserDetailsValid(String sFirstname, String sLastname,String sEmailValid,
			String sAddressValid, String sContactnumber)throws IOException, InterruptedException {
		
		sfSelenium.createTest("Test 2");
		
		// Refresh the Page
		driver.navigate().refresh();
		
		// Clicking Done in Add Customer page
		driver.findElement(By.xpath("//label[@for='done']")).click();

		// populate input data
		sfSelenium.populateInputField(By.name("fname"), sFirstname);
		sfSelenium.populateInputField(By.name("lname"), sLastname);
		sfSelenium.populateInputField(By.name("emailid"), sEmailValid);
		sfSelenium.populateInputField(By.name("addr"),sAddressValid);
		sfSelenium.populateInputField(By.name("telephoneno"), sContactnumber);
		
		Thread.sleep(500);
		
		// Clicking Submit
		driver.findElement(By.name("submit")).click();
		
		boolean isMessageDisplayed = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner header.align-center > h1:nth-child(1)")).isDisplayed();
		String expectedErrorMessage = "Access Details to Guru99 Telecom";
		String actualEmailErrorMessage = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner header.align-center > h1:nth-child(1)")).getText();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isMessageDisplayed);
		softAssert.assertEquals(actualEmailErrorMessage, expectedErrorMessage);
		softAssert.assertAll(); 
				
		// Capture a screenshot into the report
		sfSelenium.logScreenShot();
	}
	
	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Telco  Project", "Add New Customer");
		sfSelenium.createTest("Ass1");
	}
	
	// Invalid Address
	@Test
	public void test() throws Exception {
		sfSelenium.startReport("Telco  Project", "Add New Customer");
		sfSelenium.createTest("Ass1");
		this.driver = sfSelenium.getDriver();
		navigateToURL(pURL);
		clickAddCustomer();
		CaptureUserDetailsInValid(sFirstname, sLastname, sEmailInvalid, sAddressInvalid, sContactnumber);		
		CaptureUserDetailsValid(sFirstname, sLastname, sEmailValid, sAddressValid, sContactnumber);
		//clickSubmit();
	
		System.out.println("Test 1" + "Test 2");
	}


	private void CaptureUserDetailsInValid(String sFirstname2, String sLastname2, String sEmailInvalid2,
			String sAddressInvalid2, String sContactnumber2) {
		// TODO Auto-generated method stub
		
	}
	
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}
	

}

