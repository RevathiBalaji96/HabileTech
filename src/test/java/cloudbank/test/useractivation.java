package cloudbank.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import cloudbank.pages.login_page;
import cloudbank.test.baseclass;

public class useractivation extends baseclass {
	
	@Test
	public void ClientCreation() throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		try {
		int min=100;
		login_page lp = new login_page(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//launch url
		driver.navigate().to(Baseurl);
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.invisibilityOf(lp.spinner));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='username']")));
		
	    //Application_login
	    lp.username.sendKeys(Username);
	    lp.password.sendKeys(password);
	    lp.sign_in.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.invisibilityOf(lp.spinner));		
		lp.client_option.click();
		
		//Enter client details
	    wait.until(ExpectedConditions.visibilityOf(lp.first_name));	    																						
	    lp.first_name.sendKeys("Revathi");
		lp.last_name.sendKeys("Balaji");
		Random randomno = new Random();
		int rand = min+ randomno.nextInt(1000);		
		lp.mobileno.sendKeys("9900500"+rand);
		Thread.sleep(1000);
		lp.DOB.sendKeys("09 December 1986");
		lp.client_classification.click();
		select();	
		lp.client_type.click();	
		select();		
		lp.gender.click();
		select();	
		lp.email.sendKeys("rebal"+rand+"@gmail.com");
		lp.submit_button.click();
		
		//activate the client
		wait.until(ExpectedConditions.invisibilityOf(lp.spinner));
	    wait.until(ExpectedConditions.visibilityOf(lp.Activate_button));
		lp.Activate_button.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-widget-div']")));
		driver.findElement(By.xpath("//*[@ng-show='showActivationDateField']//input")).click();		 
		lp.Activate_date.click();
		Thread.sleep(1000); 
		lp.save_button.click();
		
		//new client page
		 wait.until(ExpectedConditions.visibilityOf(lp.client_details)); 		 
		 String url=driver.getCurrentUrl();
		 String[] vals=url.split("/");
		 String Id="00000"+vals[5];
		 lp.client_home_link.click();
		 
		 //search client details
		 wait.until(ExpectedConditions.visibilityOf(lp.search_box));
		 lp.search_box.sendKeys(Id);
		 lp.search_button.click();
		 
		 //verify display details
		  String clientId = lp.client_displayed.getText(); 
		  if(clientId.equals(Id))
		  {
			  System.out.println("Created client is displayed as expected");
		  }
		}
		catch(Exception ex){
			System.out.println("Exception while creating client"+ ex.getMessage());
		}
	}
	

	public void select() throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

}