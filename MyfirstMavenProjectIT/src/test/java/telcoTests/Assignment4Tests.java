package telcoTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Assignments.assignment1;
import Assignments.assignment2;
import Assignments.assignment3;
import frameworkclasses.Utilities;

public class Assignment4Tests {
	// Instantiate class objects
	assignment1 clAssignment1 = new assignment1();
	assignment3 clAssignment3 = new assignment3();
	Utilities clUtilities = new Utilities();
			
	@Test
	public void test1() throws Exception {
		clAssignment3.WHEN_submit_THEN_CustomerID_Displayed("CustomerID");
		clAssignment3.StoreBillingInfo();
	}
	
	@AfterTest
	public void CloseSelenium() throws Exception {
		clAssignment1.afterTest();
	}
}