package Testcases;

import org.testng.annotations.Test;

import BaseMethods.baseMethods;
import DataProvider.CheckoutAddressDataProvider;
import PageObject.CheckOutPage;
import PageObject.HomePage;
import PageObject.ShoppingListPage;
import PageObject.loginPage;

public class Checkout  extends baseMethods{

	@Test(dataProvider = "CheckoutAddress",
		  dataProviderClass = CheckoutAddressDataProvider.class)
	public void CheckoutShopping(
			String tcid,
	        String company,
	        String country,
	        String state,
	        String city,
	        String address1,
	        String address2,
	        String zip,
	        String phone,
            String FaxNumber) {
		
		// Page object Model   

				HomePage homePage = new HomePage(driver);
				loginPage loginTest = new loginPage(driver);
				ShoppingListPage cart =new ShoppingListPage(driver); 
				CheckOutPage Checkout = new CheckOutPage(driver);

		//Click login in Home screen
				homePage.clickLoginLink();

		// Enter login credentials
				loginTest.enterVaildMail("john123@test123.com");
				loginTest.enterVaildPassword("Password@123");
				loginTest.clickLoginbtn();
				
		//Click shopping cart  in homescreen 
				
				homePage.Shoppingcart();
				cart.displayCartDetails();
				Checkout.Termsofservice();
				Checkout.ClickCheckoutBtn();
				
//select new address to give below info 	
				
				Checkout.selectNewAddress();
				
// Fill the form				
				Checkout.printAllCountries();
				Checkout.selectCountry(country);
				Checkout.printAllState();
				Checkout.selectState(state);
				Checkout.enterCity(city);
				Checkout.enterAddress1(address1);
				Checkout.enterAddress2(address2);
				Checkout.enterPhone(phone);
				Checkout.enterZipCode(zip);
				Checkout.enterFax(FaxNumber);
				Checkout.continueBillingBtn();
//next steps				
				Checkout.shippingaddress();	
				Checkout.shippingMode();
				Checkout.payment();
				Checkout.paymentinfo();
// confirm order				
				Checkout.confirmorderbtn();

		
		
	}
}
