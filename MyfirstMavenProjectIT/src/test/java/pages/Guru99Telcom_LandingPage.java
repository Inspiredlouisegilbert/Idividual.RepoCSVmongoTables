package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class Guru99Telcom_LandingPage extends BasePage {

	//First Test. This title should be verified in LandingPageTest class
    public String getTitle() {
        return driver.getTitle();
		} 
	
	public void verifyTelcomLandingPage() {
        
       	//Instantiate Selenium Functions
		String pURL = "http://demo.guru99.com/telecom/index.html";
		
		// Verify that Guru99 telecom Heading is available //
		String actualHeading = driver.findElement(By.cssSelector("#header .logo")).getText();
	    Assert.assertEquals(actualHeading, "Guru99 telecom");
		
	  //Verify that Add Customer Heading is available //
	 	String actual_link = driver.findElement(By.linkText ("Add Customer")).getText(); 
	 	Assert.assertEquals(actual_link, "Add Customer");
	    
	 	 	
	 	
	 	
	 	
		// Click on Add Customer
		driver.findElement(By.linkText("Add Customer")).click();  
		
    }
	

}