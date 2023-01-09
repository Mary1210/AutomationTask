package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends PageBase
{
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	By addToCartBtn = By.id("add-to-cart-button-11"); 
	
	By productName = By.cssSelector("div[class='product-name']"); 

	public void AddToCart() 
	{
		clickButton(addToCartBtn);
	}
	
	public String getProductName()
	{
		return getText(productName);
	}

}
