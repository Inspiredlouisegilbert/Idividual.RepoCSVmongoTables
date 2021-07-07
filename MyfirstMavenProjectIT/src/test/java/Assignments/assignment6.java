package Assignments;

import java.util.Scanner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.Reporter;

import frameworkclasses.ReusableFunctions;

public class assignment6 extends driverSetup{
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	assignment1 clAssignment1 = new assignment1();
	assignment2 clAssignment2 = new assignment2();
	
	int iTariffPlanExistsFlag = 0;
	
	int iHighestMonthlyRentalValue = 0;
	int iHighestLocalMinutesValue = 0;
	int iHighestInternationalMinutesValue = 0;
	int iHighestSMSPackValue = 0;
	int iHighestPerLocalMinutesChargesValue = 0;
	int iHighestPerInternationalMinutesChargesValue = 0;
	int iHighestPerSMSChargesValue = 0;
	
	int iLowestMonthlyRentalValue = -1;
	int iLowestLocalMinutesValue = -1;
	int iLowestInternationalMinutesValue = -1;
	int iLowestSMSPackValue = -1;
	int iLowestPerLocalMinutesChargesValue = -1;
	int iLowestPerInternationalMinutesChargesValue = -1;
	int iLowestPerSMSChargesValue = -1;
	
	public void GetTariffPlanTable() throws Exception {
		clAssignment1.Setup();
		//Initialize variables 
		String sTariffTable;
		
		//checks for active customer Tariff plans
		clAssignment2.submitCustomerID("Done");
		
		//Gets tariff plans table
		sTariffTable = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/table[1]")).getText();
		
		//For each line compare each variable and store the highest and lowest
		Scanner scanner = new Scanner(sTariffTable);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			//creates an Array
		  String[] line = scanner.nextLine().split(" "); 
		  
		  //MonthlyRental
		  int iTmp = Integer.parseInt(line[0]);
		  if (iTmp > iHighestMonthlyRentalValue) {
			  iHighestMonthlyRentalValue = iTmp;
			 }
		  if (iTmp < iLowestMonthlyRentalValue || iLowestMonthlyRentalValue == -1) {
				 iLowestMonthlyRentalValue = iTmp;
			 }
		  //LocalMinutes
		  iTmp = Integer.parseInt(line[1]);
		  if (iTmp > iHighestLocalMinutesValue) {
			  	iHighestLocalMinutesValue = iTmp;
			 }
		  if (iTmp < iLowestLocalMinutesValue || iLowestLocalMinutesValue == -1) {
			  	iLowestLocalMinutesValue = iTmp;
			 }
		  //InternationalMinutes
		  iTmp = Integer.parseInt(line[2]);
		  if (iTmp > iHighestInternationalMinutesValue) {
			  	iHighestInternationalMinutesValue = iTmp;
			 }
		  if (iTmp < iLowestInternationalMinutesValue || iLowestInternationalMinutesValue == -1) {
			  	iLowestInternationalMinutesValue = iTmp;
			 }
		  //SMSPack
		  iTmp = Integer.parseInt(line[3]);
		  if (iTmp > iHighestSMSPackValue) {
			  	iHighestSMSPackValue = iTmp;
			 }
		  if (iTmp < iLowestSMSPackValue || iLowestSMSPackValue == -1) {
			  	iLowestSMSPackValue = iTmp;
			 }
		  //PerLocalMinutesCharges
		  iTmp = Integer.parseInt(line[4]);
		  if (iTmp > iHighestPerLocalMinutesChargesValue) {
			  	iHighestPerLocalMinutesChargesValue = iTmp;
			 }
		  if (iTmp < iLowestPerLocalMinutesChargesValue || iLowestPerLocalMinutesChargesValue == -1) {
			  	iLowestPerLocalMinutesChargesValue = iTmp;
			 }
		  //PerInternationalMinutesCharges
		  iTmp = Integer.parseInt(line[5]);
		  if (iTmp > iHighestPerInternationalMinutesChargesValue) {
			  	iHighestPerInternationalMinutesChargesValue = iTmp;
			 }
		  if (iTmp < iLowestPerInternationalMinutesChargesValue || iLowestPerInternationalMinutesChargesValue == -1) {
			  	iLowestPerInternationalMinutesChargesValue = iTmp;
			 }
		  //PerSMSCharges
		  iTmp = Integer.parseInt(line[6]);
		  if (iTmp > iHighestPerSMSChargesValue) {
			  	iHighestPerSMSChargesValue = iTmp;
			 }
		  if (iTmp < iLowestPerSMSChargesValue || iLowestPerSMSChargesValue == -1) {
			  	iLowestPerSMSChargesValue = iTmp;
			 }
		}
		scanner.close();
		
		//Construct MaxValue Tariffplan
		String MaxValueString =  String.valueOf(iHighestMonthlyRentalValue) + " " + String.valueOf(iHighestLocalMinutesValue) + " " + String.valueOf(iHighestInternationalMinutesValue) + " " + String.valueOf(iHighestSMSPackValue) + " " + String.valueOf(iHighestPerLocalMinutesChargesValue) + " " + String.valueOf(iHighestPerInternationalMinutesChargesValue) + " " + String.valueOf(iHighestPerSMSChargesValue);
		
		//Creates new scanner to check if Tariff plan exists
		Scanner scanner2 = new Scanner(sTariffTable);
		while (scanner2.hasNextLine()) {
			String sline = scanner2.nextLine();
			
			if (sline.equals(MaxValueString)) {
			    iTariffPlanExistsFlag = 1;
			}
		}
		if (iTariffPlanExistsFlag == 1) {
			Reporter.log("Tariff Plan already exists!");
		}
		else {
			Reporter.log("Tariff Plan Added");
			AddTariffPlan();
		}
	}
	
	public void AddTariffPlan() throws Exception {
		clAssignment1.Setup();
		
		//click on add Tariff plan
		driver.findElement(By.linkText("Add Tariff Plan")).click();
		
		//populate Monthly Rental input field
		sfSelenium.populateInputField(By.cssSelector("#rental1"), Integer.toString(iHighestMonthlyRentalValue));
		//populate Free Local Minutes input field
		sfSelenium.populateInputField(By.cssSelector("#local_minutes"), Integer.toString(iHighestLocalMinutesValue));
		//populate Free International Minutes input field
		sfSelenium.populateInputField(By.cssSelector("#inter_minutes"), Integer.toString(iHighestInternationalMinutesValue));
		//populate Free SMS Pack input field
		sfSelenium.populateInputField(By.cssSelector("#sms_pack"), Integer.toString(iHighestSMSPackValue));
		//populate Local Per Minutes Charges input field
		sfSelenium.populateInputField(By.cssSelector("#minutes_charges"), Integer.toString(iHighestPerLocalMinutesChargesValue));
		//populate International Per Minutes Charges input field
		sfSelenium.populateInputField(By.cssSelector("#inter_charges"), Integer.toString(iHighestPerInternationalMinutesChargesValue));
		//populate SMS Per Charges input field
		sfSelenium.populateInputField(By.cssSelector("#sms_charges"), Integer.toString(iHighestPerSMSChargesValue));
		
		//click submit
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[36]/ul[1]/li[1]/input[1]")).click();
		
	}
}
