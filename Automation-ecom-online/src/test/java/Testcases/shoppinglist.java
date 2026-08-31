package Testcases;




import org.testng.annotations.Test;

import BaseMethods.baseMethods;

import PageObject.HomePage;
import PageObject.ShoppingListPage;
import PageObject.loginPage;

public class shoppinglist extends baseMethods{


	@Test

	public void DisplayProductList(){

// Page object Model   

		HomePage homePage = new HomePage(driver);
		loginPage loginTest = new loginPage(driver);
		ShoppingListPage cart =new ShoppingListPage(driver); //object for this testcases

//Click login in Home screen
		homePage.clickLoginLink();

// Enter login credentials
		loginTest.enterVaildMail("john123@test123.com");
		loginTest.enterVaildPassword("Password@123");
		loginTest.clickLoginbtn();
		
//Click shopping cart  in homescreen 
		
		homePage.Shoppingcart();
		
		System.out.println("Current URL : " + driver.getCurrentUrl());
		
		int count = cart.getProductCount();

		System.out.println("Product count is : "+ count);
		
		cart.displayCartDetails();
		cart.verifyProductTotal();

//		Assert.assertEquals( count, 3,"Product count match");
		
//product list only name 
		
//		List<String> products = cart.getProductNames();
//
//		for (String product : products) {
//		    System.out.println("Name of the product :"+ product);
//		}
		
		
	}


}