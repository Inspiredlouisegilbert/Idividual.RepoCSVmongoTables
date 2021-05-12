package Telco_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import frameworkclasses.SeleniumFunctions;

public class TelcoAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//DRIVER VARIABLE
	WebDriver driver;
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	// Set URL
	String pURL = "http://demo.guru99.com/telecom/index.html";
	
	//NAVIGATE TO URL
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		//sfSelenium.maximiseBrowserWindow();
	}
			
			//CLICK ON THE Add Customer
	public void clickAddCustomer() {
		sfSelenium.clickLink("Add Customer");
		
	}
	
	
	
	//POPULATE INPUT FIELDS
public void populateInpute(String pFisrtname ,String pLastName, String pEmail, String pAdress) {
	
	sfSelenium.findElement(By.xpath("//label[@for=" + done +  "]")).click();
	
	sfSelenium.populateInputField(By.name("fname"), pFisrtname);
	
	sfSelenium.populateInputField(By.name("lname"), pLastName);
	
	sfSelenium.populateInputField(By.name("emailid"), pEmail);
	
	sfSelenium.populateInputField(By.name("addr"), pAdress);

	driver.findElement(By.name("submit")).click();
	
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	
	

}
