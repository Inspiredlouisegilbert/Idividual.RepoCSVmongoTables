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

import frameworkclasses.SeleniumFunctions;


public class Mbhoni {
	String pURL = "http://demo.guru99.com/telecom/index.html";
	
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
			sfSelenium.maximiseBrowserWindow();
		}
	
	
	public void landedInTelecom() {
		//ASSERT Before you Click Add Customer
		try {
			eleDisplayed = driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.left:nth-child(1) div:nth-child(1) h3:nth-child(1) > a:nth-child(1)")).isDisplayed();
			System.out.println("Successful Landed In Telecom: " + eleDisplayed);
			sfSelenium.createTest("Successful Landed In Telecom");
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
	}
	
	//CLICK ON THE BANKING LINK
	public void clickBankProject() {
		sfSelenium.clickLink("Add customer");
	}

	
	// Assert after your Clicked Add Customer
	public void landedInAddCusmtoer() {
		try {
			eleDisplayed = driver.findElement(By.cssSelector("body.subpage:nth-child(2) span:nth-child(5) nav.left > a.logo:nth-child(2)")).isDisplayed();
			System.out.println("Successful Landed In Add Customer: " + eleDisplayed);
			sfSelenium.createTest("Successful Landed In Add Customer");
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
	}
	
	
	// Capture New User Details
	public void CaptureUserDetails(String sFirstname, String sLastname,
			String sEmail, String sAddress, String sPhone)throws IOException {

		// Clicking Done in Add Customer page
		driver.findElement(By.cssSelector("done")).click();

		// populate input data
		sfSelenium.populateInputField(By.name("fname"), sFirstname);
		sfSelenium.populateInputField(By.name("lname"), sLastname);
		sfSelenium.populateInputField(By.name("emailid"), sEmail);
		sfSelenium.populateInputField(By.name("addr"),sAddress);
		sfSelenium.populateInputField(By.name("telephoneno"), sPhone);

		// Capture a screenshot into the report
		sfSelenium.logScreenShot();
	}
	
	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}
	
	
	// Invalid Address
	@Test
	public void testFirst() throws Exception {
		
		String sFirstname = "Mb";
		String sSurname = "Baloyi";
		String sEmail = "pt@gmail.com";
		String sAddress = "123 Com,the";
		String sPhone = "0831231234";
		
		System.out.println("Test");
	}
	
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}

}

