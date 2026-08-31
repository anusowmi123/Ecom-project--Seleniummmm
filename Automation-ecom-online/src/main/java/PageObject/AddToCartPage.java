package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartPage {

	WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
	 this.driver = driver;	
	};
	
	//creating object for locators 
	
	// Add to Cart button full screen
    By btnAddToCart2 =By.id("add-to-cart-button-2");       
	
	// Add RecipientName
	By RecipientName=By.id("giftcard_2_RecipientName");
	
	// Add RecipientName validation
	By RecipientNameValidation =By.xpath("//*[@id=\"bar-notification\"]/p");

	// Add RecipientMail
	By RecipientEmail=By.id("giftcard_2_RecipientEmail");
	
	// Add RecipientMail validation
	By RecipientEmailValidation =By.xpath("//*[@id=\"bar-notification\"]/p");
		
	// Success notification
	By successMsg = By.xpath("//*[@id=\"bar-notification\"]/p");

	// Cart quantity
	By cartQty = By.id("addtocart_2_EnteredQuantity");
	
	
	//Methods
	
	
	
	public void clickAddToCartFullScreenBtn()
	{
	    driver.findElement(btnAddToCart2).click();
	}
	public void EnterRecipientName(String Name){
		driver.findElement(RecipientName).sendKeys(Name);
	}
	
	public void EnterRecipientMail(String Mail){
		driver.findElement(RecipientEmail).sendKeys(Mail);
	}
	
	public void RecipientNameValigation(){
		driver.findElement(RecipientNameValidation).getText();
	}
	
	public void RecipientMailValigation(){
		driver.findElement(RecipientEmailValidation).getText();
	}
	
	public String getSuccessMessage()
	{
	    return driver.findElement(successMsg).getText();
	}

	public String getCartQuantity()
	{
	    return driver.findElement(cartQty).getAttribute("value");
	}	
	public void enterQuantity(String string) {
	    WebElement qty = driver.findElement(cartQty);
	    qty.clear();
	    qty.sendKeys(String.valueOf(string));
	}
	
}
