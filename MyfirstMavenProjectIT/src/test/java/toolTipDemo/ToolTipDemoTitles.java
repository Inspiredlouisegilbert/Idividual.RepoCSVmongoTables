package toolTipDemo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;


public class ToolTipDemoTitles extends DriverSetup{

	//INSTANTIATE NEW INSTANCE OF SELENIUM FUNCTIONS
	ReusableFunctions sfSelenium = new ReusableFunctions();
	
	// Set URL
	String pURL = "http://www.takealot.com/";

	//Set invalid data
	String sInvalidId = "test@test";
	String sInvalidPassword = "Passwo";
	

	
	//NAVIGATE TO URL
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		//sfSelenium.maximiseBrowserWindow();
	}
	
	//NAVIGATE TO BANK PROJECT
	public void toolTipDemo() {
			String expectedTooltip = "Facebook";	
			
			/*
			 * 	moveToElement(element) of Actions class is used to mouse hover an element.
			 * 
				Build() method of Actions class builds the sequence of user actions into an Action object.
				Perform() of Action class executes all the sequence of user actions at once.
			 */
			//a[@title='Facebook']
			WebElement github = driver.findElement(By.xpath("//a[@class='responsive-footer-module_facebook_2op82']"));	
	        
	        //get the value of the "title" attribute of the github icon		
	        String actualTooltip = github.getAttribute("title");	
	        System.out.print(actualTooltip);
	        
	       
		
	        Assert.assertEquals(expectedTooltip, actualTooltip);
	}
		
		//RUN TESTS
		@Test
		public void testCase2 () throws IOException, InterruptedException {
			navigateToURL(pURL);
			toolTipDemo();
		}
		
		@AfterSuite
		public void cleanup () throws IOException, InterruptedException {
			sfSelenium.CloseSelenium(driver);
		}
}
