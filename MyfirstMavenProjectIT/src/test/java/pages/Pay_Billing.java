package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;



import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class Pay_Billing {
	
	public String Verify_Guru99Telecom_logo() {
        

		// Verify that Guru99 telecom Heading is available //
		String verifyTelcomLandingPage = driver.findElement(By.cssSelector("#header .logo")).getText();
	    Assert.assertEquals(verifyTelcomLandingPage, "Guru99 telecom");
	    
	    return Verify_Guru99Telecom_logo();
	    			    
	}
			    
	    public String Verify_Pay_billing_heading() {
	    	
	    
	  //Verify that Pay billing heading is displayed
	 	String actual_link = driver.findElement(By.cssSelector("h1")).getText(); 
	 	Assert.assertEquals(actual_link, "Pay Billing");  
	 		
		return Verify_Pay_billing_heading();
		
 
    }
	    
		
	    public void AddGenerated_Cust_ID(String sCustID) {

	 	   // Add the generated Customer ID   
	 	   //String Cust_ID = driver.findElement(By.cssSelector("#customer_id")).getText();
	 	   populateInputField(By.name("customer_id"),sCustID);
	 	 //Populate the billing details

	 	}

		private void populateInputField(By name, String sCustID) {
			// TODO Auto-generated method stub
			
		}
		
		public void  Click_Submit_Button_on_Pay_billing_page() {

			   //Click on Submit button 
			   driver.findElement(By.cssSelector("input[name='submit']")).click();

			}
	
	
	
	//********LETS TRY RUN OUR TEST TOMMOROW AND CONCLUDE ASSIGMENT 3 TESTCASE 3 AND 4
		
		
		
		public void 
		
		
		
		

}
          // Code to Create a customer who has done a credit check already exist on Add customer page




