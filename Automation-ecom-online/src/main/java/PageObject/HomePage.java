package PageObject;

import java.time.Duration;

//(Test cases -extract -how to find elements) - is uses of page object model,
//because for example we used same locater for 50 places if any changes comes 
//we need to find and change at the same time so,hard thats why separate class and create a method use it for maintains and resueability

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

   WebDriver driver ; 
	
   public HomePage(WebDriver driver) {  // driver is a browser = chrome from base method ,WebDriver driver = new ChromeDriver();
	   this.driver = driver;   
   }  
   
   // click login link in home screen 
   By loginLink =By.linkText("Log in");
   
    // Add to Cart button
    By btnAddToCartHomeScreen = By.xpath("/html/body/div[4]/div[1]/div[4]/div[3]/div/div/div[3]/div[2]/div/div[2]/div[3]/div[2]/input");
   
    // click shopping list link in home screen 
    By Shopping = By.linkText("Shopping cart");

   
    
    public void clickRegister() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));                       // Force Selenium to explicitly wait for the URL text to update   
    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();             // Wait for register link to be ready, then click it          
    }

    public void clickLoginLink() {
    	
    	driver.findElement(loginLink).click();
    }

    public void clickAddToCartHomeScreen()
    {
    	driver.findElement(btnAddToCartHomeScreen).click();
    }
    public void Shoppingcart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shopping cart")));

        driver.findElement(By.linkText("Shopping cart")).click();
    }
  }
//this.driver means: "Use the driver that belongs to this HomePage object."
// " = driver's browser from the baseMethods and keep it inside the HomePage."