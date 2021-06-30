package Assignments;

import java.util.Scanner;

import org.openqa.selenium.By;

import frameworkclasses.ReusableFunctions;

public class assignment6 extends driverSetup{
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	assignment1 clAssignment1 = new assignment1();
	assignment2 clAssignment2 = new assignment2();
	
	public void GetTariffPlanTable() throws Exception {
		//Initialize variables 
		String TariffTable;
		
		//checks for active customer Tariff plans
		clAssignment2.submitCustomerID("Done");
		
		//Gets tariff plans table
		TariffTable = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/table[1]")).getText();
		
		//For each line 
//		Scanner scanner = new Scanner(TariffTable);
//		for (int i = 0; i < 5; i++) {
//			scanner.nextLine();
//		}
//		while (scanner.hasNextLine()) {
//		  String line = scanner.nextLine();
//		  System.out.println(line);
//		}
//		scanner.close();
		System.out.println("------------------------------------------------------");
		System.out.println(TariffTable);
	}
}
