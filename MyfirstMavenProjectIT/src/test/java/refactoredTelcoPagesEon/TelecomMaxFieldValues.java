package refactoredTelcoPagesEon;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import pages.SignInPage;
import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Refactored.testsAssignment3;

public class TelecomMaxFieldValues extends BasePage{
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	testsAssignment3 clAssignment3 = new testsAssignment3();
	TelecomPayBilling clPayBilling = new TelecomPayBilling();
	
	String pURL = "http://demo.guru99.com/telecom/assigntariffplantocustomer.php";

	public void navigatetourl()
	{
		driver.get(pURL);
	}
	
	public void readfromfile() throws IOException, InterruptedException 
	{
		String readfromdir = getDataConfigProperties("readfromdir");
		String pCustomerID = "";
		
		BufferedReader br = new BufferedReader(new FileReader(readfromdir)); 
		String line;
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
		    // use xx as separator.
			    String[] cols = line.split(";"); 
			    System.out.println(cols[0]); 
				pCustomerID = cols[0];
				
				captureID(line);
				submit();   
				System.out.println("CustomerID successfully imported from selected CSV file");
			}
		}
		// close the buffer
		br.close();
	}
	
	public void captureID(String pClientID) throws InterruptedException {
		sfSelenium.populateInputField(By.cssSelector("#customer_id"), pClientID);
		submit();
	}
	
	public void submit() throws InterruptedException {
		this.driver.findElement(By.tagName("input")).click();
	}
}