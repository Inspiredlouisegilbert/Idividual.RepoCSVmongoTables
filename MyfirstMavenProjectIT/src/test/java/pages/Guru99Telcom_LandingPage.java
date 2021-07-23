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
    	//Instantiate Selenium Functions
    	String pUrl = "http://demo.guru99.com/telecom/index.html";
        //return driver.getTitle();
        return  getTitle();
	} 
	

	public String verifyTelcomLandingPage() {
        		
		String actualPage = driver.findElement(By.cssSelector("#header .logo")).getText();
	    //Assert.assertEquals(verifyTelcomLandingPage, "Guru99 telecom");
			
		return verifyTelcomLandingPage();
	}

	public String GetUrl() {
        
       	//Instantiate Selenium Functions
		String pURL = "http://demo.guru99.com/telecom/index.html";
		//NAVIGATE TO URL
		//public void navigateToURL(String pURL) {
		//driver.get(pURL);
		//sfSelenium.maximiseBrowserWindow();
		
		return GetUrl();
		}

	public String Guru99_Telcom_Heading () {
		
		// Verify that Guru99 telecom Heading is available //
		String verifyTelcomLandingPage = driver.findElement(By.cssSelector("#header .logo")).getText();
	    Assert.assertEquals(verifyTelcomLandingPage, "Guru99 telecom");
		return Guru99_Telcom_Heading();
		
		    
	}
	    
	    public String Verify_Addcust_Heading() {
		
	  //Verify that Add Customer Heading is available //
	 	String actual_link = driver.findElement(By.linkText ("Add Customer")).getText(); 
	 	Assert.assertEquals(actual_link, "Add Customer");  
	 	
		return Verify_Addcust_Heading();
	    }
	    
	 		 	
		public String Add_customer_Link() {
		// Click on Add Customer
		driver.findElement(By.linkText("Add Customer")).click();  
		
		return Add_customer_Link();
        }
			
	
	public String ClickAddCustomer_Link() {
		// Click on Add Customer
		driver.findElement(By.linkText("Add Customer")).click(); 
		//Verify that Add Customer Heading is available //
		//String actual_link = driver.findElement(By.linkText ("Add Customer")).getText(); 
		//Assert.assertEquals(actual_link, "Add Customer");  	 	 	
			return ClickAddCustomer_Link();
	}
	
	public String veriy_AddCustomer_Link() {
		// Click on Add Customer
		//driver.findElement(By.linkText("Add Customer")).click(); 
		//Verify that Add Customer Heading is available //
		String actual_link = driver.findElement(By.linkText ("Add Customer")).getText(); 
		 	 	 	
		return veriy_AddCustomer_Link();
	}
	

	public String verify_AddTariffPlanToCustomerLink() {       
       	
	//Verify that Add Tariff Plan to Customer Link is available //
 	String actual_link = driver.findElement(By.linkText ("Add Tariff Plan to Customer")).getText(); 
 	 	
		// Click on Add Tariff Plan to Customer
		driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();  
		
		return verify_AddTariffPlanToCustomerLink();
		 
	}
// line 56 to line 57 is the same as line  47-48
	public void ClickAddTariffPlanToCustomer_Link() {       
       		 	
		// Click on Add Tariff Plan to Customer
		driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();  
			
		}
	
	public void Click_Pay_Billing_Link() {       
		 	
		// Click on Pay billing
		driver.findElement(By.linkText("Pay Billing")).click();  
			
		}
	
	public void BackgroundChk_done() {   
	driver.findElement(By.cssSelector("[for='done']")).click();
	}
	

}