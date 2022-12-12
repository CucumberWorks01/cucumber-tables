package multi_userdata.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    
   private WebDriver driver;
   public DriverManager(){
   }

   public WebDriver initDriver(String browser_name){ 
       
       switch(browser_name.toLowerCase()){
          case"chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;

          case"firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            return driver;
          default:
            System.out.println("No browser is defined");
            return null;
            // throw new Exception("No webdriver is defined");
       }
   }
   
   
   public void closeBrowser(){
      driver.quit(); 
   }

   public WebDriver getWebDriver(){
        return driver;
   }





}
