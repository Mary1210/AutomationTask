package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OrderDetailsPage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.ShoppingCartPage;
import data.ExcelReader;
import Pages.RegistrationPage;

public class RegisteredUserCheckout extends TestBase {
	
	
	String productName = "Windows 8 Pro"; 
	LoginPage loginObject;
	HomePage homeObject;
	RegistrationPage registerObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ShoppingCartPage cartPage;
	CheckoutPage checkoutObject;
	OrderDetailsPage orderObject;
	ExcelReader ER;
	
	@BeforeClass
	public void RegisteredUserCheckoutBeforeClass() {
		loginObject = new LoginPage(driver); 
		homeObject = new HomePage(driver); 
		registerObject = new RegistrationPage(driver);
		searchObject = new SearchPage(driver); 
		detailsObject = new ProductDetailsPage(driver);
		cartPage = new ShoppingCartPage(driver); 
		checkoutObject = new CheckoutPage(driver); 
		orderObject = new OrderDetailsPage(driver); 
		ER = new ExcelReader();
	}
	
	@DataProvider(name="ExcelFileData")
	public  Object[][] userRegisterData() throws IOException
	{
		return ER.getExcelData();
	}
	
	@Test(priority=1,dataProvider="ExcelFileData")
	public void UserCanRegisterSuccssfully(String firstName , String lastName , String email , String password) throws InterruptedException 
	{
		homeObject.openRegistrationPage();
		registerObject.userRegistration(firstName,lastName,email,password);
		Assert.assertTrue(registerObject.getMessege().contains("Your registration completed"));
		homeObject.openLoginPage();
		loginObject.UserLogin(email, password);
		searchObject.ProductSearch(productName);
		searchObject.OpenProductDetailsPage();
		Assert.assertEquals(detailsObject.getProductName(), productName);
		detailsObject.AddToCart();
		driver.navigate().to("http://demo.nopcommerce.com" + "/cart");	
		Assert.assertTrue(cartPage.getTotal().contains("$65.00"));
		cartPage.openCheckoutPage();
		checkoutObject.RegisteredUserCheckoutProduct
		("Egypt", "test address", "123456", "32445566677", "Cairo", productName);
		Assert.assertTrue(checkoutObject.isProductNameDisplayed());
		Assert.assertTrue(checkoutObject.getProductName().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.isThankYoulblDisplayed());
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		orderObject.DownloadPDFInvoice();
		orderObject.PrintOrderDetails();
		registerObject.userLogout();
	}

}
