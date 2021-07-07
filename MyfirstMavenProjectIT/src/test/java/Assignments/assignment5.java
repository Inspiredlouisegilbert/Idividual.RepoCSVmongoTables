package Assignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import frameworkclasses.ReusableFunctions;

public class assignment5 extends driverSetup{
	
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	assignment1 clAssignment1 = new assignment1();
	
	public void CreateCustomerCSV(String pFirstName, String pLastName, String pEmail, String pAddress, String pNumber, String pBackgroundCheck)throws Exception {
		//Navigate to URL
		clAssignment1.Setup();
		
		//click add customer
		driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.left:nth-child(1) div:nth-child(1) h3:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(500);
		
		//write data to file
		FileWriter myWriter = new FileWriter("CustomerDetails.csv");
	    myWriter.write(pFirstName + ";");
	    myWriter.write(pLastName + ";");
	    myWriter.write(pEmail + ";");
	    myWriter.write(pAddress + ";");
	    myWriter.write(pNumber + ";");
	    myWriter.write(pBackgroundCheck + ";");
	    myWriter.close();
	}
	
	public void AddCustomerFromCSV(String pValid)throws Exception {
		//read data from file
		BufferedReader br = new BufferedReader(new FileReader("CustomerDetails.csv"));
		String line = br.readLine();
		String[] CustomerDetails = line.split(";");
		//set customer details
		String sFirstName = CustomerDetails[0];
		String sLastName = CustomerDetails[1];
		String sEmail = CustomerDetails[2];
		String sAddress = CustomerDetails[3];
		String sNumber = CustomerDetails[4];
		String sBackgroundCheck = CustomerDetails[5];
		
		Boolean bExpectedValue = true;
		Boolean bActualValue = false;
		
		Boolean bFnameValid;
		Boolean bLnameValid;
		Boolean bEmailValid;
		Boolean bAddressValid;
		Boolean bTelephonenoValid;
		
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
		sfSelenium.populateInputField(By.cssSelector("#fname"), sFirstName);
		sfSelenium.populateInputField(By.cssSelector("#lname"), sLastName);
		sfSelenium.populateInputField(By.cssSelector("#email"), sEmail);
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), sAddress);
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), sNumber);
		
		//select Background Check
		driver.findElement(By.xpath("//label[contains(text(),'" + sBackgroundCheck +"')]")).click();
		Thread.sleep(500);
		
		if (pValid.equals("invalid")) {
			//check if warning messages are displayed
			bFnameValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[4]/label[1]")).isDisplayed();
			bLnameValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[5]/label[1]")).isDisplayed();
			bEmailValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[6]/label[1]")).isDisplayed();
			bAddressValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/label[1]")).isDisplayed();
			bTelephonenoValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[8]/label[1]")).isDisplayed();
			
			//do assertions on the warning messages
			Reporter.log("expected ------------------"+ bExpectedValue);
		    Reporter.log("actual --------------------"+ bFnameValid);
			Assert.assertEquals(bExpectedValue, bFnameValid);
			Reporter.log("expected ------------------"+ bExpectedValue);
		    Reporter.log("actual --------------------"+ bLnameValid);
			Assert.assertEquals(bExpectedValue, bLnameValid);
			Reporter.log("expected ------------------"+ bExpectedValue);
		    Reporter.log("actual --------------------"+ bEmailValid);
			Assert.assertEquals(bExpectedValue, bEmailValid);
			Reporter.log("expected ------------------"+ bExpectedValue);
		    Reporter.log("actual --------------------"+ bAddressValid);
			Assert.assertEquals(bExpectedValue, bAddressValid);
			Reporter.log("expected ------------------"+ bExpectedValue);
		    Reporter.log("actual --------------------"+ bTelephonenoValid);
			Assert.assertEquals(bExpectedValue, bTelephonenoValid);
			
			//click the Submit Button
			driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[9]/ul[1]/li[1]/input[1]")).click();
			
			//handle the alert
			Alert alert = driver.switchTo().alert();
			String sAlertMessage = alert.getText();
			Reporter.log("expected ------------------"+ "please fill all fields");
		    Reporter.log("actual --------------------"+ sAlertMessage);
			Assert.assertEquals("please fill all fields", sAlertMessage);
			alert.accept();
		}
		else {
			//click the Submit Button
			driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[9]/ul[1]/li[1]/input[1]")).click();

			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
			
			//Store Customer ID and validate that it is not empty
			String sCustomerID = driver.findElement(By.tagName("h3")).getText();
			if (sCustomerID.length() > 1) {
				bActualValue = true;		
				//System.out.println("Customer ID: " + sCustomerID);
				
				FileWriter myWriter = new FileWriter("CustomerID.csv");
			    myWriter.write(sCustomerID);
			    myWriter.close();
			}
			Reporter.log("expected ------------------"+ bExpectedValue);
		    Reporter.log("actual --------------------"+ bActualValue);
			Assert.assertEquals(bExpectedValue, bActualValue);
		}
		
		
	}
	
	
	
}
