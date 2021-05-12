package TelcoProjectOne;

import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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

public class TelcoProjectOneTstNG {
	String pURL = "http://demo.guru99.com/V1/index.php";
	String sFirstname = "Eon";
	String sLastname = "Kruger";
	String sEmailInvalid = "email@gmail";		//INVALID EMAIL ADDRESS FOR ASSERTION
	String sEmailValid = "email@gmail.com";
	String sAddressInvalid = "1010 hollywood drive, new york";		//INVALID ADDRESS FOR ASSERTION
	String sAddressValid = "1010 hollywood drive new york";
	String sContactnumber = "0115678989";
	
	//Instantiate Selenium Functions
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	
	//NAVIGATE TO URL
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		//sfSelenium.maximiseBrowserWindow();
	}
		
	public void clickBankProject() {
		sfSelenium.clickLink("Telecom Project");
		sfSelenium.clickLink("Add Customer");
	}
		
	public void generateInputData() {
		driver.findElement(By.xpath("//label[@for='done']")).click();						//SELECT RADIO BUTTON
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(sFirstname);		//INPUT VALID FIRST NAME
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(sLastname);			//INPUT VALID LAST NAME NAME
		driver.findElement(By.id("email")).sendKeys(sEmailInvalid);							//INPUT INVALID EMAIL ADDRESS
		driver.findElement(By.xpath("//textare[@name='addr'][@id='message']")).sendKeys(sAddressInvalid);	//INPUT INVALID ADDRESS
		
		//ASSERTIONS
	}
	
	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}
	
	@Test
	public void testOne() throws Exception {
		sfSelenium.startReport("Telco  Project", "Add New Customer");
		sfSelenium.createTest("Start Test");
		this.driver = sfSelenium.getDriver();
		navigateToURL(pURL);
		clickBankProject();
		generateInputData();
		System.out.println("Test One");
		Thread.sleep(5000);
	}
	
	@Test
	public void testTwo() throws Exception {
		System.out.println("Test Two");
	}
	
	@Test
	public void testThree() throws Exception {
		System.out.println("Test Three");
	}
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}
}