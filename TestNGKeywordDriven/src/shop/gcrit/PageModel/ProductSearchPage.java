/**
 * 
 */
package shop.gcrit.PageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * @author goutham
 * 
 * This  Class contains all locators and methods of ProductSerachPage
 */
public class ProductSearchPage {

	//Constructor
	WebDriver driver;
	public ProductSearchPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	//WebElement -PageFactory
	@FindBy(how=How.NAME,using="manufacturers_id") 
	WebElement Manufacturer;
	@FindBy(how=How.NAME,using="keywords")
	WebElement ProductName;
	@FindBy(how=How.XPATH,using=".//*[@id='columnLeft']/div[3]/div[2]/form/input[3]")
	WebElement Searchbutton;
	
	//Method to search the product from the manufacturers list
	public void Search_Product()
	{
		Select dropdown=new Select(Manufacturer);
		dropdown.selectByVisibleText("Fritzberg");
		ProductName.sendKeys("Casual Shoes");
		Searchbutton.click();
		
	}
	
	
	
}
