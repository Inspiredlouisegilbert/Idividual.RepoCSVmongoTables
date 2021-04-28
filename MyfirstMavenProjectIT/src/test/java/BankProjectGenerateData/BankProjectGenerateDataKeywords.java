package BankProjectGenerateData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import frameworkclasses.SeleniumFunctions;

public class BankProjectGenerateDataKeywords {

	//INSTANTIATE NEW INSTANCE OF SELENIUM FUNCTIONS
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	//DRIVER VARIABLE
	WebDriver driver;
	// Set URL
	
	String pURL = "http://demo.guru99.com";
	
	//NAVIGATE TO URL
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		//sfSelenium.maximiseBrowserWindow();
	}
	
	//NAVIGATE TO BANK PROJECT
	// Click on Payment Gateway Link
		public void clickBankProject() {
			sfSelenium.clickLink("Bank Project");
		}
	
	//GENERATE USERNAME AND PASSWORD
		
	//STORE USERNAME AND PASSWORD
	
	//NAVIGATE BACK TO URL
	
	//ENTER USERNAME AND PASSWORD GENERATED
	//GENERATE REPORT
	//TAKE SCREENSHOTS
	
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
		
			this.driver = sfSelenium.getDriver();
			navigateToURL(pURL);
			
		}
		
	//GENERATE REPORT
	//TAKE SCREENSHOTS
	//CLICK ON LOGOUT
	
	//PERFORM CLEANUP

	//CLOSE SELENUM
}
