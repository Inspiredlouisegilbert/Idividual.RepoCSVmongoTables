package assessmentTests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import assessmentPages.AssessmentReadFromFile;
import assessmentPages.AssessmentUtilities;
import assessmentPages.assessmentLandingPage;
import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;


public class testsAssessmentReadFromFile {
	
	// Declare an object of classes and instantiate class objects
	AssessmentReadFromFile readFromFile = new AssessmentReadFromFile();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	String pURL = "https://www.geewiz.co.za/";
	
//	@Test (priority=1)
//    public void aUse_utilities() {
//		String browserValue = clUtilities.getDataConfigProperties("browser");
//		Reporter.log("aaaaThe browser we are using is "+browserValue);
//	}
	
	  @Test
	  public void Readfromfile() throws InterruptedException, IOException
	  {
		  readFromFile.navigatetourl();
		  readFromFile.readfromfile();
		  readFromFile.submit();
		  readFromFile.getcarttotal();
	  }

	  @AfterTest
	  public void afterTest() throws IOException {
		  sfSelenium.CloseSelenium();
	  }
	}