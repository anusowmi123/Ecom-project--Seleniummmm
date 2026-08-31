package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseMethods.baseMethods;
import DataProvider.RegistrationTestDataProvider;
import PageObject.HomePage;
import PageObject.RegistrationPage;

public class RegistrationNegativeTestCases extends baseMethods {

    RegistrationPage negativeRegister;
    HomePage homePage;

    @Test(dataProvider = "FirstNameValidation",
          dataProviderClass = RegistrationTestDataProvider.class,
          description = "Register with empty first name")

    public void verifyRegisterWithEmptyFirstName(

            String TCID,
            String Category,
            String TestScenario,
            String FirstName,
            String LastName,
            String Email,
            String Password,
            String ConfirmPassword,
            String ExpectedMessage) {

        // Initialize Page Objects AFTER browser is opened
        homePage = new HomePage(driver);
        negativeRegister = new RegistrationPage(driver);

        // Navigate to Registration Page
        homePage.clickRegister();

        // Enter Registration Details
        negativeRegister.selectFemale();
        negativeRegister.enterFirstName(FirstName);
        negativeRegister.enterLastName(LastName);
        negativeRegister.enterEmail(Email);
        negativeRegister.enterPassword(Password);
        negativeRegister.enterConfirmPassword(ConfirmPassword);

        // Click Register Button
        negativeRegister.clickRegisterBtn();

        // Validation for Register with empty first name
        
        String actualMessage = negativeRegister.getFirstNameErrorMsg(); 
       
        System.out.println("TCID : " + TCID);
        System.out.println("Category : " + Category);
        System.out.println("Scenario : " + TestScenario);
        System.out.println("Expected : " + ExpectedMessage);
        System.out.println("Actual   : " + actualMessage);
        Assert.assertEquals(actualMessage, ExpectedMessage);
    }  
    
 // Validate with Register with Register with numeric first name
    
   @Test(dataProvider ="numericfirstname" ,dataProviderClass = RegistrationTestDataProvider.class) 
    public void RegisterWithNumericFirstName(
    		
    		String TCID,
            String Category,
            String TestScenario,
            String FirstName,
            String LastName,
            String Email,
            String Password,
            String ConfirmPassword,
            String ExpectedMessage) {
	   
	// Initialize Page Objects AFTER browser is opened
       homePage = new HomePage(driver);
       negativeRegister = new RegistrationPage(driver);

       // Navigate to Registration Page
       homePage.clickRegister();
	   
	   negativeRegister.enterFirstName(FirstName);
	   negativeRegister.enterLastName(LastName);
	   negativeRegister.enterEmail(Email);
	   negativeRegister.enterPassword(Password);
	   negativeRegister.enterConfirmPassword(ConfirmPassword);
	   negativeRegister.clickRegisterBtn();
	   
	   String actualResult= negativeRegister.getFirstNameErrorMsg();
	   Assert.assertEquals(actualResult,ExpectedMessage);
	   System.out.println("TCID : " + TCID);
       System.out.println("Category : " + Category);
       System.out.println("Scenario : " + TestScenario);
       System.out.println("Expected : " + ExpectedMessage);
       System.out.println("Actual   : " + actualResult);
       Assert.assertEquals(actualResult, ExpectedMessage);
    	
    }  
// Validation for Register with empty Last name

    @Test(dataProvider = "lastNameValidation",
    	      dataProviderClass = RegistrationTestDataProvider.class,
    	      description = "Register with empty last name")

    	public void verifyRegisterWithEmptyLastName(

    		   String TCID,
    	        String Category,
    	        String TestScenario,
    	        String FirstName,
    	        String LastName,
    	        String Email,
    	        String Password,
    	        String ConfirmPassword,
    	        String ExpectedMessage) {
   
    	    // Initialize Page Objects AFTER browser is opened
    	    homePage = new HomePage(driver);
    	    negativeRegister = new RegistrationPage(driver);

    	    // Navigate to Registration Page
    	    homePage.clickRegister();

    	    // Enter Registration Details
    	    negativeRegister.selectFemale();
    	    negativeRegister.enterFirstName(FirstName);
    	    negativeRegister.enterLastName(LastName);
    	    negativeRegister.enterEmail(Email);
    	    negativeRegister.enterPassword(Password);
    	    negativeRegister.enterConfirmPassword(ConfirmPassword);

    	    // Click Register Button
    	    negativeRegister.clickRegisterBtn();

    	    // Validation for Register with empty last name
    	    String actualMessage = negativeRegister.getRegistrationSuccessMsg();
    	    negativeRegister.clickContinueBtn();
    	    
    	    System.out.println("TCID : " + TCID);
    	    System.out.println("Category : " + Category);
    	    System.out.println("Scenario : " + TestScenario);
    	    System.out.println("Expected : " + ExpectedMessage);
    	    System.out.println("Actual   : " + actualMessage);

    	    Assert.assertEquals(actualMessage, ExpectedMessage);
   } 
    
    	}
