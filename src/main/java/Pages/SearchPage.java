package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase 
{
	public SearchPage(WebDriver driver) {
		super(driver);
	}

	By searchTextBox = By.id("small-searchterms"); 

	By searchBtn =By.cssSelector("button.button-1.search-box-button") ; 

	By ProductList= By.id("ui-id-1"); 

	By productTitle = By.linkText("Windows 8 Pro"); 

	public void ProductSearch(String productName) 
	{
		setTextElementText(searchTextBox, productName);
		clickButton(searchBtn);
	}

	public void OpenProductDetailsPage() 
	{
		clickButton(productTitle);
	}

}
