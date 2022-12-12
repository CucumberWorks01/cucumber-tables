package multi_userdata.stepsDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import multi_userdata.appPages.SearchPage;
import multi_userdata.base.Context;
import multi_userdata.stepsDef.Hooks;

public class SearchSteps {

    Hooks testContext;
	SearchPage searchP;
	String resultStat;
	
	public SearchSteps(Hooks context) {
		testContext = context;
		searchP = testContext.getPageObjectManager().search_page();
	}

	@Given("^go to url$")
	public void f1() {
		// String productName = productListingPage.getProductName(0); 
		// testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);
	    
	}

    @When("enter search data")
    public void f2(){
	    resultStat= searchP.SearchQuery("hello world\n");
		
    }

	@And("get result stat")
	public void f3(){
		testContext.scenarioContext.setContext(Context.APP_DATA, resultStat);
	}
}
    

