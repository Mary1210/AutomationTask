package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageBase
{
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	By fnTxt= By.id("BillingNewAddress_FirstName");

	By lnTxt = By.id("BillingNewAddress_LastName");

	By emailTxt = By.id("BillingNewAddress_Email");

	By countryList = By.id("BillingNewAddress_CountryId");

	By phoneTxt = By.id("BillingNewAddress_PhoneNumber");

	By cityTxt = By.id("BillingNewAddress_City");

	By addressTxt = By.id("BillingNewAddress_Address1");

	By postCodeTxt = By.id("BillingNewAddress_ZipPostalCode");

	By continueBtn = By.cssSelector("button[onclick='Billing.save()']");

	By shippingMethodRdo = By.id("shippingoption_1");

	By continueShippingBtn = By.cssSelector("button[onclick='ShippingMethod.save()']");

	By continuePaymentBtn = By.cssSelector("button[onclick='PaymentMethod.save()']");

	By continueInfoBtn = By.cssSelector("button[onclick='PaymentInfo.save()']");

	By productName = By.cssSelector("a.product-name");

	By confirmBtn = By.cssSelector("button[onclick='ConfirmOrder.save()']");

	By ThankYoulbl =By.cssSelector("h1");

	By successMessage = By.cssSelector("div.title");
	
	By orderDetailsLink = By.linkText("Click here for order details.");

	public void RegisteredUserCheckoutProduct(String countryName, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException {
		selectElement(countryList, countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		clickButton(continuePaymentBtn);
		clickButton(continueInfoBtn);
	}

	public void confirmOrder()
	{
		clickButton(confirmBtn);
	}

	public void viewOrderDetails() {
		clickButton(orderDetailsLink);
	}

	public String getProductName()
	{
		return getText(productName);
	}
	
	public boolean isThankYoulblDisplayed()
	{
		return isElementDisplayed(ThankYoulbl);
	}
	
	public boolean isProductNameDisplayed()
	{
		return isElementDisplayed(productName);
	}
	
}
