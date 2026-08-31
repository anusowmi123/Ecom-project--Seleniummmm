package DataProvider;

import org.testng.annotations.DataProvider;
import Utilities.*; // using import because class is using another class method .


public class RegistrationTestDataProvider {
	
@DataProvider(name ="RegistrationPositiveData")	
 public static Object[][] readRegistrationPositiveData() {  
		return ExcelReader.getTestDataByTCID("src/test/java/Resourses/TestData.xlsx",
				"Registration_Positive_Test_Data","");
}		
		//getTestDataExcel-Method in that ExcelReader-Classs.We import from utilities package.
 


//@DataProvider(name ="RegistrationNegativeData")
//
//public static Object[][] readRegistrationNegativeData(){
//	
//	return ExcelReader.getTestDataByTCID("src/main/java/Utilities/TestData.xlsx","Registration_Negaitive_Test_Dat");
//}


@DataProvider(name = "FirstNameValidation")
public static Object[][] firstNameValidation() {
    return ExcelReader.getTestDataByTCID(
            "src/main/java/Utilities/TestData.xlsx",
            "Registration_Negaitive_Test_Dat",
            "REG_014");
}
@DataProvider(name = "lastNameValidation")
public static Object[][] lastNameValidation() {
	return ExcelReader.getTestDataByTCID(
			"src/main/java/Utilities/TestData.xlsx", 
			"Registration_Negaitive_Test_Dat", 
			"REG_019");	
}
@DataProvider(name="numericfirstname")
 public static Object[][]numericfirstname() {
	return ExcelReader.getTestDataByTCID("src/main/java/Utilities/TestData.xlsx", 
			"Registration_Negaitive_Test_Dat", 
			"REG_015");
	 
 }





}