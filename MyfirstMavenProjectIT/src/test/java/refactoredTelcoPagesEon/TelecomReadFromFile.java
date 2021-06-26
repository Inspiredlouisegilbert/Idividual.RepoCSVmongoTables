package refactoredTelcoPagesEon;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import pages.SignInPage;
import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Refactored.testsAssignment3;

public class TelecomReadFromFile extends BasePage{
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	testsAssignment3 clAssignment3 = new testsAssignment3();
	TelecomPayBilling clPayBilling = new TelecomPayBilling();
	
	String pURL = "http://demo.guru99.com/telecom/billing.php";

	public void navigatetourl()
	{
		driver.get(pURL);
	}
	
	public void readfromfile() {
		
	}
}