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
 * This class contains all the methods and locators of UpdateandCheckoutPage
 */
public class UpdateandCheckoutPage extends ProductSearchPage {

	public UpdateandCheckoutPage(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
	}

//WebElement -PageFactory
@FindBy(how=How.NAME,using="cart_quantity[]") 
WebElement quantity;	
@FindBy(how=How.ID,using="tdb4")
WebElement UpdateButton;
@FindBy(how=How.ID,using="tdb5")
WebElement CheckoutButton;

//Method to Update the items list in cart and checkout
public void updatecart_checkout()
{
	quantity.clear();
	quantity.sendKeys("3");
	UpdateButton.click();
	CheckoutButton.click();
}
}
