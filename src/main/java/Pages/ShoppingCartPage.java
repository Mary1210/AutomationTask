package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends PageBase
{
	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	By quantityTxt = By.cssSelector("input.qty-input valid");

	By checkoutBtn = By.id("checkout"); 
	
	By agreeCheckbox = By.id("termsofservice"); 
	
	By totalLbl = By.cssSelector("td.subtotal");

	public void openCheckoutPage() 
	{
		clickButton(agreeCheckbox);
		clickButton(checkoutBtn);
	}
	
	public String getTotal()
	{
		return getText(totalLbl);
	}
}

