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
 * This class contains all the methods and locators of ConfirmOrderPage
 */
public class ConfirmOrderPage extends ProductSearchPage {

	//Constructor
	public ConfirmOrderPage(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
	}
	
	//WebElement -Pagefactory
	@FindBy(how=How.ID,using="tdb5")
    WebElement Confirm_OrderButton;

	//Method to Confirm the order of article
	public void Click_ConfirmOrder()
	{
		Confirm_OrderButton.click();
	}
}
