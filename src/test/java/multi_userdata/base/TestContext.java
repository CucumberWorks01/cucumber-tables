// package example.hooks.base;


// import java.io.FileReader;
// import java.io.IOException;
// import java.util.Properties;

// import io.cucumber.java.After;

// public class TestContext {
// 	// private WebDriverManager webDriverManager;

// 	public TestContext() throws Exception{
//         pageObjectManager =new PageObjectManager(new DriverManager().initDriver(configReader().toString()));
// 		scenarioContext = new ScenarioContext();
// 	}
	
// 	private PageObjectManager pageObjectManager;
// 	public ScenarioContext scenarioContext;


//     public String configReader(){
// 		FileReader reader;
// 		Properties prop;
// 		String browsers=null;
		
// 		try {
// 			reader = new FileReader(".\\src\\test\\resources\\proj.properties");
// 		    prop = new Properties();
// 			prop.load(reader);
// 			browsers = prop.getProperty("browser.name");
// 			System.out.println("browser.name:"+browsers);   
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}
		
//         return browsers;	

// 	}


	
	
	
// 	public DriverManager getWebDriverManager() throws Exception {
// 		return new DriverManager();
// 	}
	
// 	public PageObjectManager getPageObjectManager() {
// 		return pageObjectManager;
// 	}
	
// 	public ScenarioContext getScenarioContext() {
// 		return scenarioContext;
// 	}

// 	@After()
// 	public void afterScenario(){
// 		new DriverManager().closeBrowser();
// 	}

// }