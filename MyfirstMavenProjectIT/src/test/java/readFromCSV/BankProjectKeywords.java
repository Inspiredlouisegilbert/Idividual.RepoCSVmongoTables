package readFromCSV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		String pPropertyKey = "csvlogon";
		
		// Navigate to demo.guru99.com
		public void navigateToURL(String pURL) {
			driver.get(pURL);
			sfSelenium.maximiseBrowserWindow();
		}
		
		// Click on Bank Project Link
		public void clickBankProject() {
			sfSelenium.clickLink("Bank Project");
		}
		
		public String getProperties(String pPropertyKey) {
			// Properties setup
					Properties p = new Properties();
					InputStream is = null;
					try {
						is = new FileInputStream("dataConfig.properties");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						p.load(is);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			return p.getProperty(pPropertyKey);
		}
		
		public void runTestReadFromFile () throws IOException, InterruptedException {

			//sfSelenium.createTest("Run Test: Read From File");
			// Input test Data
			String pPassword = "";
			String pUserName = "";
			String pOutcome = "";
			String csvfile = getProperties("csvlogin"); 
					
			BufferedReader br = new BufferedReader(new FileReader(csvfile)); 
			String line;
			while ((line = br.readLine()) != null) { 
				if(line.length() > 0) {
			    // use xx as separator.
				    String[] cols = line.split(";"); 
				    System.out.println(cols[0]);
				    System.out.println(cols[1]);
				    System.out.println(cols[2]);
				    
				    pUserName = cols[0];
				    pPassword = cols[1];
				    pOutcome = cols[2];
				}
			} 
		}
		
		public void Logon() {
			//TO DO
		}
		
		public void runTestStart() {
			this.driver = sfSelenium.getDriver();
			navigateToURL(pURL);
			clickBankProject();
			
		}
}
