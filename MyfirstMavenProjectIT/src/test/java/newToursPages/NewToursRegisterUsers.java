package newToursPages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class NewToursRegisterUsers extends BasePage{
	
	String pURL = "http://demo.guru99.com/test/newtours/";
	String pURLLogin = "http://demo.guru99.com/test/newtours/login.php";
	String pPropertyKey = "MTlogin.csv";
	static SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	public void setup() {
		driver.get(pURL);
		sfSelenium.clickLink("Register here");
	}
	
	public void login() {
		driver.get(pURLLogin);
	}
	
	public String getProperties(String pPropertyKey) {
		//DATA CONFIG SETUP
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		try {
				p.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return p.getProperty(pPropertyKey);
	}
	
	public void runTestFromFile() throws IOException, InterruptedException {
	
		String pFname = "";
		String pLastname = "";
		String pPhone = "";
		String pEmail = "";
		String pAddress = "";
		String pCity = "";
		String pState = "";
		String pPostalCode = "";
		String pCountry = "";
		String pUsername = "";
		String pPassword = "";
		String PConfirmPassword = "";
		String mercurytoursnewusers = getProperties("MTlogin.csv"); 
		
		BufferedReader br = new BufferedReader(new FileReader(mercurytoursnewusers)); 
		String line;
		
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
				//SPECIFY SEPERATOR
			    String[] cols = line.split(";"); 
			    System.out.println("Firstname" + cols[0] + "Last name" + cols [1] + "Phone" + cols[2] + "Email" + cols[3] + "Address" + cols[4] + "City" + cols[5] + "State" + cols[6] + "Postalcode" + cols[7] + "Country" + cols[8] + "Username" + cols[9] + "Password" + cols[10]);	
			    //System.out.println(cols[1]);		//PASSWORD COLUMN
			    //System.out.println(cols[2]);		//OUTCOME COLUMN
			    
			    pFname = cols[0];
			    pLastname = cols[1];
			    pPhone = cols[2];
			    pEmail = cols[3];
			    pAddress = cols[4];
			    pCity = cols[5];
			    pState = cols[6];
			    pPostalCode = cols[7];
			    pCountry = cols[8];
			    pUsername = cols[9];
			    pPassword = cols[10];
			    PConfirmPassword = cols[11];
			    
			    captureUserDetailsCSV(pFname, pLastname, pPhone, pEmail, pAddress, pCity, pState, pPostalCode, pCountry, pUsername, pPassword, PConfirmPassword);
			    
			}
			
		} 
		// close the buffer
		br.close();
	}
	
	public void captureUserDetailsCSV(String pFname, String pLastname, String pPhone, String pEmail, String pAddress, String pCity, String pState, String pPostalCode, String pCountry, String pUsername, String pPassword, String pConfirmPassword) throws IOException, InterruptedException {
		// Capture UserName
		sfSelenium.populateInputField(By.name("firstName"), pFname);
		sfSelenium.populateInputField(By.name("lastName"), pLastname);
		sfSelenium.populateInputField(By.name("phone"), pPhone);
		sfSelenium.populateInputField(By.name("userName"), pEmail);
		sfSelenium.populateInputField(By.name("address1"), pAddress);
		sfSelenium.populateInputField(By.name("city"), pCity);
		sfSelenium.populateInputField(By.name("state"), pState);
		sfSelenium.populateInputField(By.name("postalCode"), pPostalCode);
		sfSelenium.populateInputField(By.name("country"), pCountry);
		sfSelenium.populateInputField(By.name("email"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		sfSelenium.populateInputField(By.name("confirmPassword"), pConfirmPassword);
		
		//CSS SELECTOR FOR SUBMIT BUTTON
		driver.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(17) td:nth-child(1) > input:nth-child(1)")).click();
		System.out.println("User has been successfully registered:" + pFname);
	}
	
	public void captureUserDetailsOne() {
		String pFname = "Polela";
		String pLastname = "Last name";
		String pPhone = "0112345678";
		String pEmail = "polela@gmail.com";
		String pAddress = "polela address";
		String pCity = "Moscow";
		String pState = "State";
		String pPostalCode = "1709";
		String pCountry = "RUSSIA";
		String pUsername = "polela@gmail.com";
		String pPassword = "P@ssword";
		String PConfirmPassword = "P@ssword";
		
		sfSelenium.populateInputField(By.name("firstName"), pFname);
		sfSelenium.populateInputField(By.name("lastName"), pLastname);
		sfSelenium.populateInputField(By.name("phone"), pPhone);
		sfSelenium.populateInputField(By.name("userName"), pEmail);
		sfSelenium.populateInputField(By.name("address1"), pAddress);
		sfSelenium.populateInputField(By.name("city"), pCity);
		sfSelenium.populateInputField(By.name("state"), pState);
		sfSelenium.populateInputField(By.name("postalCode"), pPostalCode);
		sfSelenium.populateInputField(By.name("country"), pCountry);
		sfSelenium.populateInputField(By.name("email"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		sfSelenium.populateInputField(By.name("confirmPassword"), PConfirmPassword);
		
		//CSS SELECTOR FOR SUBMIT BUTTON
		driver.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(17) td:nth-child(1) > input:nth-child(1)")).click();
		System.out.println("User has been successfully registered: " + pFname);
		setup();
	}
	
	public void captureUserDetailsTwo() {
		String pFname = "Faith";
		String pLastname = "Last name";
		String pPhone = "0112345678";
		String pEmail = "faith@gmail.com";
		String pAddress = "faith address";
		String pCity = "Barcelona";
		String pState = "State";
		String pPostalCode = "1709";
		String pCountry = "SPAIN";
		String pUsername = "faith@gmail.com";
		String pPassword = "P@ssword";
		String PConfirmPassword = "P@ssword";
		
		sfSelenium.populateInputField(By.name("firstName"), pFname);
		sfSelenium.populateInputField(By.name("lastName"), pLastname);
		sfSelenium.populateInputField(By.name("phone"), pPhone);
		sfSelenium.populateInputField(By.name("userName"), pEmail);
		sfSelenium.populateInputField(By.name("address1"), pAddress);
		sfSelenium.populateInputField(By.name("city"), pCity);
		sfSelenium.populateInputField(By.name("state"), pState);
		sfSelenium.populateInputField(By.name("postalCode"), pPostalCode);
		sfSelenium.populateInputField(By.name("country"), pCountry);
		sfSelenium.populateInputField(By.name("email"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		sfSelenium.populateInputField(By.name("confirmPassword"), PConfirmPassword);
		
		//CSS SELECTOR FOR SUBMIT BUTTON
		driver.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(17) td:nth-child(1) > input:nth-child(1)")).click();
		System.out.println("User has been successfully registered: " + pFname);
		setup();
	}
	
	public void captureUserDetailsThree() {
		String pFname = "Mvuyo";
		String pLastname = "Last name";
		String pPhone = "0112345678";
		String pEmail = "mvuyo@gmail.com";
		String pAddress = "mvuyo address";
		String pCity = "Rome";
		String pState = "State";
		String pPostalCode = "1709";
		String pCountry = "ITALY";
		String pUsername = "mvuyo@gmail.com";
		String pPassword = "P@ssword";
		String PConfirmPassword = "P@ssword";
		
		sfSelenium.populateInputField(By.name("firstName"), pFname);
		sfSelenium.populateInputField(By.name("lastName"), pLastname);
		sfSelenium.populateInputField(By.name("phone"), pPhone);
		sfSelenium.populateInputField(By.name("userName"), pEmail);
		sfSelenium.populateInputField(By.name("address1"), pAddress);
		sfSelenium.populateInputField(By.name("city"), pCity);
		sfSelenium.populateInputField(By.name("state"), pState);
		sfSelenium.populateInputField(By.name("postalCode"), pPostalCode);
		sfSelenium.populateInputField(By.name("country"), pCountry);
		sfSelenium.populateInputField(By.name("email"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		sfSelenium.populateInputField(By.name("confirmPassword"), PConfirmPassword);
		
		//CSS SELECTOR FOR SUBMIT BUTTON
		driver.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(17) td:nth-child(1) > input:nth-child(1)")).click();
		System.out.println("User has been successfully registered: " + pFname);
		setup();
	}
	
	public void captureUserDetailsFour() {
		String pFname = "Junaid";
		String pLastname = "Last name";
		String pPhone = "0112345678";
		String pEmail = "junaid@gmail.com";
		String pAddress = "junaid address";
		String pCity = "Rio";
		String pState = "State";
		String pPostalCode = "1709";
		String pCountry = "BRAZIL";
		String pUsername = "junaid@gmail.com";
		String pPassword = "P@ssword";
		String PConfirmPassword = "P@ssword";
		
		sfSelenium.populateInputField(By.name("firstName"), pFname);
		sfSelenium.populateInputField(By.name("lastName"), pLastname);
		sfSelenium.populateInputField(By.name("phone"), pPhone);
		sfSelenium.populateInputField(By.name("userName"), pEmail);
		sfSelenium.populateInputField(By.name("address1"), pAddress);
		sfSelenium.populateInputField(By.name("city"), pCity);
		sfSelenium.populateInputField(By.name("state"), pState);
		sfSelenium.populateInputField(By.name("postalCode"), pPostalCode);
		sfSelenium.populateInputField(By.name("country"), pCountry);
		sfSelenium.populateInputField(By.name("email"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		sfSelenium.populateInputField(By.name("confirmPassword"), PConfirmPassword);
		
		//CSS SELECTOR FOR SUBMIT BUTTON
		driver.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(17) td:nth-child(1) > input:nth-child(1)")).click();
		System.out.println("User has been successfully registered: " + pFname);
	}
	
	public void Logins() {
		login();
		String pUserOne = "polela@gmail.com";
		String pUserTwo = "faith@gmail.com";
		String pUserThree = "mvuyo@gmail.com";
		String pUserFour = "junaid@gmail.com";
		String pPassword = "P@ssword";
		
		sfSelenium.populateInputField(By.name("userName"), pUserOne);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		System.out.println("Registered user has successfully logged on: " + pUserOne);
		sfSelenium.clickLink("SIGN-OFF");
		sfSelenium.clickLink("SIGN-ON");
		
		sfSelenium.populateInputField(By.name("userName"), pUserTwo);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		System.out.println("Registered user has successfully logged on: " + pUserTwo);
		sfSelenium.clickLink("SIGN-OFF");
		sfSelenium.clickLink("SIGN-ON");
		
		sfSelenium.populateInputField(By.name("userName"), pUserThree);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		System.out.println("Registered user has successfully logged on: " + pUserThree);
		sfSelenium.clickLink("SIGN-OFF");
		sfSelenium.clickLink("SIGN-ON");
		
		sfSelenium.populateInputField(By.name("userName"), pUserFour);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		System.out.println("Registered user has successfully logged on: " + pUserFour);
		sfSelenium.clickLink("SIGN-OFF");
		sfSelenium.clickLink("SIGN-ON");
	}
	
	public void InvalidLogin() {
		String pUsername = "polela@gmail.comm";		//INVALID EMAIL ADDRESS
		String pPassword = "P@ssword";
		boolean eleDisplayed;
		
		login();
		sfSelenium.populateInputField(By.name("userName"), pUsername);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		//ASSERT THAT TEXT IS VISIBLE
		eleDisplayed = driver.findElement(By.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(2) td:nth-child(2) > span:nth-child(3)")).isDisplayed();
		System.out.println("Assertion: Enter your userName and password correc text is visible: " + eleDisplayed);
	}
	
	public void BookFlightsOne () {
		login();
		String pUser = "polela@gmail.com";
		String pPassword = "P@ssword";
		String sPasscount = "2";
		String sFromPort = "New York";
		String sFromMonth = "July";
		String sFromDay = "14";
		String sToPort = "London";
		String sToMonth = "July";
		String sToDay = "28";
		String sPrefAirline = "Unified Airlines";
		String sFlightType = "'Business'";
		
		sfSelenium.populateInputField(By.name("userName"), pUser);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		//BOOK FLIGHTS
		sfSelenium.clickLink("Flights");
		driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']")).click();
		sfSelenium.populateDropDown("passCount", sPasscount);
		sfSelenium.populateDropDown("fromPort", sFromPort);
		sfSelenium.populateDropDown("fromMonth", sFromMonth);
		sfSelenium.populateDropDown("fromDay", sFromDay);
		sfSelenium.populateDropDown("toPort", sToPort);
		sfSelenium.populateDropDown("toMonth", sToMonth);
		sfSelenium.populateDropDown("toDay", sToDay);
		driver.findElement(By.xpath("//input[@name='servClass' and @value=" + sFlightType + "]")).click();
		sfSelenium.populateDropDown("airline", sPrefAirline);
		driver.findElement(By.name("findFlights")).click();
	}
	
	public void BookFlightsTwo () {
		login();
		String pUser = "polela@gmail.com";
		String pPassword = "P@ssword";
		String sPasscount = "2";
		String sFromPort = "London";
		String sFromMonth = "July";
		String sFromDay = "21";
		String sToPort = "Paris";
		String sToMonth = "August";
		String sToDay = "18";
		String sPrefAirline = "Unified Airlines";
		String sFlightType = "'Business'";
		
		sfSelenium.populateInputField(By.name("userName"), pUser);
		sfSelenium.populateInputField(By.name("password"), pPassword);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		
		//BOOK FLIGHTS
		sfSelenium.clickLink("Flights");
		driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']")).click();
		sfSelenium.populateDropDown("passCount", sPasscount);
		sfSelenium.populateDropDown("fromPort", sFromPort);
		sfSelenium.populateDropDown("fromMonth", sFromMonth);
		sfSelenium.populateDropDown("fromDay", sFromDay);
		sfSelenium.populateDropDown("toPort", sToPort);
		sfSelenium.populateDropDown("toMonth", sToMonth);
		sfSelenium.populateDropDown("toDay", sToDay);
		driver.findElement(By.xpath("//input[@name='servClass' and @value=" + sFlightType + "]")).click();
		sfSelenium.populateDropDown("airline", sPrefAirline);
		driver.findElement(By.name("findFlights")).click();
	}
}