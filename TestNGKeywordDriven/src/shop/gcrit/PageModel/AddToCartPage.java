

package shop.gcrit.PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author goutham
 * 
 *  This class contains all the methods and Locators of AddToCartPage
 */
public class AddToCartPage extends ProductSearchPage{

	//Constructor
	public AddToCartPage(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
	}

	//Webelements -PageFactory
	@FindBy(how=How.ID,using="tdb4") WebElement AddtocartButton;
	
	//Method to add Products into the cart
	public void addproduct2cart()
	{
		AddtocartButton.click();
	}
	
}
