package newToursTests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import newToursPages.NewToursRegisterUsers;
import refactoredTelcoPagesEon.TelecomAddCustomer;

public class testsNewToursRegister {

	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	NewToursRegisterUsers clRegister = new NewToursRegisterUsers();
	String pURL = "http://demo.guru99.com/test/newtours/";
	
	@Test
	public void GIVEN_RegisterNewUser_THEN_SaveDetails() throws InterruptedException, IOException
	{
		clRegister.setup();
		clRegister.runTestFromFile();
		clRegister.captureUserDetailsOne();
		clRegister.captureUserDetailsTwo();
		clRegister.captureUserDetailsThree();
		clRegister.captureUserDetailsFour();
		System.out.println("All users has been successfully registered"); 
	}
	
	@Test
	public void GIVEN_Registered_THEN_Login() throws InterruptedException, IOException
	{
		clRegister.Logins();
		System.out.println("All registered users has successfully logged on");
	}
	
	@Test
	public void GIVEN_InvalidDetails_WHEN_LogginIn_THEN_PromptWithErrorMessage() throws InterruptedException, IOException
	{
		clRegister.InvalidLogin();
		System.out.println("Invalid login test passed");
	}
	
	@Test
	public void GIVEN_RegisteredUsers_WHEN_LoggedOn_THEN_BookFlights() throws InterruptedException, IOException
	{
		clRegister.BookFlightsOne();
		System.out.println("Flights from New York to London has been booked successfully");
		clRegister.BookFlightsTwo();
		System.out.println("Flights from London to Paris has been bokked successfully");
	}
	
  @AfterTest
  public void afterTest() throws Exception {
	  sfSelenium.CloseSelenium();
  }
}