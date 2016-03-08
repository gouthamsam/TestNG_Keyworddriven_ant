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
 * This class contains all the methods and locators of ConfirmPaymentTypePage
 */
public class ConfirmPaymentTypePage extends ProductSearchPage {

	public ConfirmPaymentTypePage(WebDriver ldriver) {
		super(ldriver);
		// TODO Auto-generated constructor stub
	}
//WebElement -PageFactory
	@FindBy(how=How.XPATH,using=".//*[@id='bodyContent']/form/div/div[4]/table[1]/tbody/tr/td[2]/input")
	WebElement Select_PaymentType;
	@FindBy(how=How.ID,using="tdb6")
    WebElement Confirm_PaymentButton;
	
	//Method to select Payment type and confirm the payment
	public void confirm_payment()
	{
		Select_PaymentType.click();
		Confirm_PaymentButton.click();
	}
}
