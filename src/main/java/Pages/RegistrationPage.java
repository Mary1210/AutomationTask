package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends PageBase 
{
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	By genderRdBtn = By.id("gender-male");
	
	By fnTxtBox= By.id("FirstName");
	
	By lnTxtBox = By.id("LastName");

	By emailTxtBox = By.id("Email"); 
	
	By passwordTxtBox = By.id("Password"); 
	
	By confirmPasswordTxtBox = By.id("ConfirmPassword") ; 
	
	By registerBtn = By.id("register-button"); 
	
	By successMessage = By.cssSelector("div.result"); 
	
	By logoutLink = By.linkText("Log out"); 
	
	By myAccountLink= By.linkText("My account"); 
	
	public void userRegistration(String firstName , String lastName , String email , String password) 
	{
		clickButton(genderRdBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
	
	public void userLogout() 
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() 
	{
		clickButton(myAccountLink);
	}
	
	public String getMessege()
	{
		return getText(successMessage);
	}
	
}
