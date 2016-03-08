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
 * This class contains all the methods and locators of LoginPage
 */
public class LoginPage extends ProductSearchPage {

		//Constructor
		public LoginPage(WebDriver ldriver) {
			super(ldriver);
			// TODO Auto-generated constructor stub
		}
		
		//WebElement - PageFactory
		@FindBy(how=How.NAME,using="email_address")
		WebElement user;
		@FindBy(how=How.NAME,using="password")
		WebElement password_name;
		@FindBy(how=How.ID,using="tdb5")
		WebElement login_button;
		
		//Method to type the Login credentials
		public void Type_LoginDetails()
		{
			user.sendKeys("tommy123@gmail.com");
			password_name.sendKeys("Hesse");
		}
		
		
		//Method to Login
		public void click_login()
		{
			login_button.click();
		}
	}


