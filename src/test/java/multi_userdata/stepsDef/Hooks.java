package multi_userdata.stepsDef;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import multi_userdata.base.DriverManager;
import multi_userdata.base.PageObjectManager;
import multi_userdata.base.ScenarioContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    
	private WebDriver driver;
    private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
    
    public String configReader(){
		FileReader reader;
		Properties prop;
		String browsers=null;
		
		try {
			reader = new FileReader(".\\src\\test\\resources\\proj.properties");
		    prop = new Properties();
			prop.load(reader);
			browsers = prop.getProperty("browser.name");
			System.out.println("browser.name:"+browsers);   
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        return browsers;	

	}

    @Before
    public void startScenario() throws Exception{
		this.driver = new DriverManager().initDriver(configReader().toString());
        pageObjectManager =new PageObjectManager(this.driver);
		scenarioContext = new ScenarioContext();
    }

    @After
	public void afterScenario(){
		System.out.println("Its after All ");
		this.driver.close();
		this.driver.quit();
	}

	// @AfterAll
    // public static void afterAllQuit(Scenario scenario) throws IOException {
    //     // if(scenario.isFailed()){
    //     //     byte[] screenshot = this.driver.getScreenshotAs(OutputType.BYTES);
    //     //     scenario.attach(screenshot, "image/png", scenario.getName());
    //     // }

	// 	Runtime runtime = Runtime.getRuntime();
    //     try {
    //        runtime.exec("cmd.exe /c start cmd.exe /k \"taskkill /IM chromedriver.exe /F");
    //        Thread.sleep(3000);
    //     }catch (IOException | InterruptedException e) {
    //        e.printStackTrace();
    //     }
	// }

    public WebDriver getWebDriverManager() throws Exception {
		return this.driver;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	
    
}
