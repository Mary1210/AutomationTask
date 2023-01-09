package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected static WebDriver driver ; 
	public Select select; 
	static WebDriverWait wait;

	public PageBase(WebDriver driver) 
	{
		this.driver =driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	public void selectElement(By element,String name)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		select = new Select(driver.findElement(element));
		select.selectByVisibleText(name);
	}
	
	protected static void clickButton(By Button)
	{
		wait.until(ExpectedConditions.elementToBeClickable(Button));
		driver.findElement(Button).click();
	}
	
	protected static void setTextElementText(By textElement , String value) 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(textElement));
		driver.findElement(textElement).sendKeys(value);
	}
	
	public void clearText(WebElement element) 
	{
		element.clear();
	}
	
	public String getText(By Element)
	{
		WebElement elementTxt= driver.findElement(Element);
		return elementTxt.getText();
	}
	
	public boolean isElementDisplayed(By Element)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(Element));
		WebElement elementDisplay= driver.findElement(Element);
		return elementDisplay.isDisplayed();
	}

}
