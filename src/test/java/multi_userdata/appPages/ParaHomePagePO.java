package multi_userdata.appPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;


public class ParaHomePagePO extends LoadableComponent<ParaHomePagePO>{
	
	WebDriver driver;
	public ParaHomePagePO(WebDriver driver) {
		// DriverFactory.getDriver().get("https://parabank.parasoft.com/");
		// PageFactory.initElements(DriverFactory.getDriver(), this);
		

        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get("https://parabank.parasoft.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
	
    
	@FindBy(linkText="Register")
	public WebElement registerLink;
	
	
	public ParaNewUserPagePO newuserAccount() {
		registerLink.click();
		return new ParaNewUserPagePO(driver);
	}
	
	
	
	
	
	@Override
	protected void load() {	}

	@Override
	protected void isLoaded() throws Error {}

}
