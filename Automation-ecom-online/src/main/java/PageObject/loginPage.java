package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

	WebDriver driver;
	
	public loginPage(WebDriver driver) { //Constructor
	this.driver = driver;
	}
	
//creating object for locators 
	
	By loginMailid=By.id("Email");
	By loginPassword = By.id("Password");
	By rememberMe =By.id("RememberMe");
	By forgetpassword = By.linkText("Forgot password");
	By clickloginBtn = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");
	By loginMailValidation =By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[2]/span/span");
	By passwordValidation = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/ul/li");
	By loginEmptyFieldsValidation =By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span");
	By forgetPasswordMail = By.id("Email");
	
//Actions -Validation	
	
	public String EmptyFieldsValidation() {
		return driver.findElement(loginEmptyFieldsValidation).getText();
	}
	
	public String[] getEmailValidationMsg() {
		String emailMsg = driver.findElement(loginMailValidation).getText();	
		String validation = driver.findElement(loginEmptyFieldsValidation).getText();
		return new String[] { emailMsg,validation};
	}	
		
	public String getPasswordValidationMsg() {
		return driver.findElement(passwordValidation).getText();	
	}
	public String clickForgetPassword() {
		return driver.findElement(forgetpassword).getText();	
	}
	public String getForgotPasswordEmailMsg() {
		return driver.findElement(forgetPasswordMail).getText();	
	}
	public void enterVaildMail(String mail) {
		driver.findElement(loginMailid).sendKeys(mail);	
	}
	public void enterVaildPassword(String password) {
		driver.findElement(loginPassword).sendKeys(password);	
	}
	public void clickLoginbtn() {
		driver.findElement(clickloginBtn).click();	
	}
	public void login(String email, String password) {

	    enterVaildMail(email);
	    enterVaildPassword(password);
	  
	}
	
	
} 
	