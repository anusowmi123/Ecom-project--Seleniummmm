package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.Assert;

public class ShoppingListPage {
 
	WebDriver driver;
	
	public ShoppingListPage(WebDriver driver) {
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
	} 
	
//Locator	
	
	@FindBy(className ="cart")
	WebElement CartTable;

	@FindBy(className ="cart-item-row") //2 way can write this
	List<WebElement> cartRows;
	
//	List<WebElement> cartRow = driver.findElements(By.className("cart-item-row"));
	
	
//Methods
	
	public int getProductCount() {
		return cartRows.size();
	}
	
	public boolean isCartDisplayed() {
	    return CartTable.isDisplayed();
	}
	
	
	public List<String> getProductNames() {

// Create an empty list to store product names
	    List<String> names = new ArrayList<>();

 // Loop through each product row
	    for (WebElement row : cartRows) {

// Find the product link inside the current row
	        WebElement productLink = row.findElement(By.tagName("a"));

// Get the product name and add it to the list
	        names.add(productLink.getText());
	    }

// Return all product names
	    return names;
	}
	
	
	
	public void displayCartDetails() {

	    for (WebElement row : cartRows) {

	        String product = row.findElement(By.tagName("a")).getText();

	        String price = row.findElement(By.className("product-unit-price")).getText();

	        String qty = row.findElement(By.className("qty-input"))
	                        .getAttribute("value");

	        String total = row.findElement(By.className("product-subtotal"))
	                          .getText();

	        System.out.println("Product : " + product);
	        System.out.println("Price : " + price);
	        System.out.println("Qty : " + qty);
	        System.out.println("Total : " + total);
	        System.out.println("-------------------------");
	    }
	}
	
	
	public void verifyProductTotal() {

	    for (WebElement row : cartRows) {

	        String product = row.findElement(By.tagName("a")).getText();

	        String price = row.findElement(By.className("product-unit-price"))
	                          .getText().replace("$", "");

	        String qty = row.findElement(By.className("qty-input"))
	                        .getAttribute("value");

	        String total = row.findElement(By.className("product-subtotal"))
	                          .getText().replace("$", "");

	       
	        double unitPrice = Double.parseDouble(price); //Now it becomes a double (decimal number).An int cannot store decimal numbers.
	     
	        int quantity = Integer.parseInt(qty); //Because quantity is always a whole number.
	       
	        double actualTotal = Double.parseDouble(total);
	       
	        double expectedTotal = unitPrice * quantity;
	       
	        System.out.println("Checking : " + product);
	       
	        System.out.println("Expected Total : " + expectedTotal);
	        
	        System.out.println("Actual Total   : " + actualTotal);

	        Assert.assertEquals(actualTotal, expectedTotal,
	                "Total mismatch for product : " + product);

	        System.out.println("✅ Total verified successfully");
	        System.out.println("--------------------------------");
	    }
	}
	
}
