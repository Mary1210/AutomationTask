package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	By registerLink = By.linkText("Register"); 
	//WebElement registerPage = driver.findElement(registerLink);

	By loginLink = By.linkText("Log in"); 
	//WebElement loginPage = driver.findElement(loginLink);
	
	public void openRegistrationPage() 
	{
		clickButton(registerLink);
	}
	
	public void openLoginPage() 
	{
		clickButton(loginLink);
	}

}
