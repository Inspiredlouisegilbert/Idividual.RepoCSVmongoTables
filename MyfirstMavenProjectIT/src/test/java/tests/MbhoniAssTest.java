package tests;

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

	

	
	@Test
    public void Search_Products () throws InterruptedException {
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
		
	}

	
	
}