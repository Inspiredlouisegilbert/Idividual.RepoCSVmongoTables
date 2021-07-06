package telcoTests;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Assignments.assignment1;
import Assignments.assignment2;
import Assignments.assignment6;
import frameworkclasses.Utilities;

public class Assignment6Tests {
	// Instantiate class objects
		assignment1 clAssignment1 = new assignment1();
		assignment2 clAssignment2 = new assignment2();
		assignment6 clAssignment6 = new assignment6();
		Utilities clUtilities = new Utilities();
				
		@Test
		public void test1() throws Exception {
			clAssignment6.GetTariffPlanTable();
		}
		
		@AfterTest
		public void CloseSelenium() throws Exception {
			clAssignment1.afterTest();
		}
}
