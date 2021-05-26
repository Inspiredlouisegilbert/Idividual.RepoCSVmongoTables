package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestRunner;
import org.testng.annotations.Test;

import frameworkclasses.Utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.LandingPage;
import pages.ProductSearchPage;
import pages.SignInPage;


public class LandingPageTest {
	
	// Declare an object of classes and
	// Instantiate class objects
	SignInPage inPage = new SignInPage();
	LandingPage landingPage = new LandingPage();
	ProductSearchPage pr = new ProductSearchPage();
	HomePage homePage = new HomePage();
	Utilities uts = new Utilities();

	

	
	@Test
    public void GIVEN_navigateToURL_THEN_TitleMyStore() {
        String expectedTitle = "My Store";
        String actualTitle = landingPage.getTitle();
         
        Reporter.log("expected ------------------"+expectedTitle);
        Reporter.log("actual --------------------"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle ); 
        
	}
	
	@Test
    public void GIVEN_navigateToURL_WHEN_searchProduct_THEN_ProductDisplayed() {

        landingPage.searchProduct();
        String expected = "Printed Summer Dress";
        String actual = pr.getProductSearchResult();
        
        Reporter.log("expected ------------------"+expected);
        Reporter.log("actual --------------------"+actual);
        Assert.assertEquals(actual, expected); 
	}
        
	@Test
	public void GIVEN_navigateToURL_WHEN_CorrectLogin_THEN_LoginSuccessful() throws IOException {


          inPage.userSignIn("abc11001@xyz.com", "abcxyz");
          
            boolean expected = true;
            boolean actual = homePage.verifyCorrectLogin().equals("abc xyz");
            
            Reporter.log("expected ------------------"+expected);
            Reporter.log("actual --------------------"+actual);
            Assert.assertEquals(actual, expected);
        }
	
	@Test
	public void GIVEN_navigateToURL_WHEN_InCorrectLogin_THEN_LoginUnSuccessful() throws IOException {


          inPage.userSignIn("abc11001@xyz.com", "abcxyz");
         

            
            boolean expected = true;
            boolean actual = inPage.verifyInCorrectLogin().equals("AUTHENTICATION");
            
            Reporter.log("expected to find the AUTHENTICATION error "+expected);
            Reporter.log("actual --------------------"+actual);
            Assert.assertEquals(actual, expected);
        }
	
	@Test
    public void GIVEN_navigateToURL_THEN_ExpectedTofail() {
        String expectedTitle = "My St";
        Reporter.log("expected ------------------"+expectedTitle);
        String actualTitle = landingPage.getTitle();
        
        
        Reporter.log("actual --------------------"+actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);   
        
	}
	
	@Parameters({"xyz"})
	@Test
    public void Use_Parameters_from_testng_XML_file(String xyz) {
		Reporter.log("This parameter comes from the testNG xml file: "+xyz);
	}
	
	@Test  
    public void Use_utilities() {
		String browserValue = landingPage.getDataConfigProperties("browser");
		Reporter.log("The browser we are using is "+browserValue);
	}
	
	@BeforeSuite
	public void setup() {
	    
		
	    
	}

	@AfterSuite
    public void cleanup() {
         
        //Instantiate SignInPage class object
        SignInPage inPage = new SignInPage();

        inPage.cleanUp();
        
 
    }   
	

}