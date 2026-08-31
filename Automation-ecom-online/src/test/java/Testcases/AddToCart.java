package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseMethods.baseMethods;
import DataProvider.AddToCartDataProvider;
import PageObject.AddToCartPage;
import PageObject.HomePage;
import PageObject.loginPage;

public class AddToCart extends baseMethods {

	HomePage homePage;
	AddToCartPage addToCart; 

	@Test(dataProvider ="addToCart",dataProviderClass = AddToCartDataProvider.class)
	public void AddToCardFlow(
			String TCID,
			String Category,
			String Scenario,
			String Name,
			String Email,
			String ExpectedMessage) {

// Page object Model   
		HomePage homePage = new HomePage(driver);
		AddToCartPage addToCart = new AddToCartPage(driver);
		loginPage loginTest = new loginPage(driver);
		
//Click login in Home screen
		homePage.clickLoginLink();
		
// Enter login credentials
		loginTest.enterVaildMail("john123@test123.com");
		loginTest.enterVaildPassword("Password@123");
		loginTest.clickLoginbtn();
		
// add to cart in homescreen 
		
		System.out.println("Current URL : " + driver.getCurrentUrl());
		
		homePage.clickAddToCartHomeScreen();

//view product in full screen 
		
		System.out.println("Current URL  : " + driver.getCurrentUrl());
		
		
		// Enter details
				addToCart.EnterRecipientName(Name);
				addToCart.EnterRecipientMail(Email);
		// Set quantity to 5
				addToCart.enterQuantity("5");
				addToCart.getCartQuantity();
				
		SoftAssert softAssert1 = new SoftAssert();
		softAssert1.assertEquals(addToCart.getCartQuantity(), "5",
		        "Cart quantity validation failed");
		
		// click add to card 
		
		addToCart.clickAddToCartFullScreenBtn();
		
		SoftAssert softAssert2 = new SoftAssert();
		softAssert2.assertEquals(addToCart.getSuccessMessage(), ExpectedMessage,
		        "Success message validation failed");
		
		System.out.println("Current URL : " + driver.getCurrentUrl());
		System.out.println("Title : " + driver.getTitle());

		System.out.println("Recipient Name Displayed : "
		        + driver.findElement(By.id("giftcard_2_RecipientName")).isDisplayed());

		
		
// click shopping list in home screen 	
		

		softAssert1.assertAll();
		softAssert2.assertAll();
		
		System.out.println("TCID : " + TCID);
		System.out.println("Scenario : " + Scenario);
		System.out.println("Recipient Name : " + Name);
		System.out.println("Recipient Email: " + Email);
		System.out.println("Quantity: " + addToCart.getCartQuantity());
		System.out.println("Success Message: " +addToCart.getSuccessMessage() );

	}

}
