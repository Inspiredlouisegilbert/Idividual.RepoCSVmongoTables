package pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

//boolean eleDisplayed;

public class CustomerIDPage extends BasePage {
	
	public String  verifyCustomerID_Heading() throws InterruptedException {
		
	// verify that the Access Details to Guru99 Telecom Heading is displays //
		 String actualHeading = driver.findElement(By.cssSelector("h1")).getText();
		//Assert.assertEquals(actualHeading, "Access Details to Guru99 Telecom");
		 
		return actualHeading;
	}
    
	public boolean Generated_Customer_ID() throws InterruptedException {
		
		
    // Asset for the Customer ID that keeps on Changing
      boolean CustomerID = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).isDisplayed();
      //String actualSlength = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).getText();
          
      return CustomerID;

	}
	
	public String Generated_Cust_ID() throws InterruptedException {
		
		
	    // Copy the Customer ID that keeps on Changing
	     
	    String Cust_ID = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).getText();	      
	      return Cust_ID;

		}
	
	public void  Click_Home_button_CustomerIDPage() {
		
	    //Click on Home button to navigate to Guru99Telcom_Landing page
	    driver.findElement(By.cssSelector(".button")).click();
		
	}
}

