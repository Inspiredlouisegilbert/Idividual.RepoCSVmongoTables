package telcoTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Assignments.assignment1;
import Assignments.assignment5;
import frameworkclasses.Utilities;

public class Assignment5Tests {
	// Instantiate class objects
	assignment1 clAssignment1 = new assignment1();
	assignment5 clAssignment5 = new assignment5();
	Utilities clUtilities = new Utilities();
	
	//instantiate variables
	String sFirstName = "valid";
	String sLastName = "name";
	String sEmail = "Valid@test.com";
	String sAddress = "37 Test Street Suburb";
	String sNumber = "0112223333";
	String sBackgroundCheck = "Done";
	
	String sInvalidFirstName = "!not valid!";
	String sInvalidLastName = "1not valid1";
	String sInvalidEmail = "Not@Valid";
	String sInvalidAddress = " ";
	String sInvalidNumber = "!not valid!";
	
	@Test
	public void test1() throws Exception {
		clAssignment5.CreateCustomerCSV(sInvalidFirstName, sInvalidLastName, sInvalidEmail, sInvalidAddress, sInvalidNumber, sBackgroundCheck);
		clAssignment5.AddCustomerFromCSV("invalid");
		clAssignment5.CreateCustomerCSV(sFirstName, sLastName, sEmail, sAddress, sNumber, sBackgroundCheck);
		clAssignment5.AddCustomerFromCSV("valid");
	}
}
