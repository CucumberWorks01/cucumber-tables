package multi_userdata.appPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{
    
    WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @FindBy(how=How.NAME ,using= "q")
    public WebElement searchBox;
    
    @FindBy(how=How.ID ,using= "result-stats")
    public WebElement searchResultStatData;

    public String SearchQuery(String query){  
        searchBox.click();
        searchBox.sendKeys(query);
        return searchResultStatData.getText();
    
    }




}
