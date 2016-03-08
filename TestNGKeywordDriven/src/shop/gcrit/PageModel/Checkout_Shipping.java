/**
 * 
 */
package shop.gcrit.PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author goutham
 * 
 *  This class contains all the methods and locators of Checkout_Shipping Page
 */
public class Checkout_Shipping extends ProductSearchPage {

	//Constructor
	public Checkout_Shipping(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
	}
	
	//WebElement -PageFactory
	@FindBy(how=How.ID,using="tdb6")
    WebElement Confirm_shippingButton;
	
	//Method to confirm the shipping of article or product
	public void shipping_confirm()
	{
		Confirm_shippingButton.click();
	}
}
