package shop.gcrit.driver;

/*
 * @Author Goutham
 * 
 * This class contains the keyword driven framework
 */
import org.testng.annotations.Test;

import shop.gcrit.testcases.Verifyecommerceportal;
import utilconfig.BrowserFactory;

public class ExecuteTest {
	
	BrowserFactory excel=new BrowserFactory("./TestData/ORGANIZER.xlsx");
	BrowserFactory wdata=new BrowserFactory("./TestData/ORGANIZER.xlsx");
	Verifyecommerceportal obj=new Verifyecommerceportal();
	
//TestNG Annotation- Keyword Driven Framework
	@Test
public void test()  
{
	//To clear the previous results of the tests in excel file	
		for(int row=1;row<=7;row++)
		{
	wdata.write(2, row, BrowserFactory.clear());	
		}
		
	//====================================================================
	//Keyword driven framework
	//=====================================================================
for(int i=0;i<excel.getData(0,2).size();i++)
 {
 if(excel.getData(0,2).get(i).equals("Y"))
	{
	String Moduleid=(String) excel.getData(0, 0).get(i);
	//System.out.println(Moduleid);
			
	for(int j=0;j<excel.getData(1,2).size();j++)	
	{
	String TestCaseExe=(String) excel.getData(1,2).get(j);
	//System.out.println(TestCaseExe);
	String TestModuleId=(String) excel.getData(1,3).get(j);
	//System.out.println(TestModuleId);
	
	//System.out.println(TestCaseId);
			if(TestCaseExe.equals("Y") && TestModuleId.equals(Moduleid))
			{
				String TestCaseId=(String) excel.getData(1, 0).get(j);
				//System.out.println(TestCaseId);
			
			for(int k=0;k<excel.getData(2,3).size();k++)	
			{
			String testid1=(String) excel.getData(2, 3).get(k);
			//System.out.println(testid1);
			if(testid1.equals(TestCaseId))
			{
				String Keyword=(String) excel.getData(2, 2).get(k);
				
				
				//keyword
				
				//System.out.println(Keyword);
				switch(Keyword)
				{
				case "Ps":
					obj.Verify_Productsearch();
					wdata.write(2, k+1, BrowserFactory.teststatus());
					BrowserFactory.close_browser();
					break;
					case "Ac":
						obj.Verify_Productsearch();
						obj.Verify_add2Cart();
						wdata.write(2, k+1, BrowserFactory.teststatus());
						BrowserFactory.close_browser();
						break;
					case "Ucc":
						obj.Verify_Productsearch();
						obj.Verify_add2Cart();
						obj.Verify_updatecartcheckout();
						wdata.write(2, k+1, BrowserFactory.teststatus());
						BrowserFactory.close_browser();
						break;
					case "Lo":
						obj.Verify_Productsearch();
						obj.Verify_add2Cart();
						obj.Verify_updatecartcheckout();
						obj.Verify_Login();
						wdata.write(2, k+1, BrowserFactory.teststatus());
						BrowserFactory.close_browser();
						break;
					case "Sc":
						obj.Verify_Productsearch();
						obj.Verify_add2Cart();
						obj.Verify_updatecartcheckout();
						obj.Verify_Login();
						obj.Verify_Shipping();
						wdata.write(2, k+1, BrowserFactory.teststatus());
						BrowserFactory.close_browser();
						break;
					case "Pt":
						obj.Verify_Productsearch();
						obj.Verify_add2Cart();
						obj.Verify_updatecartcheckout();
						obj.Verify_Login();
						obj.Verify_Shipping();
						obj.Verify_PaymentType();
						wdata.write(2, k+1, BrowserFactory.teststatus());
						BrowserFactory.close_browser();
						break;
					case "Co":
						obj.Verify_Productsearch();
						obj.Verify_add2Cart();
						obj.Verify_updatecartcheckout();
						obj.Verify_Login();
						obj.Verify_Shipping();
						obj.Verify_PaymentType();
						obj.Verify_ConfirmOrder();
						wdata.write(2, k+1, BrowserFactory.teststatus());
						BrowserFactory.close_browser();
						break;
					default:
						break;
				}
			
			}//if end
				
			}//for loop end
			
			}//if end
			
		}//for loop end
		
		}//if end
	}//for loop end

wdata.Filesave();
	}

	
}
