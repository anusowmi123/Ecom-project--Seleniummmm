package DataProvider;

import org.testng.annotations.DataProvider;

import Utilities.ExcelReader;

public class CheckoutAddressDataProvider  {
	
	@DataProvider (name="CheckoutAddress")
	public Object[][]CheckoutAddress(){
		return ExcelReader.getTestDataByTCID("src/test/java/Resourses/TestData.xlsx","Billing_Address_TestData",
	            "BILL_001");
		
		
	}

}
