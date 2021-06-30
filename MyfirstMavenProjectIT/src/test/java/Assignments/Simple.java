package covidRelatedTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import CovidPage.HomePage;
import CovidPage.Introduction;
import CovidPage.PatientDetails;
import CovidPage.Results;
import CovidPage.Symptoms;
import CovidPage.TermsAndConditions;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Simple {
	//instantiate needed pages
	HomePage newHomePage = new HomePage();
	PatientDetails newPatientDetails = new PatientDetails();
	Symptoms newSymptoms = new Symptoms();
	Results newResults = new Results();
	Introduction newIntroduction = new Introduction();
	TermsAndConditions newTermsAndConditions = new TermsAndConditions();
	
	//@Test
	public void GIVEN_age70_AND_genderMale_AND_userNavigatedtoCovidCheckLanding_WHEN_userEntersDetails_THEN_HeIsAskedtoGoToHospital() throws InterruptedException {
		//Given	User open browsed to Symptomate
		String  actualHomeButton =  newHomePage.checkStartCheckup();
		String expectedHomeButton = "COVID-19 checkup";
		
		Assert.assertEquals(actualHomeButton, expectedHomeButton);
		
		Reporter.log("expected ------------------"+expectedHomeButton);
        Reporter.log("actual --------------------"+actualHomeButton);
		
	}
	
	//@Test(dataProvider="SearchProvider")
    public void testMethod(String author,String searchKey) throws InterruptedException{
    {
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
    }
    }
	
	//@Test(dataProvider="SearchProviderDifferent")
    public void testMethodDifferentData(String GreenGrocer) throws InterruptedException{
    {
        System.out.println("Would you like "+ GreenGrocer);
    }
    }
	
	//@Test(dataProvider="SearchProviderClass", dataProviderClass=dataProviders.DemoDataProviders.class)
    public void testMethodClass(String author,String searchKey, String aa) throws InterruptedException{
    {
        System.out.println("Welcome ->"+author+" Your search key is->"+aa);
    }
    }
	
	//@Test(dataProvider="SearchProviderDifferentClass", dataProviderClass=dataProviders.DemoDataProviders.class)
    public void testMethodDifferentDataClass(String GreenGrocer) throws InterruptedException{
    {
        System.out.println("Would you like "+ GreenGrocer);
    }
    }
	
	
	
	
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };
    }
    
    @DataProvider(name="SearchProviderDifferent")
    public Object[][] getDataFromDataproviderDifferent(){
    return new Object[][] 
    	{
            { "an Apple"},
            { "a Banana"},
            { "a bunch of Grapes"}
        };
    }
    
    
  
    @DataProvider(name ="excel-data")

    public Object[][] excelDP() throws IOException{

            //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
    		// Get the directory where the excel file is placed
    		String excelDirectory = newHomePage.getDataConfigProperties("xlsDir");
            Object[][] arrObj = getExcelData(excelDirectory+"registerAndLogin.xlsx","Sheet1");

            return arrObj;

    }

    
    public String[][] getExcelData(String fileName, String sheetName){
            String[][] data = null;     
   try
        {
	   /*Java FileInputStream class obtains input bytes from a file. 
	    * It is used for reading byte-oriented data (streams of raw bytes) such as image data, 
	    * audio, video etc. You can also read character-stream data. But, f
	    * or reading streams of characters, it is recommended to use FileReader class.
	    */
        FileInputStream fis = new FileInputStream(fileName);
        /*High level representation of a SpreadsheetML workbook. 
         * This is the first object most users will construct whether 
         * they are reading or writing a workbook. 
         * It is also the top level object for creating new sheets/etc.
         */
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheet(sheetName);
        XSSFRow row = sh.getRow(0);
        int noOfRows = sh.getPhysicalNumberOfRows();
        int noOfCols = row.getLastCellNum();
        //High level representation of a cell in a row of a spreadsheet.
        XSSFCell cell;

        data = new String[noOfRows-1][noOfCols];
        for(int i =1; i<noOfRows;i++){

             for(int j=0;j<noOfCols;j++){
                   row = sh.getRow(i);
                   cell= row.getCell(j);

                   data[i-1][j] = cell.getStringCellValue();
                   //System.out.println(data[i-1][j]);
                   
                 

               }

        }

        }

        catch (Exception e) {

               System.out.println("The exception is: " +e.getMessage());

            }

            return data;

    }
    
  
    @Test(dataProvider ="excel-data")

    public void search(String keyWord1, String keyWord2,String keyWord3, String keyWord4){

            System.out.println(keyWord1 +" "+ keyWord2 +" "+ keyWord3 +" "+ keyWord4);

    }
    
	
	
//	@AfterTest
//	public void CleanUp()
//	{
//		newHomePage.org.openqa.selenium.NoSuchSessionException: invalid session id
//	}
}
