package shop.gcrit.testcases;

/*
 * This class contains all the test cases that need to be verified
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import shop.gcrit.PageModel.AddToCartPage;
import shop.gcrit.PageModel.Checkout_Shipping;
import shop.gcrit.PageModel.ConfirmOrderPage;
import shop.gcrit.PageModel.ConfirmPaymentTypePage;
import shop.gcrit.PageModel.LoginPage;
import shop.gcrit.PageModel.ProductSearchPage;
import shop.gcrit.PageModel.UpdateandCheckoutPage;
import utilconfig.BrowserFactory;

public class Verifyecommerceportal {
	
	WebDriver driver;
	
	//TestNG annotation -Test to verify Productsearch
	@Test
	public void Verify_Productsearch()
	{
	driver=BrowserFactory.StartBrowser("firefox", "http://www.gcrit.com/build3/");
	ProductSearchPage pobj=PageFactory.initElements(driver, ProductSearchPage.class);
	pobj.Search_Product();
	BrowserFactory.capturescreenshot("SearchProduct");
	
	}
	//TestNG annotation -Test to verify add2cart
	@Test(dependsOnMethods={"Verify_Productsearch"})
	public void Verify_add2Cart()
	{
		AddToCartPage addobj=PageFactory.initElements(driver, AddToCartPage.class);
		addobj.addproduct2cart();
		BrowserFactory.capturescreenshot("Add2Cart");
		
	}
	
	//TestNG annotation -Test to verify updatecartcheckout
	@Test(dependsOnMethods={"Verify_add2Cart"})
	public void Verify_updatecartcheckout()
	{
		UpdateandCheckoutPage uobj=PageFactory.initElements(driver, UpdateandCheckoutPage.class);
	    uobj.updatecart_checkout();
	    BrowserFactory.capturescreenshot("CheckoutCart");
	    
	}
	
	//TestNG annotation -Test to verify login
	@Test(dependsOnMethods={"Verify_updatecartcheckout"})
	public void Verify_Login()
	{
		LoginPage lobj=PageFactory.initElements(driver, LoginPage.class);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		lobj.Type_LoginDetails();
		BrowserFactory.capturescreenshot("Login");
		lobj.click_login();	
		
	}
	
	//TestNG annotation -Test to verify shipping
	@Test(dependsOnMethods={"Verify_Login"})
	
		public void Verify_Shipping()
		{
		Checkout_Shipping sobj=PageFactory.initElements(driver, Checkout_Shipping.class);
		sobj.shipping_confirm();
		BrowserFactory.capturescreenshot("Checkout_Shipping");
		
		}
	
	//TestNG annotation -Test to verify paymenttype
	@Test(dependsOnMethods={"Verify_Shipping"})
	
	public void Verify_PaymentType()
	{
		ConfirmPaymentTypePage Ptobj=PageFactory.initElements(driver, ConfirmPaymentTypePage.class);
	    Ptobj.confirm_payment();
	    BrowserFactory.capturescreenshot("Checkout_ConfirmPayment");
	    
	   
	}
	
	//TestNG annotation -Test to verify Confirmorder
@Test(dependsOnMethods={"Verify_PaymentType"})
	
	public void Verify_ConfirmOrder() 
	{
	ConfirmOrderPage obj=PageFactory.initElements(driver, ConfirmOrderPage.class);
	    obj.Click_ConfirmOrder();
	   
	    BrowserFactory.capturescreenshot("Order_Confirmation");
	   
	    
	   
	}




}

