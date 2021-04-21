package readFromCSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworkclasses.SeleniumFunctions;

public class BankProjectKeywords {

		//INITIATE SELENIUM FUNCTIONS 
		SeleniumFunctions sfSelenium = new SeleniumFunctions();
		
		//DRIVER VARIABLE
		WebDriver driver;
		
		String pURL = "http://demo.guru99.com";
		String pPropertyKey = "csvlogin";
		
		//NAVIGATE TO URL
		public void navigateToURL(String pURL) {
			driver.get(pURL);
			//sfSelenium.maximiseBrowserWindow();
		}
		
		//CLICK ON THE BANK PROJECT LINK
		public void clickBankProject() {
			sfSelenium.clickLink("Bank Project");		//CHROPATH LINK TEXT is "Bank Project"
		}
		
		public String getProperties(String pPropertyKey) {
			//DATA CONFIG SETUP
			Properties p = new Properties();
			InputStream is = null;
			try {
				is = new FileInputStream("dataConfig.properties");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			try {
					p.load(is);
				} catch (IOException e) {
					e.printStackTrace();
				}
			return p.getProperty(pPropertyKey);
		}
		
		public void runTestReadFromFile() throws IOException, InterruptedException {

			sfSelenium.startReport("Reading Data", "Reading data from the csv");		//CREATE REPORT
			sfSelenium.createTest("Run Test: Read From File");		//CREATE TEST
			
			//INPUT TEST DATA
			String pPassword = "";
			String pUserName = "";
			String pOutcome = "";
			String csvfile = getProperties("csvlogin"); 		//CREATED ENTRY FOR THE LOGIN CSV FILE
					
			BufferedReader br = new BufferedReader(new FileReader(csvfile)); 
			String line;
			
			while ((line = br.readLine()) != null) { 
				if(line.length() > 0) {
					//SPECIFY SEPERATOR
				    String[] cols = line.split(";"); 
				    System.out.println("UserName" + cols[0] + "Password" + cols [1] + "OutCome" + cols[2]);		//USERNAME COLUMN	
				    //System.out.println(cols[1]);		//PASSWORD COLUMN
				    //System.out.println(cols[2]);		//OUTCOME COLUMN
				    
				    pUserName = cols[0];
				    pPassword = cols[1];
				    pOutcome = cols[2];
				    
				    captureUserDetails(pUserName, pPassword);
				    
				    if (pOutcome.equals("successful login")) {
				    	
				    	testSuccessPopup();				//ASSERT FOR SUCCESSFUL LOGIN
				    }
				    else {
				    	
				    	testUnsuccessfulPopup();		//ASSERT FOR UNSUCCESSFUL LOGIN AND POPUP TEXT
				    }
					
				    clickBankProject();		//NAVIGATE BACK TO THE BANK PROJET LINK FOR NEXT INOUT FROM CSV FILE
				    
					// Log a Screenshot to the report
					sfSelenium.logScreenShot();
				}
			} 
		}
		
		
		// Capture User Details
		public void captureUserDetails(String pUserName, String pPassword) throws IOException, InterruptedException {
			// Capture UserName
			sfSelenium.populateInputField(By.name("uid"), pUserName);
			
			// Capture Password
			sfSelenium.populateInputField(By.name("password"), pPassword);
			
			//CSS SELECTOR FOR SUBMIT BUTTON
			driver.findElement(By.cssSelector("table:nth-child(1) tbody:nth-child(1) tr:nth-child(3) td:nth-child(2) > input:nth-child(1)")).click();

		}
			
		public void runTestStart() {
			this.driver = sfSelenium.getDriver();
			navigateToURL(pURL);
			clickBankProject();
			
			//READ IN USERNAMES AND PASSWORDS FROM CSV
			//VALIDATE SUCCESSFUL LOGINS
			//VALIDATE UNSUCCESSFUL LOGINS
			
			//GENERATE REPORT
			//SCREENSHOTS
		}
		
		public void testSuccessPopup() {
			//ASSERT FOR IMAGES AND/OR TEXT
			//Check for Image
			//boolean eleSelected = driver.findElement(By.xpath("xpath")).isDisplayed();		//ELEMENT FOR IMAGE ASSERT
			boolean eleDisplayed = driver.findElement(By.cssSelector("table.layout:nth-child(5) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) center:nth-child(1) > img:nth-child(1)")).isDisplayed();
			System.out.println(eleDisplayed);
		}
		
		public void testUnsuccessfulPopup() throws InterruptedException {
			//HANDLE UNSUCCESSFUL POPUP ALERT
			sfSelenium.createTest("Run Alert Failure: Unsuccessful login popup text test");
			String pExpectedMessage = "User is not valid";
			// End of - Input Test Data
			
			// Keywords
//			navigateToURL(pURL);
//			clickBankProject();
//			
			//captureUserDetails(pUserName, pPassword);
			//this.driver.findElement(By.name("btnLogin")).click();

			//Create an object of the alert
			
				Alert alert = this.driver.switchTo().alert();
				String sAlertMessage = alert.getText();
				System.out.println(sAlertMessage);

				alert.accept();
				sfSelenium.updateReport(sAlertMessage,pExpectedMessage);
				
			Thread.sleep(500);
		}
		
		//CLEANUP
		public void cleanup () throws IOException, InterruptedException {
			sfSelenium.createTest("Run Test: clean up");
			// set the value for driver
			this.driver = sfSelenium.getDriver();
			sfSelenium.CloseSelenium();
		}
		
		//CLOSE THE BUFFER READER
}
