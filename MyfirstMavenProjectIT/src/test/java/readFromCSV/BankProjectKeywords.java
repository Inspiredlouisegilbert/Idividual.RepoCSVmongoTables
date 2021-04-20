package readFromCSV;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import frameworkclasses.SeleniumFunctions;

public class BankProjectKeywords {

	// Selenium Functions 
		SeleniumFunctions sfSelenium = new SeleniumFunctions();
		
		// driver variable
		WebDriver driver;
		// Set URL
		
		String pURL = "http://demo.guru99.com";
		
		// Navigate to demo.guru99.com
		public void navigateToURL(String pURL) {
			driver.get(pURL);
			sfSelenium.maximiseBrowserWindow();
		}
		
		// Click on Bank Project Link
		public void clickBankProject() {
			sfSelenium.clickLink("Bank Project");
		}
		
		public void runTestStart() {
			this.driver = sfSelenium.getDriver();
			navigateToURL(pURL);
			clickBankProject();
		}
}
