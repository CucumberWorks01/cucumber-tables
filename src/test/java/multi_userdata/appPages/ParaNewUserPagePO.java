package multi_userdata.appPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;



public class ParaNewUserPagePO extends LoadableComponent<ParaNewUserPagePO>{
	
    WebDriver driver;	
	public ParaNewUserPagePO(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver,this);
		//PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	@FindBy(id="customer.firstName")
	public WebElement FirstName; 
	
	@FindBy(id="customer.lastName")
	public WebElement LastName ;
	
	@FindBy(id="customer.address.street")
	public WebElement Address;	 
	
	@FindBy(id="customer.address.city")
	public WebElement City ; 
	
	@FindBy(id="customer.address.state")
	public WebElement State ;
	
	@FindBy(id="customer.address.zipCode")
	public WebElement ZipCode ;
	
	@FindBy(id="customer.phoneNumber")
	public WebElement Phone ;
	
	@FindBy(id="customer.ssn")
	public WebElement SSN ;
	
	@FindBy(id="customer.username")
	public WebElement Username ;
	
	@FindBy(id="customer.password")
	public WebElement Password ;
	
	
	@FindBy(id="repeatedPassword")
	public WebElement ConfirmPassword;
	
	@FindBy(css="h1.title") //Signing up is easy!
	public WebElement NewUserPageTitle;
	
	@FindBy(xpath="//input[@value='Register']")
	public WebElement RegisterBTN;
//	
//	@FindBy(id=)
//	public WebElement
	
	
	
	public void CreateNewUser() {
		
		FirstName.clear();
		FirstName.sendKeys("Zinzan");
		
		
		LastName.clear();
		LastName.sendKeys("zoe");
		
		Address.clear();
		Address.sendKeys("");   
		
//		City.clear();
//		
//		State.clear();
//		
//		ZipCode.clear();
//		
//		Phone.clear();
//		
//		SSN.clear();
//		
//		Username.clear();
//		
//		Password.clear();
//		
//		ConfirmPassword.clear();
	}
	
	

	@Override
	protected void load() {}
	

	@Override
	protected void isLoaded() throws Error {}
	
}
