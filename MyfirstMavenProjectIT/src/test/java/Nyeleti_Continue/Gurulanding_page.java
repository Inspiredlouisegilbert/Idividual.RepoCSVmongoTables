package Nyeleti_Continue;

import org.openqa.selenium.By;
import org.testng.Assert;

import frameworkclasses.BasePage;

public class Gurulanding_page extends BasePage{
	
		
		//First Test. This title should be verified in LandingPageTest class
	    public String getTitle() {
	        return driver.getTitle();
			} 
		
		public String GetUrl() {
	        
	       	//Instantiate Selenium Functions
			String actualURL = driver.getCurrentUrl();
			return actualURL;		
		}
		
		
		 public void Navigate_to_URL() {
			 String pURL = "http://demo.guru99.com/telecom/index.html";
			 driver.get(pURL);
			//sfSelenium.maximiseBrowserWindow();
			
		}			

		public String Guru99_Telcom_Heading () {
			
			// Verify that Guru99 telecom Heading is available //
			String verifyTelcomLandingPage = driver.findElement(By.xpath("//span[@id='header']//a[@href='index.html']")).getText();
		    Assert.assertEquals(verifyTelcomLandingPage, "Guru99 telecom");
			return verifyTelcomLandingPage;
			
			
			    
		}
		    
		    public String Verify_Addcust_Heading() {
			
		  //Verify that Add Customer Heading is available //
		 	String actual_link = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
		 	Assert.assertEquals(actual_link, "Add Customer");
			return actual_link;  
		 	
		
		    }
		    
		 		 	
			public void Add_customer_Link() {
			// Click on Add Customer
			//driver.findElement(By.linkText("Add Customer")).click();  
			driver.findElement(By.cssSelector(".flex-item [href='addcustomer\\.php']")).click();
			
			//return Add_customer_Link();
	        }
				
			
		public String verify_AddTariffPlanToCustomerLink() {       
	       	
		//Verify that Add Tariff Plan to Customer Link is available //
	 	String actual_link = driver.findElement(By.linkText ("Add Tariff Plan to Customer")).getText(); 
	 	Assert.assertEquals(actual_link, "Add Tariff Plan to Customer");  
	 	
	 	
			// Click on Add Tariff Plan to Customer
			driver.findElement(By.linkText("Add Tariff Plan to Customer")).click();  
			
			return verify_AddTariffPlanToCustomerLink();
			 
		}
	// line 56 to line 57 is the same as line  47-48
		public void ClickAddTariffPlanToCustomer_LinkNavigateToUrl() {       
	       		 	
			 String pURL = "http://demo.guru99.com/telecom/index.html";
			 driver.get(pURL);
			//sfSelenium.maximiseBrowserWindow();
				
			}
		public void Click_Pay_Billing_Link() {       
			 	
			// Click on Pay billing

			driver.findElement(By.cssSelector(".flex-item.right > div:nth-of-type(2) > h3 > a")).click();
			
				
			}
		
		
		//Add the customer id to a variable for later use
		public void Add_Customer_Var () {
			
			driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(1)"));
					
        }


	
		 public String verify_PayBilling_Heading() {
			 
			 
		//Verify that Pay Billing Heading is available //
	
			String actual_link = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Pay Billing']")).getText();
		 	Assert.assertEquals(actual_link, "Pay Billing");
			return actual_link;
			

}

}
