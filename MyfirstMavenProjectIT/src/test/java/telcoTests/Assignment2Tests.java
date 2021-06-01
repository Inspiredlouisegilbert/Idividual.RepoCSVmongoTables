package telcoTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignments.assignment1;
import Assignments.assignment2;
import Assignments.driverSetup;

public class Assignment2Tests {
	
	driverSetup clDriverSetup = new driverSetup();
	assignment1 clAssignment1 = new assignment1();
	assignment2 clAssignment2 = new assignment2();
		
	//instantiate variables
	String pURL = "http://demo.guru99.com/telecom/index.html";
	
	@BeforeTest
    public void NavigateToURL() throws Exception {
         clAssignment1.Setup(pURL);
	}
	
	@Test
	public void test1() throws Exception {
		clAssignment1.testThird("Done");
	}
	
	@Test
	public void test2() throws Exception {
		clAssignment2.testSecond();
	}
	
	@Test
	public void test3() throws Exception {
	}
	
	@AfterTest
	public void CloseSelenium() throws Exception {
		clAssignment2.afterTest();
	}
}
