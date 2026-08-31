package Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import BaseMethods.baseMethods;
import DataProvider.RegistrationTestDataProvider;
import PageObject.HomePage;
import PageObject.RegistrationPage;

public class RegisterTestCases extends baseMethods {
	
	@Test(  dataProviderClass = RegistrationTestDataProvider.class,   // Link the test to the data provider name AND specify the class where it lives
			dataProvider = "RegistrationPositiveData", // name 
			description =" TC001 Register with valied Data ")
	
	public void register(
			String TCID ,        //String firstName = ExcelReader.getCellData(...);
			String Category,
			String TestScenario ,
			String FirstName ,
			String LastName,
			String Email,
			String Password, 
			String ConfirmPassword,
			String ExpectedResult){		
	   	
		HomePage Reglnk= new HomePage(driver);  //dependency from HomePage object(POM)
		Reglnk.clickRegister();
		System.out.println("clicked:"+Reglnk);
		
		String Reglnk1 = driver.getCurrentUrl();
		System.out.println("Get Current Url:" + Reglnk1);	
	
        try {
        	
            RegistrationPage register = new RegistrationPage(driver); 	 //dependency from Registration Page object(POM) 
            System.out.println("RegistrationPage Object Created");
            
            register.selectFemale();
            
            register.enterFirstName(FirstName);
            System.out.println("First Name Entered");

            register.enterLastName(LastName);
            System.out.println("Last Name Entered");

            register.enterEmail(Email);
            System.out.println("Email Entered");

            register.enterPassword(Password);
            System.out.println("Password Entered");

            register.enterConfirmPassword(ConfirmPassword);
            System.out.println("Confirm Password Entered");

            register.clickRegisterBtn();
            System.out.println("Register Button Clicked");

            String actualResult=register.getRegistrationSuccessMsg();
        	Assert.assertEquals(actualResult, ExpectedResult,"Registration Success message mismatch");
        	register.clickContinueBtn();
           	  
        } catch (Exception e) {

            System.out.println("==================================");
            System.out.println("ERROR OCCURRED");
            System.out.println("Exception Type : " + e.getClass().getName());
            System.out.println("Message : " + e.getMessage());
            e.printStackTrace();
            System.out.println("==================================");
        }
	
		
	//	Registration Success message
 
 




	}
}

