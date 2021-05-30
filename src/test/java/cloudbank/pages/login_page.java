package cloudbank.pages;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class login_page {
	
	WebDriver ldriver;
	
	public login_page(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

		
		@FindBy(xpath="//*[@name='username']")
		public WebElement username;
		
		@FindBy(xpath="//input[@name='password']")
		public WebElement password;
		
		@FindBy(xpath="//button[@data-ng-click='login()']")
		public WebElement sign_in;
		
		@FindBy(xpath="//a[@id='client-dropdown']")				
		public WebElement client_drpdwn;

		@FindBy(xpath="//div[@class='left-nav ng-scope']//a[@href='#/createclient']")
		public WebElement client_option;

		@FindBy(xpath="//a[@id='client_createbutton']")
		public WebElement create_button;

		@FindBy(xpath="//input[@name='firstname'] ")
		public WebElement first_name;

		@FindBy(xpath="//input[@name='lastname']")
		public WebElement last_name;
		
		@FindBy(xpath="//input[@name='mobileNo'] ")
		public WebElement mobileno;
		
		@FindBy(xpath="//input[@id='emailAddress']")
		public WebElement email;
		
		@FindBy(xpath="//div[@id='clienttypeId_chosen']")
		public WebElement client_type;
		
		@FindBy(xpath="//div[@id='clientClassificationId_chosen']")
		public WebElement client_classification;
		
		@FindBy(xpath="//div[@id='genderId_chosen']")
		public WebElement gender;
		
		@FindBy(xpath="//input[@id='dateofbirth']")
		public WebElement DOB;
		
		@FindBy (xpath="//div[@class='pull-right']//div//button")
		public WebElement submit_button;
		
		@FindBy(xpath="//*[@ng-show='showActivationDateField']//table//tbody//tr[last()]//a")
		public WebElement Activate_date;
		 
	
		@FindBy(xpath="//div[@class='tab-pane ng-scope active']//a[contains(@href,'activate')]")
		public WebElement Activate_button;
		

		@FindBy (xpath="//button[@id='save']")
		public WebElement save_button;
		
		@FindBy(xpath="//h3[@class='client-title']//strong")
		public WebElement client_details;
		
		@FindBy(xpath="//div[@ng-controller='ViewClientController']//a")
		public WebElement client_home_link;
		
		@FindBy(xpath="//input[@data-ng-model='searchText']")
		public WebElement search_box;
		
		@FindBy(xpath="//button[@class='btn btn-primary form-control']")
		public WebElement search_button;
		
		@FindBy(xpath="//div[@id='loaderWrapper']")
		public WebElement spinner;
		
		@FindBy(xpath="//tr[@total-items='totalClients']//td[2]")
		public WebElement client_displayed;
		

	

}
