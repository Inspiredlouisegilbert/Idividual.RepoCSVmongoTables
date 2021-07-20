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
	ProductSearchPage pr = new ProductSearchPage();
	HomePage homePage = new HomePage();
	Utilities uts = new Utilities();
	SoftAssert softAssert = new SoftAssert();

	

	
	@Test
    public void search_Products () throws InterruptedException {
//        String expectedTitle = "My Store";
//        String actualTitle = landingPage.getTitle();
//         
//        Reporter.log("expected ------------------"+expectedTitle);
//        Reporter.log("actual --------------------"+actualTitle);
//        Assert.assertEquals(actualTitle, expectedTitle ); 
//        
		
		landingPage.searchProduct("solar");
		landingPage.clickSearchButton();
		landingPage.clickDropDown();
		landingPage.selectFromDropDown();
		landingPage.clickFirstResult();
		landingPage.enterQuanity("50");
		landingPage.lowStockPopWindow();
		landingPage.enterQuanity("2");
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
			    
				landingPage.searchProduct(cols[0]);
				landingPage.clickSearchButton();
				
				landingPage.clickDropDown();
				landingPage.selectFromDropDownCsv(cols[1]);
				//landingPage.clickFirstResult();
				landingPage.clickFirstResultCsv(cols[2]);
				landingPage.enterQuanity(cols[3]);
				landingPage.lowStockPopWindow();
				landingPage.enterQuanity(cols[4]);
				landingPage.addToCart();
				// I have added the 2nd click due to: the 1st click is clicked but it looks like nothing is added to the cart.
				landingPage.addToCart();
				landingPage.clickContinueShopping();
				//landingPage.vaildateCartAmount();
				
				softAssert.assertAll();
			}
			

		}
		
			br.close();
		
	}
	
	@Test
    public void runTestReadFromFile1() throws IOException, InterruptedException {

		String Ass1 = uts.getDataConfigProperties("Ass1");
		BufferedReader br = new BufferedReader(new FileReader(Ass1)); 
		
		String line;
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
				
				String[] cols = line.split(";"); 
			    System.out.println(cols[0]);
			    
				landingPage.searchProduct(cols[0]);
				landingPage.clickSearchButton();
				
				landingPage.clickDropDown();
				landingPage.selectFromDropDownCsv(cols[1]);
				landingPage.clickFirstResultCsv(cols[2]);
				landingPage.enterQuanity(cols[3]);
				landingPage.lowStockPopWindow();
				landingPage.enterQuanity(cols[4]);
				landingPage.addToCart();
				// I have added the 2nd click due to: the 1st click is clicked but it looks like nothing is added to the cart.
				landingPage.addToCart();
				landingPage.clickContinueShopping();
				landingPage.vaildateCartAmount();
				
				softAssert.assertAll();
			}
			

		}
		
			br.close();
		
	}
		
		@AfterSuite
	    public void cleanup() {
			
	        //Instantiate SignInPage class object
	        SignInPage inPage = new SignInPage();

	        inPage.cleanUp();
	        

	}
}