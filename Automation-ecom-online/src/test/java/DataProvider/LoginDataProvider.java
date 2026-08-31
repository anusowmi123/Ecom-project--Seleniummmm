package DataProvider;

import org.testng.annotations.DataProvider;

import Utilities.ExcelReader;

public class LoginDataProvider {

	@DataProvider(name="loginWithValidData")
	public static  Object[][] loginWithValidData() {
		return ExcelReader.getTestDataByTCID("src/test/java/Resourses/TestData.xlsx","Login_Test_Data",
	            "LOG_001");
		}
	
	@DataProvider(name="loginWithEmptyMail")
	public static  Object[][] loginWithEmptyMail() {
		return ExcelReader.getTestDataByTCID("src/test/java/Resourses/TestData.xlsx","Login_Test_Data",
	            "LOG_004");
		}
	@DataProvider(name="loginWithEmptyPasswordl")
	public static  Object[][] loginWithEmptyPassword() {
		return ExcelReader.getTestDataByTCID("src/test/java/Resourses/TestData.xlsx","Login_Test_Data",
	            "LOG_005");
	
	}
	@DataProvider(name="loginWithEmptyData")
	public static  Object[][] loginWithEmptyData() {
		return ExcelReader.getTestDataByTCID("src/test/java/Resourses/TestData.xlsx","Login_Test_Data",
	            "LOG_006");
		
	}
}
