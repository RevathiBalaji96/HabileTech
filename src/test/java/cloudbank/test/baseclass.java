package cloudbank.test;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import cloudbank.utilities.ReadConfig;

public class baseclass {

	public static WebDriver driver;
	ReadConfig readconfig = new ReadConfig();
	public String Baseurl=readconfig.geturl();
	public String Username=readconfig.getusername();
	public String password=readconfig.getpassword();
	
	
@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver",readconfig.getchromepath());
	driver=new ChromeDriver();
}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			try
			{
						TakesScreenshot ts =(TakesScreenshot)driver;
						File source=ts.getScreenshotAs(OutputType.FILE);
			
						FileHandler.copy(source, new File("./Screenshots/"+result.getName()+".png"));
						System.out.println("Screenshot taken!!");
		
				
			}
			catch(Exception e){
				
				System.out.println("Exception while taking screenshot"+ e.getMessage());
			}
		}
		driver.quit();
}
}
