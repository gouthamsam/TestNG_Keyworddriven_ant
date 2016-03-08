package utilconfig;

/*
 * @Author Goutham
 * This Class contains all the methods needed for the class ExecuteTest
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	File src;
	
//===================================================================================	
	//Method for the excel workbook
	public BrowserFactory(String excelpath){
	try {
		src= new File(excelpath);
		FileInputStream fis=new FileInputStream(src);
		wb= new XSSFWorkbook(fis);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	}
//==================================================================================


	//method to start the Browser and navigate to the specified URL
	public static WebDriver StartBrowser(String Browsername,String url)
	{
		if(Browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
//=================================================================================
	//Method to capture Screenshots during execution
	public static void capturescreenshot(String Screenshotname) 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src,new File("./Screenshots/"+Screenshotname+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
//==================================================================================


	//Method to get data from excel file
	public List<String> getData(int Sheetnumber,int columnnumber){
		sheet=wb.getSheetAt(Sheetnumber);
		List<String> sample = new ArrayList<String>();
		int rowcount=sheet.getLastRowNum();
		for(int i=1;i<=rowcount;i++)
		{
			sample.add(sheet.getRow(i).getCell(columnnumber).getStringCellValue());
		}
		return sample;
	}

	
//===================================================================================
	
	//Method to write data into excel file(Results)
	public void write(int Sheetnumber,int rownumber,String outputdata) 
	{
		sheet=wb.getSheetAt(Sheetnumber);
		sheet.getRow(rownumber).createCell(4).setCellValue(outputdata);
		
	}

//======================================================================================
	//Method to save the excel file
	public void Filesave() 
	{
		try {
			FileOutputStream fos=new FileOutputStream(src);
			wb.write(fos);
			wb.close();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	
	}

//=================================================================================
	//method to display the status of every test (Pass or fail)
	public static String teststatus()
	
	{
		String data;
		if(driver.navigate() != null)
		{
			data="pass";
		}
		else
		{
			data="fail";
		}
		return data;
	}
	
//==================================================================================

//Method to clear the previous test results in excel file
	public static String clear()
	{
		String cleardata="";
		return cleardata;
		
	}
	
	//method to close the browser
	public static void close_browser()
	{
		driver.close();
	}
}
