
package testngListeners;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestRunner;
import org.testng.annotations.BeforeTest;

import com.mongodb.MapReduceCommand.OutputType;

import Assignments.driverSetup;
import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import pages.LandingPage;
import pages.SignInPage;
import frameworkclasses.Utilities;





public class TestNGlisteners extends driverSetup implements ITestListener 
{
	Utilities uts = new Utilities();

	

	
//	public String timereturn() {
//		
//	    LocalDateTime now = LocalDateTime.now(); 
//	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");  
//	    
//	    return dtf.format(now);
//	    		//System.out.println(dtf.format(now));  
//	}
//	

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 
		System.out.println("****** Test started: " + result.getName());
		
		try {
			uts.takeSnapShot("onTestStart"+uts.timereturn()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSuccess(ITestResult result) {

		// TODO Auto-generated method stub
		System.out.println("****** Test Success: " + result.getName());
		try {
			uts.takeSnapShot("onTestSuccess"+uts.timereturn()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailure(ITestResult result) {

		// TODO Auto-generated method stub
		System.out.println("****** Test Failure: " + result.getName());
		//onTestFailure(result);
		try {
			uts.takeSnapShot("onTestFailure"+uts.timereturn()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** Test skipped: " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** onTestFailedButWithinSuccessPercentage: " + result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("****** onTestFailedWithTimeout: " + result.getName());
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("****** onStart: ");
		try {
			uts.takeSnapShot("onStart.png"+uts.timereturn()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("****** onFinish: ");
		try {
			uts.takeSnapShot("onFinish.png");
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
