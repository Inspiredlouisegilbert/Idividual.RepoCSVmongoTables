package TelcoProjectOne;

import static org.testng.Assert.fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
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

public class TelcoProjectOneTstNG {
	String pURL = "http://demo.guru99.com/V1/index.php";
	String sFirstname = "Eon";
	String sLastname = "Kruger";
	String sEmailInvalid = "email@gmail";		//INVALID EMAIL ADDRESS FOR ASSERTION
	String sEmailValid = "email@gmail.com";
	String sAddressInvalid = "1010 hollywood drive, new york";		//INVALID ADDRESS FOR ASSERTION		//ESCAPE THE SPECIAL CHARACTER
	String sAddressValid = "1010 hollywood drive new york";
	String sContactnumber = "0115678989";
	boolean eleDisplayed;
	
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
		
	public void generateInvalidInputData() {
		
		String sActualValue = driver.findElement(By.cssSelector("body.subpage:nth-child(2) span:nth-child(5) nav.left > a.logo:nth-child(2)")).getAttribute("value");
		
		//ASSERTION THAT GURU99 TELECOM TEXT IS VISIBLE
		try {
			
			//ATTEMPT 1
			eleDisplayed = driver.findElement(By.cssSelector("body.subpage:nth-child(2) span:nth-child(5) nav.left > a.logo:nth-child(2)")).isDisplayed();
			System.out.println("Assertion One: Guru99 telecom text is visible: " + eleDisplayed);
			sfSelenium.createTest("Guru99 telecom text is visible");
			
//			//ATTEMPT2
//			System.out.println("Test passed: Excpected value is: Guru99 telecom " + " Actual value is: " + sActualValue);
			
			boolean eleDisplayed = driver.findElement(By.cssSelector("body.subpage:nth-child(2) span:nth-child(5) nav.left > a.logo:nth-child(2)")).isDisplayed();
			System.out.println("Additional assertion for text (used boolean) test passed: " + eleDisplayed);
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		//ASSERTION THAT ADD CUSTOMER TEXT IS VISIBLE
		try {
			eleDisplayed = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner header.align-center:nth-child(1) > h1:nth-child(1)")).isDisplayed();
			System.out.println("Assertion Two: Add customer text is visible: " + eleDisplayed);
			sfSelenium.createTest("Add customer text is visible");
		}
			catch(NoSuchElementException e) {
				System.out.println(e);
		}
		
		driver.findElement(By.xpath("//label[@for='done']")).click();										//SELECT RADIO BUTTON
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(sFirstname);						//INPUT VALID FIRST NAME
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(sLastname);							//INPUT VALID LAST NAME NAME
		driver.findElement(By.id("email")).sendKeys(sEmailInvalid);											//INPUT INVALID EMAIL ADDRESS
		driver.findElement(By.xpath("//textarea[@name='addr'][@id='message']")).sendKeys(sAddressInvalid);	//INPUT INVALID ADDRESS
		
		//ASSERTIONS FOR INVALID EMAIL ADDRESS
		try {
		boolean eleDisplayed = driver.findElement(By.cssSelector("#message9")).isDisplayed();
		System.out.println("Assertion Three: Invalid email address check passed: " + eleDisplayed);
		sfSelenium.createTest("Invalid email address check passed");
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
	}
	
	public void clickSubmit()
	{
		//CLICK SUBMIT BUTTON
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	
	public void generatevalidInput()
	{
		driver.findElement(By.xpath("//label[@for='done']")).click();										//SELECT RADIO BUTTON
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(sFirstname);						//INPUT VALID FIRST NAME
		driver.findElement(By.xpath("//input[@name='lname']")).sendKeys(sLastname);							//INPUT VALID LAST NAME NAME
		driver.findElement(By.id("email")).sendKeys(sEmailValid);											//INPUT INVALID EMAIL ADDRESS
		driver.findElement(By.xpath("//textarea[@name='addr'][@id='message']")).sendKeys(sAddressValid);	//INPUT INVALID ADDRESS
	}
	
	//HANDLE THE POPUP MESSAGE
	public void handlePopup()
	{	
		try {
			clickSubmit();
			String pExpectedMessage = "please fill all fields";
			Alert alert = this.driver.switchTo().alert();
			String sAlertMessage = alert.getText();
			System.out.println("Actual message: " + sAlertMessage);
			System.out.println("Expected message: " + pExpectedMessage);

			alert.accept();
			eleDisplayed = driver.findElement(By.cssSelector("table.layout:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) center:nth-child(1) > img:nth-child(1)")).isDisplayed();
			
			Thread.sleep(500);
	}
	catch(Exception e) {
		System.out.println(e);
	}
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
		generateInvalidInputData();
		System.out.println("Test One");
		Thread.sleep(5000);
	}
	
	@Test
	public void testTwo() throws Exception {
		sfSelenium.startReport("Telco  Project", "Add New Customer");
		sfSelenium.createTest("Start Test");
		this.driver = sfSelenium.getDriver();
		navigateToURL(pURL);
		clickBankProject();
		generatevalidInput();
		clickSubmit();
		System.out.println("Test Two");
	}
	
	@Test
	//ASSERT THAT CLIENT ID HAS BEEN GENERATED AND PRINT THE VALUE
	public void testThree() throws Exception {
		System.out.println("Test Three");
	}
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}
}