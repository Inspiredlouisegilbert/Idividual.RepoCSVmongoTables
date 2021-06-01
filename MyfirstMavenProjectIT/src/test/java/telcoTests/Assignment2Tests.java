package telcoTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignments.assignment1;
import Assignments.assignment2;
import Assignments.driverSetup;
import frameworkclasses.Utilities;

public class Assignment2Tests {
	
	driverSetup clDriverSetup = new driverSetup();
	assignment1 clAssignment1 = new assignment1();
	assignment2 clAssignment2 = new assignment2();
	Utilities clUtilities = new Utilities();
		
	//instantiate variables
	String pURL = "http://demo.guru99.com/telecom/index.html";
	
	@BeforeTest
    public void NavigateToURL() throws Exception {
         clAssignment1.Setup(pURL);
	}
	
	@Test
	public void test1() throws Exception {
		clAssignment1.testThird("Done");
		clAssignment1.Setup(pURL);
		clAssignment2.submitCustomerID("Done");
	}
	
	@Test
	public void test2() throws Exception {
		clAssignment1.testThird("Pending");
		clAssignment1.Setup(pURL);
		clAssignment2.submitCustomerID("Pending");
	}
	
	@Test
	public void test3() throws Exception {
		clAssignment1.Setup(pURL);
		clAssignment1.testThird("Done");
		clAssignment1.Setup(pURL);
		clAssignment2.submitCustomerID("Done");
		clAssignment2.CheckForTariffPlan();
	}
	
	@AfterTest
	public void CloseSelenium() throws Exception {
		clAssignment2.afterTest();
	}
}
