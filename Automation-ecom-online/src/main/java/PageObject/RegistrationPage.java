package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	
	 WebDriver driver;
	
     public	RegistrationPage(WebDriver driver) { // driver is a browser = chrome from base method ,WebDriver driver = new ChromeDriver();
	 this.driver = driver; 
 }
 
 //Locators objects -created
     
             By maleRadio = By.id("gender-male");
    		 By femaleRadio = By.id("gender-female");	
    		 By txtFirstName = By.id("FirstName");
    		 By txtLastName = By.id("LastName");
    		 By txtEmail = By.id("Email");
    		 By txtPassword = By.id("Password");
    		 By txtConfirmPassword = By.id("ConfirmPassword");
             By btnRegister = By.id("register-button");
       
      //Success
             By SuccessMsg = By.className("result");
             By ContinueBtn = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input");
             
     //"I have created locator objects for all the validation messages using the By class."  
             By firstnameError= By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[2]/span[2]/span");
             By lastnameError=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[3]/span[2]/span");
             By emailError=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[4]/span[2]/span");
             By passwordError=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/span[2]/span");
             By confirmPasswordError=By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[2]/span[2]/span");
             By passwordnotmatch = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[2]/span[2]/span");
             By passwordCharacter=By.linkText("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[3]/div[2]/div[1]/span[2]/span");
            
 // Methods -Actions
     
    public void  selectMale(){
		driver.findElement(maleRadio).click();
	}
    public void  selectFemale(){
		driver.findElement(femaleRadio).click();
	}
	public void enterFirstName(String firstName ) {
		driver.findElement(txtFirstName).sendKeys(firstName);
		}
      
    public void enterLastName(String enterLastName) {
		driver.findElement(txtLastName).sendKeys(enterLastName);
	}
    public void enterEmail (String enterEmail) {
	    driver.findElement(txtEmail).sendKeys(enterEmail);
    }
    public void enterPassword (String enterPassword) {
	    driver.findElement(txtPassword).sendKeys(enterPassword);
    }
    public void enterConfirmPassword(String enterConfirmPassword ) {
	    driver.findElement(txtConfirmPassword).sendKeys(enterConfirmPassword);
    }
    public void clickRegisterBtn() {
   	    driver.findElement(btnRegister).click();
    }
	
 //Success Msg  
    
     public String  getRegistrationSuccessMsg() {
		return driver.findElement(SuccessMsg).getText();	 
     }
     public void clickContinueBtn() {
    	 driver.findElement(ContinueBtn).click(); //Continue
     }
  
 //Validation msg 
     
    public String getFirstNameErrorMsg() {
    return driver.findElement(firstnameError).getText();
    }  
    
    public String getLastNameErrorMsg() {
      return driver.findElement(lastnameError).getText();
    }
    
    public String getEmailErrorMsg() {
		return driver.findElement(emailError).getText();
     }
    public String getPassworderrorMsg() {
		return driver.findElement(passwordError).getText();	
    }
    public String getConfirmPassworderrorMsg() {
		return driver.findElement(confirmPasswordError).getText();
    }
	public String passworddontMatch(){
		return driver.findElement(passwordnotmatch).getText();			
	}
	public String passwordCharacters(){
		return driver.findElement(passwordCharacter).getText();			
	}
}
