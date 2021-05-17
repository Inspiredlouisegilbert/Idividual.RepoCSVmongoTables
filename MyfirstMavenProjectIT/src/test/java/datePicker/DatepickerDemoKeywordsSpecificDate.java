package datePicker;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
//import writeToFile.WriteToFile;

public class DatepickerDemoKeywordsSpecificDate {
	
	// Selenium Functions 
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	//String pURL = "http://demo.guru99.com/test/table.html";
	String pURL = "https://demos.telerik.com/kendo-ui/datetimepicker/index";

	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
	}
	
	
	///// Run tests /////
	@BeforeTest
	public void runTestStart () {
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		//start the test
		// Set up the report
		sfSelenium.startReport("Payment Gateway Project", "Playing with the date picker");
		sfSelenium.createTest("Start Test");
	}
	
	@Test
	public void datepickerr() throws IOException, InterruptedException {
		
        //Date and Time to be set in textbox

        String dateTime ="12/07/2035 8:00 PM";

        //String dateTime ="12/07/2019 8:00 PM";
//        12
//        07
//        2035
//        8:00
//        PM
//        
   
        //button to open calendar
		sfSelenium.createTest("Run Test: DatePicker");
		navigateToURL(pURL);
		
		
		WebElement selectDate = driver.
				findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
		selectDate.click();
	 
	    WebElement nextLink = driver.
	    		findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));

	    //button to click in center of calendar header

	    WebElement midLink = driver.
	    		findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));

	    //button to move previous month in calendar

	    WebElement previousLink = driver.
	    		findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]")); 

	        //Split the date time to get only the date part
	        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");

	        //get the year difference between current year and year to set in calander

	        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);

	        midLink.click();

	        if(yearDiff!=0){

	            //if you have to move next year

	            if(yearDiff>0){

	                for(int i=0;i< yearDiff;i++){

	                    System.out.println("Year Diff->"+i);

	                    nextLink.click();

	                }

	            }

	            //if you have to move previous year

	            else if(yearDiff<0){

	                for(int i=0;i< (yearDiff*(-1));i++){

	                    System.out.println("Year Diff->"+i);

	                    previousLink.click();

	                }

	            }

	        }
	        
	        Thread.sleep(1000);

	        //Get all months from calendar to select correct one
	      //ts-monthpicker[2]

	        List<WebElement> list_AllMonthToBook = driver.
	        		findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
	        
	        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
	        
	        Thread.sleep(1000);

	        //get all dates from calendar to select correct one

	        List<WebElement> list_AllDateToBook = driver.findElements(By.
	        		xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
	        
	        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
	        
	        ///FOR TIME

	        WebElement selectTime = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));

	        //click time picker button
	        

	        selectTime.click();

	        //get list of times

	        List<WebElement> allTime = driver.findElements(By.
	        		xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
	      
	        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];

	     //select correct time

	        for (WebElement webElement : allTime) {

	            if(webElement.getText().equalsIgnoreCase(dateTime))

	            {

	                webElement.click();

	            }

	        }


		//}
		//Assert.assertEquals(expected, actual)
		
		sfSelenium.logScreenShot();	
	}

	@AfterTest
	public void cleanup () throws IOException, InterruptedException {
		sfSelenium.createTest("Run Test: clean up");
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		sfSelenium.CloseSelenium();	
		//
	}

	
}

