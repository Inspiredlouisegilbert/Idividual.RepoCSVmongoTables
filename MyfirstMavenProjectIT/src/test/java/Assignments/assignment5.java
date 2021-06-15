package Assignments;

import java.io.FileWriter;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkclasses.ReusableFunctions;

public class assignment5 extends driverSetup{
	
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	assignment1 clAssignment1 = new assignment1();
	
	public void AddCustomer(String pBackgroundCheck)throws Exception {
		//instantiate variables
		String sCustomerID;
		Boolean bExpectedValue = true;
		Boolean bActualValue = false;
		
		//Navigate to URL
		clAssignment1.Setup();
		
		//click add customer
		driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.left:nth-child(1) div:nth-child(1) h3:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(500);
		
		//clear input fields
		driver.findElement(By.cssSelector("#fname")).clear();
		driver.findElement(By.cssSelector("#lname")).clear();
		driver.findElement(By.cssSelector("#email")).clear(); 
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]")).clear();
		driver.findElement(By.cssSelector("#telephoneno")).clear();
		
		//populate input fields
		sfSelenium.populateInputField(By.cssSelector("#fname"), "valid", driver);
		sfSelenium.populateInputField(By.cssSelector("#lname"), "name", driver);
		sfSelenium.populateInputField(By.cssSelector("#email"), "Valid@test.com", driver);
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), "37 Test Street Suburb", driver);
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "0112223333", driver);
		
		//select Background Check
		driver.findElement(By.xpath("//label[contains(text(),'" + pBackgroundCheck +"')]")).click();
		Thread.sleep(500);
		
		//click the Submit Button
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[9]/ul[1]/li[1]/input[1]")).click();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
		
		//Store Customer ID and validate that it is not empty
		sCustomerID = driver.findElement(By.tagName("h3")).getText();
		if (sCustomerID.length() > 1) {
			bActualValue = true;		
			//System.out.println("Customer ID: " + sCustomerID);
			
			FileWriter myWriter = new FileWriter("CustomerID.csv");
		    myWriter.write(sCustomerID);
		    myWriter.close();
		}
		Assert.assertEquals(bExpectedValue, bActualValue);
	}
	
	
	
}
