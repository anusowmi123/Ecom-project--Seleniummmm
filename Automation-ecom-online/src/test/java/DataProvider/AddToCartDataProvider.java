package DataProvider;

import org.testng.annotations.DataProvider;

import Utilities.ExcelReader;

public class AddToCartDataProvider {

	@DataProvider(name="addToCart")
	public Object[][] addToCart(){
		return ExcelReader.getTestDataByTCID(
				"src/test/java/Resourses/TestData.xlsx",
				"Add_To_Cart_Validation",
	            "AC_005");
	}
}
