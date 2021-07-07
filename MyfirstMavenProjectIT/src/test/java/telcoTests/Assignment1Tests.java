package telcoTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignments.assignment1;
import Assignments.driverSetup;
import frameworkclasses.Utilities;

public class Assignment1Tests {
	// Instantiate class objects
	assignment1 clAssignment1 = new assignment1();
	Utilities clUtilities = new Utilities();
	
	@Test
	public void test1() throws Exception {
		clAssignment1.testFirst();
	}
	
	@Test
	public void test2() throws Exception {
		clAssignment1.testSecond();
	}
	
	@Test
	public void test3() throws Exception {
		clAssignment1.AddCustomer("Done");
	}	
}
