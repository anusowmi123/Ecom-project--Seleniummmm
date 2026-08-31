package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseMethods.baseMethods;
import DataProvider.LoginDataProvider;
import PageObject.HomePage;
import PageObject.loginPage;

public class loginTestCases extends baseMethods {
    HomePage homePage;
	loginPage loginTest; //POM 
	
	@Test (dataProviderClass = LoginDataProvider.class,
			dataProvider = "loginWithEmptyData",
			description = "Login with empty email and password")
public void emptyFieldsValidation(
		String TCID,
        String Category,
        String Scenario,
        String Email,
        String Password,
        String ExpectedMessage)	
	{
        HomePage homePage = new HomePage(driver);
		
		homePage.clickLoginLink();
		
		loginTest = new loginPage(driver);
		
		loginTest.clickLoginbtn();
	
		String actualEmailMsg = loginTest.EmptyFieldsValidation();
	
		Assert.assertEquals(actualEmailMsg,ExpectedMessage );
	
		System.out.println("TCID : " + TCID);
		System.out.println("Scenario : " + Scenario);
		System.out.println("Expected : " + ExpectedMessage);
		System.out.println("Actual : " + actualEmailMsg );
	}
	
	@Test( dataProviderClass = LoginDataProvider.class,
			dataProvider = "loginWithEmptyMail",
			description = "Login with empty email")
	public void emptyMaillogin(
			String TCID,
	        String Category,
	        String Scenario,
	        String Email,
	        String Password,
	        String ExpectedMessage
			) 
	{
        HomePage homePage = new HomePage(driver);
		
		homePage.clickLoginLink();
		
		loginTest = new loginPage(driver);
		
		loginTest.enterVaildMail(Email);
		loginTest.enterVaildPassword(Password);
		loginTest.clickLoginbtn();
		
		String[] actualmsg = loginTest.getEmailValidationMsg();
		Assert.assertEquals(actualmsg, "Login was unsuccessful. Please correct the errors and try again.");
		Assert.assertEquals(actualmsg, "The credentials provided are incorrect");
		
		System.out.println("TCID : " + TCID);
		System.out.println("Scenario : " + Scenario);
		System.out.println("Expected : " + ExpectedMessage);
		System.out.println("Actual : " + actualmsg );
	}
	
	@Test( dataProviderClass = LoginDataProvider.class,
			dataProvider = "loginWithEmptyPassword",
			description = "Login with empty password")
	public void emptyPasswordlogin(
			String TCID,
	        String Category,
	        String Scenario,
	        String Email,
	        String Password,
	        String ExpectedMessage
			) 
	{
        HomePage homePage = new HomePage(driver);
		
		homePage.clickLoginLink();
		
		loginTest = new loginPage(driver);
	
		loginTest.login(Email, Password);
		loginTest.clickLoginbtn();
		
		String actualmsg = loginTest.getForgotPasswordEmailMsg();
		Assert.assertEquals(actualmsg,ExpectedMessage);
		
		System.out.println("TCID : " + TCID);
		System.out.println("Scenario : " + Scenario);
		System.out.println("Expected : " + ExpectedMessage);
		System.out.println("Actual : " + actualmsg );
	}
	
		@Test (dataProviderClass = LoginDataProvider.class,
			dataProvider = "loginWithValidData",
			description = "Login with valid email and valid password")
	public void loginValidation(
			String TCID,
            String Category,
            String Scenario,
            String Email,
            String Password,
            String ExpectedMessage)  {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.clickLoginLink();
		
		loginTest = new loginPage(driver);
		
		loginTest.login(Email, Password);
		
		System.out.println("TCID : " + TCID);
	    System.out.println("Scenario : " + Scenario);
	    System.out.println("Login Success : " +loginTest );
	}
	
	
}
