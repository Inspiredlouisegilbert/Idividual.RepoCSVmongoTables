package DataProviders;

import org.testng.annotations.DataProvider;

public class DemoDataProviders {
	
    @DataProvider(name="SearchProviderClass")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99 Class", "India Class","lkjl" },
            { "Krishna Class", "UK Class","jkjhk" },
            { "Bhupesh Class", "USA Class","jgjhgjgh" }
        };
    }
    
    @DataProvider(name="SearchProviderDifferentClass")
    public Object[][] getDataFromDataproviderDifferent(){
    return new Object[][] 
    	{
            { "an Apple Class"},
            { "a Banana Class"},
            { "a bunch of Grapes Class"}
        };
    }
}