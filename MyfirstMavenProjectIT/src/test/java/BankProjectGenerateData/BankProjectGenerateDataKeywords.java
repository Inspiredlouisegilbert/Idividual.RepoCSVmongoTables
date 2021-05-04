package BankProjectGenerateData;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import frameworkclasses.SeleniumFunctions;

public class BankProjectGenerateDataKeywords {

	//INSTANTIATE NEW INSTANCE OF SELENIUM FUNCTIONS
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	//DRIVER VARIABLE
	WebDriver driver;
	// Set URL
	
	String pURL = "http://demo.guru99.com";
	String sValidateEmailAddress = "email@gmail.com";
	
	//NAVIGATE TO URL
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		//sfSelenium.maximiseBrowserWindow();
	}
	
	//NAVIGATE TO BANK PROJECT
	//CLICK ON THE BANKING LINK
		public void clickBankProject() {
			sfSelenium.clickLink("Bank Project");
			sfSelenium.clickLink("here");
		}
		
		public void validateEmailAddress() {
			//CREATE TEST TO VALIDATE EMAIL ADRESS
			//BY XPATH TEMPLATE (By.xpath("//input[@='']"))
			driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(sValidateEmailAddress);
			driver.findElement(By.name("btnLogin")).click();
		}
	
		//GENERATE USERNAME AND PASSWORD
		public void generateValidLogins() throws IOException {
			String cssUserID = "body:nth-child(2) table:nth-child(10) tbody:nth-child(1) tr:nth-child(4) > td:nth-child(2)";
			String sUserID = this.driver.findElement(By.cssSelector(cssUserID)).getText();
			String cssPassword = "body:nth-child(2) table:nth-child(10) tbody:nth-child(1) tr:nth-child(5) > td:nth-child(2)";
			String sPassword = this.driver.findElement(By.cssSelector(cssPassword)).getText();
			String pOutcome = "";
			
			//NAVIGATE BACK TO THE BANK PROJECT
			sfSelenium.clickLink("Bank Project");
			
			//POPULATE INPUT FIELDS
			sfSelenium.populateInputField(By.name("uid"), sUserID);
			sfSelenium.populateInputField(By.name("password"), sPassword);
			driver.findElement(By.name("btnLogin")).click();
			
//			if	(pOutcome.equals(driver.findElement() {
//					successfulLogin();
//					sfSelenium.createTest("Successful login: Login was successful");
//			}
//				else {
//					unsuccessfulPopup();
//					sfSelenium.createTest("Run Alert Failure: Unsuccessful login popup text test");
//			}
		}
		
		//CREATE METHOD TO CLICK ON CLEAR AND ASSERT THAT INPUT FIELDS HAS BEEN REMOVED
		public void successfulLogin() {
			//ASSERT FOR IMAGE AFTER SUCCESSFUL LOGIN
			boolean eleDisplayed = driver.findElement(By.cssSelector("table.layout:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) center:nth-child(1) > img:nth-child(1)")).isDisplayed();
			System.out.println("Successful Login Assertion passed: " + eleDisplayed);
			sfSelenium.createTest("Successful Login");
		}
		
		public void unsuccessfulPopup() throws InterruptedException {
			//HANDLE UNSUCCESSFUL POPUP ALERT
			sfSelenium.createTest("Run Alert Failure: Unsuccessful login popup text test");
			String pExpectedMessage = "User is not valid";
			
			//CREATE AN OBJECT OF THE POPUP
			
				Alert alert = this.driver.switchTo().alert();
				String sAlertMessage = alert.getText();
				System.out.println(sAlertMessage);

				alert.accept();
				sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
				
			Thread.sleep(500);
		}
	
	//IF STATEMENT FOR SUCCESS
	//GENERATE REPORT
	//TAKE SCREENSHOTS
	//ASSERT ON IMAGE
	//ADDITIONAL ASSERT ON IS DISPLAYED TEXT
	
	//IF STATEMENT FOR UNSUCCESSFUL LOGIN
	//HANDLE THE ALERT POPUP
	//GENERATE REPORT
	//TAKE SCREENSHOTS
	
	//RUN TESTS
		public void runTest () throws IOException, InterruptedException {
			sfSelenium.startReport("Bank  Project", "Generate Input Data");
			sfSelenium.createTest("Start Test");
			this.driver = sfSelenium.getDriver();
			navigateToURL(pURL);
			clickBankProject();
			validateEmailAddress();
			generateValidLogins();
			successfulLogin();
			//unsuccessfulPopup();
		}
		
	//GENERATE REPORT
	//TAKE SCREENSHOTS
	//CLICK ON LOGOUT
		
	//LOGOUT
		//ASSERT SUCCESSFUL LOGOUT POPUP ALERT
	
		public void cleanup () throws IOException, InterruptedException {
			sfSelenium.createTest("Run Test: clean up");
			// set the value for driver
			this.driver = sfSelenium.getDriver();
			Thread.sleep(5000);
			sfSelenium.CloseSelenium();
			this.driver.quit();
		}
}
