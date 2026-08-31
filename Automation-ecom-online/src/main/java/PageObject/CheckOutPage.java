package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckOutPage {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		 this.driver = driver;
	}

//Locators
	
	By CheckoutBtn= By.id("checkout");
	By Terms = By.id("termsofservice");
	By country= By.id("BillingNewAddress_CountryId");
	By State =By.id("BillingNewAddress_StateProvinceId");
	By City = By.id("BillingNewAddress_City");
	By Address1 =By.id("BillingNewAddress_Address1");
	By Address2 =By.id("BillingNewAddress_Address2");
	By Zip = By.id("BillingNewAddress_ZipPostalCode");
	By phoneNumber = By.id("BillingNewAddress_PhoneNumber");
	By Fax =By.id("BillingNewAddress_FaxNumber");
    By continueBilling = By.xpath("//*[@id=\"billing-buttons-container\"]/input");
    By CompanyAddress = By.id("BillingNewAddress_Company");
    By SelectBillingadd = By.id("billing-address-select");
    By Shipingadd = By.xpath("//*[@id=\"shipping-buttons-container\"]/input");
    By shippingmode = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input");
    By payment = By.xpath("//*[@id=\"payment-method-buttons-container\"]/input");
    By paymentinfo = By.xpath("//*[@id=\"payment-info-buttons-container\"]/input");  
    By confirmorder= By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");
	
//Methods
	
	public void ClickCheckoutBtn() {
		driver.findElement(CheckoutBtn).click();
	}
	
	public void selectNewAddress() {

	    Select select = new Select(driver.findElement(SelectBillingadd));

	    select.selectByVisibleText("New Address");
	}
	public void Termsofservice() {
		
		 WebElement checkbox = driver.findElement(Terms);

		    if (!checkbox.isSelected()) {
		        checkbox.click();
		    }

		    Assert.assertTrue(checkbox.isSelected(),
		            "Terms of Service checkbox should be selected");
	}
	
	public void printAllCountries() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		 WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated( By.id("BillingNewAddress_CountryId")));
   
		 Select select = new Select(driver.findElement(country));
   
	    List<WebElement> countries = select.getOptions();

	    for (WebElement option : countries) {

	        System.out.println(option.getText());
	      
	    }
	}
	
	public void printAllState() {
		
		Select select = new Select (driver.findElement(State));
		List<WebElement> states = select.getOptions();
		
		for (WebElement option:states ) {
			  System.out.println(option.getText());
			 
		}
	}
	
	public void enterCompany(String company) {
	    driver.findElement(CompanyAddress).sendKeys(company);
	} 
	public void enterCity(String city) {
	    driver.findElement(City).sendKeys(city);
	}

	public void enterAddress1(String address1) {
	    driver.findElement(Address1).sendKeys(address1);
	}


	public void enterAddress2(String address2) {
	    driver.findElement(Address2).sendKeys(address2);
	}

	public void enterZipCode(String zip) {
	    driver.findElement(Zip).sendKeys(zip);
	}

	public void enterPhone(String phone) {
	    driver.findElement(phoneNumber).sendKeys(phone);
	}
	
	public void enterFax(String FaxNumber) {
	    driver.findElement(Fax).sendKeys(FaxNumber);
	}
	public void selectCountry(String countryName) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    WebElement dropdown = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(country));

	    Select select = new Select(dropdown);

	    select.selectByVisibleText(countryName);
	}
	public void selectState(String stateName) {

	    Select select = new Select(driver.findElement(State));

	    select.selectByVisibleText(stateName);
	}
	
	public void continueBillingBtn () {
		driver.findElement(continueBilling).click();
	}
	
	public void shippingaddress() {
		driver.findElement(Shipingadd).click();
	}
	
	public void shippingMode() {
		driver.findElement(shippingmode).click();
	}
	public void payment() {
		driver.findElement(payment).click();
	}
	
	public void paymentinfo() {
		driver.findElement(paymentinfo).click();
	}
	
	public void confirmorderbtn() {
		driver.findElement(confirmorder).click();
		System.out.println("Order Confirmed ");
	}
}



