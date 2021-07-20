package tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestRunner;
import org.testng.annotations.Test;

import MbhoniAssessment.GeewizLandingPageObjects;
import MbhoniAssessment.GeewizLandingPageObjectsForLessThan100;
import MbhoniAssessment.GeewizLandingPageObjectsReadFromCsv;
import frameworkclasses.Utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LandingPage;
import pages.ProductSearchPage;
import pages.SignInPage;


public class MbhoniAssTest {
	
	// Declare an object of classes and
	// Instantiate class objects
	GeewizLandingPageObjects landingPage = new GeewizLandingPageObjects();
	GeewizLandingPageObjectsReadFromCsv landingPageReadCsv = new GeewizLandingPageObjectsReadFromCsv();
	GeewizLandingPageObjectsForLessThan100 landingPageLessThan = new GeewizLandingPageObjectsForLessThan100();
	Utilities uts = new Utilities();
	SoftAssert softAssert = new SoftAssert();

	@Test
    public void search_For_Products_Greater_Than_100 () throws InterruptedException, IOException {
		
		landingPage.searchProduct("royal");
		landingPage.clickSearchButton();
		landingPage.clickDropDown();
		landingPage.selectFromDropDown();
		landingPage.clickFirstResult();
		landingPage.enterQuanity("50");
		landingPage.lowStockPopWindow();
		landingPage.enterQuanity("1");
		landingPage.addToCart();
		// I have added the 2nd click due to: the 1st click is clicked but it looks like nothing is added to the cart.
		landingPage.addToCart();
		landingPage.clickContinueShopping();
		landingPage.vaildateCartAmount();
		
		softAssert.assertAll();
		
	}
	
	@Test
    public void runTestReadFromFile() throws IOException, InterruptedException {

		String Ass = uts.getDataConfigProperties("Ass");
		BufferedReader br = new BufferedReader(new FileReader(Ass)); 
		
		String line;
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
				
				String[] cols = line.split(";"); 
			    System.out.println(cols[0]);
			    
			    landingPageReadCsv.searchProduct(cols[0]);
			    landingPageReadCsv.clickSearchButton();
				
			    landingPageReadCsv.clickDropDown();
			    landingPageReadCsv.selectFromDropDownCsv(cols[1]);
				//landingPage.clickFirstResult();
			    landingPageReadCsv.clickFirstResultCsv(cols[2]);
			    landingPageReadCsv.enterQuanityCsv(cols[3]);
			    landingPageReadCsv.lowStockPopWindow();
			    landingPageReadCsv.enterQuanityCsv(cols[4]);
			    landingPageReadCsv.addToCart();
				// I have added the 2nd click due to: the 1st click is clicked but it looks like nothing is added to the cart.
			    landingPageReadCsv.addToCart();
			    landingPageReadCsv.clickContinueShopping();
			    landingPageReadCsv.vaildateCartAmount();
				
				softAssert.assertAll();
			}
			

		}
		
			br.close();	
	}
			
	
	@Test
    public void search_For_Products_Less_Than_100 () throws InterruptedException, IOException {
		
		//landingPageLessThan.Refresh();
		landingPageLessThan.searchProduct("pan");
		landingPageLessThan.clickSearchButton();
		landingPageLessThan.clickDropDown();
		landingPageLessThan.selectFromDropDown();
		landingPageLessThan.clickFirstResult();
		landingPageLessThan.enterQuanity("5000");
		landingPageLessThan.lowStockPopWindow();
		landingPageLessThan.enterQuanity("1");
		landingPageLessThan.addToCart();
		// I have added the 2nd click due to: the 1st click is clicked but it looks like nothing is added to the cart.
		landingPageLessThan.addToCart();
		landingPageLessThan.clickContinueShopping();
		landingPageLessThan.vaildateCartAmount();
		
		softAssert.assertAll();
		
	}
	

		@AfterSuite
	    public void cleanup() {
			
	        //Instantiate SignInPage class object
	        SignInPage inPage = new SignInPage();

	        inPage.cleanUp();
	        

	}
}