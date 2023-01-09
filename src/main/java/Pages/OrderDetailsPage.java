package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDetailsPage extends PageBase {
    
	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}

    By pdfInvoiceLink = By.cssSelector("a.button-2.pdf-invoice-button");
	
    By printInvoiceLnk = By.cssSelector("a.button-2.print-order-button");

    public void PrintOrderDetails() {
        clickButton(printInvoiceLnk);
    }

    public void DownloadPDFInvoice() {
        clickButton(pdfInvoiceLink);
    }

}
