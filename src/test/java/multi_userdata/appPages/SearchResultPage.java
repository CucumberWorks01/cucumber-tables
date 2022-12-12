package multi_userdata.appPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    WebDriver driver;
    public SearchResultPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @FindBy(how=How.ID ,using= "result-stats")
    public WebElement searchResultStat;
    
    @FindBy(how=How.CSS,using="h3.LC20lb.MBeuO.DKV0Md")
    public List<WebElement> searchLinks;

    public String getResultStat(){  
       return searchResultStat.getText();
    }

    




}
