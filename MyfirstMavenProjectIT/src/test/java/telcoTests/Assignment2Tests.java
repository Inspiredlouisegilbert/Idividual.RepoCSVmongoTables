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

	@Test
	public void test1() throws Exception {
		clAssignment2.submitCustomerID("Done");
	}
	
	@Test
	public void test2() throws Exception {
		clAssignment2.submitCustomerID("Pending");
	}
	
	@Test
	public void test3() throws Exception {
		clAssignment2.submitCustomerID("Done");
	}
	
	@Test
	public void test4() throws Exception {
		clAssignment2.CheckForTariffPlan("Done");
	}
	
	@AfterTest
	public void CloseSelenium() throws Exception {
		clAssignment2.afterTest();
	}
}
